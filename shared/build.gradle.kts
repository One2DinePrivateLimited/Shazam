import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    val xcf = XCFramework()
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            xcf.add(this)
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here

            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.kotlinx.serialization.json)


            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.client.logging)


            implementation(libs.ktor.client.logging)
            implementation(libs.multiplatform.settings.no.arg)

            implementation("io.ktor:ktor-client-core:2.0.0")
            implementation("io.ktor:ktor-client-json:2.0.0")
            implementation("io.ktor:ktor-client-serialization:2.0.0")
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0")
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }



    }
}

android {
    namespace = "com.saxena.shazam"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
