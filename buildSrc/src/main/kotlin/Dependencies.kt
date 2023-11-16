object Dependencies {
    
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val koinAndroid = "io.insert-koin:koin-android:${Versions.koin}"
    const val lificycle = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val refrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    
    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val androidJUnit = "androidx.test.ext:junit:${Versions.androidJUnit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    
    object Versions {
        
        const val coreKtx = "1.12.0"
        const val appcompat = "1.6.1"
        const val material = "1.10.0"
        const val koin = "3.5.0"
        const val lifecycle = "2.6.1"
        const val recyclerView = "1.3.1"
        const val retrofit = "2.9.0"
        const val loggingInterceptor = "5.0.0-alpha.2"
        const val glide = "4.16.0"
        
        const val jUnit = "4.13.2"
        const val androidJUnit = "1.1.5"
        const val espresso = "3.5.1"
    }
}