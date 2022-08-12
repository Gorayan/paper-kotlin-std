plugins {
    kotlin("jvm").version("1.6.21")
}

group = "met.gorayan.mc"
version = "0.0.0"

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
