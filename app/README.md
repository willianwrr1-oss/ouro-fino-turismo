# App Module - Ouro Fino Turismo

Módulo principal do aplicativo Ouro Fino Turismo.

## Estrutura

```
app/
├── src/main/
│   ├── java/com/willian/ourofino/
│   │   ├── MainActivity.kt
│   │   ├── ui/
│   │   │   ├── OuroFinoApp.kt
│   │   │   └── screens/
│   │   │       ├── HomeScreen.kt
│   │   │       ├── HistoryScreen.kt
│   │   │       ├── AttractionsScreen.kt
│   │   │       ├── MapScreen.kt
│   │   │       └── AboutScreen.kt
│   │   └── data/
│   │       ├── model/
│   │       │   └── PontoTuristico.kt
│   │       └── repository/
│   │           └── LocalDataRepository.kt
│   ├── res/
│   │   ├── values/
│   │   ├── values-en/
│   │   ├── drawable/
│   │   └── xml/
│   └── AndroidManifest.xml
├── build.gradle.kts
└── proguard-rules.pro
```

## Build

```bash
# Debug
./gradlew :app:assembleDebug

# Release
./gradlew :app:assembleRelease
```

## Testes

```bash
./gradlew :app:test
./gradlew :app:connectedAndroidTest
```

## Dependências Principais

- Jetpack Compose
- Material Design 3
- Google Maps Compose
- Coil (Image Loading)
- Navigation Compose

## Configuração

- **Target SDK**: 35
- **Min SDK**: 35
- **Language**: Kotlin 1.9.20
- **Compose**: 1.5.7
