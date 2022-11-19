/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java project to get you started.
 * For more details take a look at the Java Quickstart chapter in the Gradle
 * User Manual available at https://docs.gradle.org/6.5/userguide/tutorial_java_projects.html
 */

plugins {
    // Apply the java plugin to add support for Java
    java

    // Apply the application plugin to add support for building a CLI application.
    application
}

repositories {
    // Use jcenter for resolving dependencies.
    // You can declare any Maven/Ivy/file repository here.
    mavenCentral()
}

dependencies {
    // This dependency is used by the application.
    implementation("com.google.guava:guava:29.0-jre")

    // Use JUnit test framework
    testImplementation("junit:junit:4.13")
}

tasks.jar {
    manifest {
        attributes(
            "Main-Class" to "Go"
        )
    }
}

sourceSets {
        main {
            resources {
                srcDirs("src")
            }
        }
}


application {
    // Define the main class for the application.
    mainClass.set("Go")
}
