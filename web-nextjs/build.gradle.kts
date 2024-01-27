plugins { id("build.common.node-conventions") }

tasks.prepareEnv { dependsOn(tasks.npmInstall) }
