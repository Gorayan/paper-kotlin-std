plugins {
    kotlin("jvm").version("1.5.32")
    `maven-publish`
}

val group = "net.gorayan.mc"
val libraryVersion = "0.0.0"

val publishRepository = "https://maven.pkg.github.com/Gorayan/paper-kotlin-utils"

repositories {

    mavenCentral()

    maven {
        name = "Paper"
        url = uri("https://papermc.io/repo/repository/maven-public/")
    }

}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.17.1-R0.1-SNAPSHOT")
}

publishing {
    repositories {
        maven {

            name = "GitHubPackages"
            url = uri(publishRepository)

            credentials {

                val props = org.jetbrains.kotlin.konan.properties.loadProperties("${projectDir}/private.properties")

                username = props.getProperty("gpr.user") ?: System.getenv("USERNAME")
                password = props.getProperty("gpr.key") ?: System.getenv("TOKEN")

            }
        }
    }
    publications {

        register<MavenPublication>("gpr") {
            groupId = group
            artifactId = "paper-kotlin-utils"
            version = libraryVersion
            from(components["java"])
        }
    }
}
