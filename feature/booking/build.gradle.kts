plugins {
    id(Plugins.library)
    id(Plugins.android)
    id(Plugins.parcelize)
}

android {
    namespace = "com.zhigaras.booking"
    compileSdk = Config.compileSdk
    
    defaultConfig {
        minSdk = Config.minSdk
        
        testInstrumentationRunner = Config.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
    }
    
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = Config.javaVersion
        targetCompatibility = Config.javaVersion
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
    buildFeatures { viewBinding = true }
}

dependencies {
    
    implementation(project(":core"))
    implementation(project(":uiKit"))
    implementation(project(":cloudService"))
    implementation(project(":adapterDelegate"))
    implementation(project(":feature:ordered"))
    
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.appcompat)
    implementation(Dependencies.material)
    implementation(Dependencies.lificycle)
    implementation(Dependencies.koinAndroid)
}