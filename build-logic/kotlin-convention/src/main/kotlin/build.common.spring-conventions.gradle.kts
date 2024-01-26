
plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")

    kotlin("plugin.spring")
}

springBoot {
    // If the time always changes, the task can not be cached
    buildInfo { excludes.set(listOf("time")) }
}

//configurations {
//    compileOnly {
//        extendsFrom(configurations.annotationProcessor.get())
//    }
//}

