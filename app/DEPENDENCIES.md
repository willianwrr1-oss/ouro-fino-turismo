# Dependências - Ouro Fino Turismo

## Core Android

```kotlin
implementation("androidx.core:core-ktx:1.12.0")
implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
implementation("androidx.activity:activity-compose:1.8.1")
```

## Compose (BOM 2023.10.01)

```kotlin
implementation(platform("androidx.compose:compose-bom:2023.10.01"))
implementation("androidx.compose.ui:ui")
implementation("androidx.compose.ui:ui-graphics")
implementation("androidx.compose.ui:ui-tooling-preview")
implementation("androidx.compose.material3:material3:1.1.2")
```

## Navigation

```kotlin
implementation("androidx.navigation:navigation-compose:2.7.5")
```

## Images & Coil

```kotlin
implementation("io.coil-kt:coil-compose:2.5.0")
```

## Google Maps

```kotlin
implementation("com.google.maps.android:maps-compose:4.3.1")
implementation("com.google.android.gms:play-services-maps:18.2.0")
```

## Testing

```kotlin
testImplementation("junit:junit:4.13.2")
androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
androidTestImplementation("androidx.compose.ui:ui-test-junit4")
debugImplementation("androidx.compose.ui:ui-tooling")
debugImplementation("androidx.compose.ui:ui-test-manifest")
```

## Configuração Gradle

```kotlin
android {
    compileSdk = 35
    
    defaultConfig {
        applicationId = "com.willian.ourofino"
        minSdk = 35
        targetSdk = 35
        versionCode = 1
        versionName = "1.0.0"
    }
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    
    kotlinOptions {
        jvmTarget = "17"
    }
    
    buildFeatures {
        compose = true
    }
    
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.7"
    }
}
```

## Versões

- **Kotlin**: 1.9.20
- **Compose Compiler**: 1.5.7
- **Java**: 17
- **Android SDK**: 35

## Como Adicionar Novas Dependências

1. Abra `app/build.gradle.kts`
2. Adicione a dependência na seção `dependencies {}`
3. Execute: `./gradlew build`
4. Sincronize o projeto no Android Studio

```kotlin
dependencies {
    implementation("com.example:library:version")
}
```
