package com.github.simonhauck.git

import com.github.simonhauck.git.process.ProcessConfig
import com.github.simonhauck.git.process.ProcessResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import java.io.File

class GitCommandWrapperTest {

    @TempDir lateinit var tempDir: File
    private lateinit var gitCommandWrapper: GitCommandWrapper

    @BeforeEach
    fun setup() {
        gitCommandWrapper = GitCommandWrapper(config = ProcessConfig(workingDir = tempDir))
    }

    @Test
    fun `can create a git repository and correctly return the status`() {
        val result = gitCommandWrapper.gitInit()
        assertThat(result).isEqualTo(ProcessResult.OK(0))

        val actual = gitCommandWrapper.gitStatus()
        assertThat(actual).isEqualTo(ProcessResult.OK(0))
    }

    @Test
    fun `check that the git command fails if no git repository is available`() {
        val actual = gitCommandWrapper.gitStatus()

        assertThat(actual.exitCode).isEqualTo(128)
    }
}
