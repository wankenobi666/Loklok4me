plugins {
    id("java-library")
    kotlin("jvm") version "1.5.31"
}

repositories {
    mavenCentral()
    google()
    jcenter()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation("com.github.recloudstream.cloudstream:cloudstream3:3.0.0")
}