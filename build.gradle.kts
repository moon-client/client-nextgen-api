plugins {
    id("maven-publish")
    id("fabric-loom") version "1.8-SNAPSHOT"
    id("com.peterabeles.gversion") version "1.10.2"
    id("net.kyori.indra.license-header") version "3.1.3"
}

val minecraftVersion = "1.21.3"
val loaderVersion = "0.16.9"
val fabricVersion = "0.109.0+1.21.3"
val yarnVersion = "1.21.3+build.2"

group = "com.moon.client"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://libraries.minecraft.net/")
    maven {
        name = "moonPublicRepo"
        url = uri("https://repo.lennoxlotl.dev/moon-public")
    }
}

dependencies {
    minecraft("com.mojang:minecraft:$minecraftVersion")
    mappings("net.fabricmc:yarn:$yarnVersion:v2")
    modImplementation("net.fabricmc:fabric-loader:$loaderVersion")
    modImplementation("net.fabricmc.fabric-api:fabric-api:$fabricVersion")

    implementation("io.github.llamalad7:mixinextras-fabric:0.5.0-beta.4")
    annotationProcessor("io.github.llamalad7:mixinextras-fabric:0.5.0-beta.4")
    include("io.github.llamalad7:mixinextras-fabric:0.5.0-beta.4")

    implementation("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")

    implementation("net.kyori:adventure-api:4.17.0")
    implementation("net.kyori:adventure-text-minimessage:4.17.0")
    implementation("net.kyori:adventure-text-serializer-gson:4.17.0")
    implementation("net.kyori:adventure-text-serializer-legacy:4.17.0")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
    withSourcesJar()
    withJavadocJar()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
    repositories {
        maven {
            name = "moonPublicRepo"
            url = uri("https://repo.lennoxlotl.dev/moon-public")
            credentials(PasswordCredentials::class)
        }
    }
}

tasks.compileJava {
    // Automatically insert license header
    dependsOn(tasks.licenseFormat)
}

tasks.withType<JavaCompile> { options.encoding = "UTF-8" }
tasks.withType<Test> { defaultCharacterEncoding = "UTF-8" }
tasks.withType<Javadoc> {
    options.encoding = "UTF-8"
    (options as StandardJavadocDocletOptions).tags("apiNote", "implNote")
}
