package io.github.simonhauck.release.tasks

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

        log.info("Rebasing current branch...")
        gitCommandApi()
            .pullRebase()
            .onLeft { gitCommandHistoryApi.get().revertAllCommands() }
            .getOrThrowGradleException()
        log.info("Rebase complete")

        log.lifecycle("Pushing changes to remote repository...")
        gitCommandApi()
            .push()
            .onRight { gitCommandHistoryApi.get().flushCommands() }
            .onLeft { gitCommandHistoryApi.get().revertAllCommands() }
            .getOrThrowGradleException()

        log.lifecycle("Push complete.")
    }
}
