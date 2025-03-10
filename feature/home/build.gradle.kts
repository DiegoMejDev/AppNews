import ext.implementation

plugins {
    id(ModulePlugin.MODULE_NAME)
}

android {
    namespace = "com.raven.home"

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {
    di()
    general()
    testing()
    network()

    implementation(project(":core"))
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
}
