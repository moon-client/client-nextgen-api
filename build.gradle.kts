plugins {
    id("maven-publish")
    id("net.fabricmc.fabric-loom") version "1.18.4"
    id("com.peterabeles.gversion") version "1.10.2"
    // PORT(26.2): indra license-header 3.x is not Gradle 9 compatible and no
    // Gradle-9-ready release exists yet. It only stamps license headers (see
    // license_header.txt), so it is dropped on the port branch. Re-add when a
    // compatible version ships, or apply headers manually before publishing.
}

val minecraftVersion: String by extra
val loaderVersion: String by extra
val fabricVersion: String by extra

group = "com.moon.client"
version = "0.0.5-SNAPSHOT"

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
    implementation("net.fabricmc:fabric-loader:$loaderVersion")
    implementation("net.fabricmc.fabric-api:fabric-api:$fabricVersion")

    implementation("io.github.llamalad7:mixinextras-fabric:0.5.0-beta.4")
    annotationProcessor("io.github.llamalad7:mixinextras-fabric:0.5.0-beta.4")
    include("io.github.llamalad7:mixinextras-fabric:0.5.0-beta.4")

    implementation("org.projectlombok:lombok:1.18.46")
    annotationProcessor("org.projectlombok:lombok:1.18.46")

    implementation("net.kyori:adventure-api:4.17.0")
    implementation("net.kyori:adventure-text-minimessage:4.17.0")
    implementation("net.kyori:adventure-text-serializer-gson:4.17.0")
    implementation("net.kyori:adventure-text-serializer-legacy:4.17.0")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
    withSourcesJar()
    withJavadocJar()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = project.group.toString()
            artifactId = project.name
            version = project.version.toString()

            // PORT(26.2): the no-remap loom plugin has no remapJar task, and since Minecraft
            // is unobfuscated there is no separate "dev" (named) jar any more - the plain jar
            // already carries mojmap names. Consumers depend on the default artifact.
            artifact(tasks.named("jar"))
            artifact(tasks.named("sourcesJar"))
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

// PORT(26.2): licenseFormat came from the dropped indra license-header plugin
//tasks.compileJava {
//    // Automatically insert license header
//    dependsOn(tasks.licenseFormat)
//}

tasks.withType<JavaCompile> { options.encoding = "UTF-8" }
tasks.withType<Test> { defaultCharacterEncoding = "UTF-8" }
tasks.withType<Javadoc> {
    options.encoding = "UTF-8"
    (options as StandardJavadocDocletOptions).tags("apiNote", "implNote")
}
