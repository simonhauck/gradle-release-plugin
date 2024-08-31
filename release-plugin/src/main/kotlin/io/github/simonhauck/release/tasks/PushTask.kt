package io.github.simonhauck.release.tasks

import io.github.simonhauck.release.git.api.RevertCommand
import java.time.Duration
import org.gradle.api.logging.Logging
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.TaskAction

abstract class PushTask : BaseReleaseTask(), GitTask {
    private val log = Logging.getLogger(PushTask::class.java)

    @get:Input @get:Optional abstract val disablePush: Property<Boolean>
    @get:Input @get:Optional abstract val delayBeforePush: Property<Duration>

    init {
        description = "Pushes the changes to the remote repository."
    }

    @TaskAction
    fun push() {
        if (disablePush.getOrElse(false)) {
            log.lifecycle("Push is disabled by configuration.")
            gitCommandHistoryApi.get().flushCommands()
            return
        }

        val delay: Duration = delayBeforePush.getOrElse(Duration.ZERO)
        if (!delay.isZero)
            log.lifecycle("Delay before push is set to ${delay.seconds}s. Waiting...")

        Thread.sleep(delay.toMillis())

        whileLocalChangesAreStashed {
            log.info("Rebasing current branch...")
            gitCommandApi().pullRebase().revertHistoryOnError().getOrThrowGradleException()
            log.info("Rebase complete")
        }

        log.lifecycle("Pushing changes to remote repository...")
        gitCommandApi()
            .push()
            .onRight { gitCommandHistoryApi.get().flushCommands() }
            .onLeft { gitCommandHistoryApi.get().revertAllCommands() }
            .getOrThrowGradleException()

        log.lifecycle("Push complete.")
    }

    private fun whileLocalChangesAreStashed(whileStash: () -> Unit): Unit {
        val status = gitCommandApi().status().revertHistoryOnError().getOrThrowGradleException()
        if (status.staged.isEmpty() && status.unstaged.isEmpty()) {
            return whileStash()
        }

        log.info("Stashing local changes...")
        gitCommandApi()
            .stash(includeUntracked = false)
            .registerRevertCommandOnSuccess(
                RevertCommand("Restoring changes from stash") { gitCommandApi().stashPop() })
            .revertHistoryOnError()
            .getOrThrowGradleException()

        whileStash()

        log.info("Restoring local changes...")
        gitCommandApi()
            .stashPop()
            .onRight { gitCommandHistoryApi.get().dropLastRevertCommand() }
            .getOrThrowGradleException()
    }
}
