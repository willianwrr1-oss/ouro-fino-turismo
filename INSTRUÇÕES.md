# 📱 Instruções de Compilação - Ouro Fino Turismo

## 🎯 Objetivo

Gerar o arquivo APK (aplicativo instalável) do app Ouro Fino Turismo para Android 15+.

---

## ✅ Pré-requisitos

Antes de começar, você precisa ter:

### 1️⃣ Android Studio
- Baixe em: https://developer.android.com/studio
- Versão mínima: **2023.1.1**

### 2️⃣ JDK 17
- Incluído no Android Studio (recomendado)
- Ou baixe em: https://www.oracle.com/java/technologies/downloads/

### 3️⃣ SDK Android 35+
- Instalado automaticamente durante setup do Android Studio

### 4️⃣ Git (opcional, mas recomendado)
- Baixe em: https://git-scm.com/

---

## 🚀 Passo 1: Clonar ou Baixar o Projeto

### Opção A: Via Git (Recomendado)
```bash
git clone https://github.com/seu-usuario/ouro-fino-turismo.git
cd ouro-fino-turismo
```

### Opção B: Download Manual
1. Clique em **Code** (verde) no GitHub
2. Selecione **Download ZIP**
3. Extraia o arquivo
4. Abra o terminal na pasta extraída

---

## 🏗️ Passo 2: Abrir no Android Studio

### Método 1: Via Android Studio
1. Abra **Android Studio**
2. Clique em **File → Open**
3. Selecione a pasta `ouro-fino-turismo`
4. Clique em **OK**
5. Aguarde o Gradle sincronizar (pode levar alguns minutos)

### Método 2: Linha de comando
```bash
# No diretório do projeto
android-studio .
```

---

## 🔑 Passo 3: Configurar Chave do Google Maps (Opcional)

Se quiser usar mapas integrados:

1. Acesse: https://console.cloud.google.com/
2. Crie um novo projeto
3. Ative a API **Maps SDK for Android**
4. Crie uma chave de API
5. Edite `app/src/main/AndroidManifest.xml`
6. Substitua `YOUR_GOOGLE_MAPS_API_KEY_HERE` pela sua chave

---

## ⚙️ Passo 4: Compilar o Projeto

### Via Android Studio:
1. Clique em **Build → Clean Project**
2. Clique em **Build → Rebuild Project**
3. Aguarde até "Build Successful"

### Via Terminal:
```bash
./gradlew clean build
```

---

## 📦 Passo 5: Gerar o APK

### Opção A: APK em Modo Release (Recomendado para Produção)
```bash
./gradlew assembleRelease
```

**Resultado**: `app/build/outputs/apk/release/app-release.apk`

### Opção B: APK em Modo Debug (Para Teste)
```bash
./gradlew assembleDebug
```

**Resultado**: `app/build/outputs/apk/debug/app-debug.apk`

### Opção C: Via Android Studio (Visual)
1. Clique em **Build → Build Bundle(s) / APK(s) → Build APK(s)**
2. Aguarde a conclusão
3. Uma notificação aparecerá com link para os arquivos

---

## 📂 Onde Encontrar os APKs

Após a compilação:

```
ouro-fino-turismo/
└── app/
    └── build/
        └── outputs/
            └── apk/
                ├── debug/
                │   └── app-debug.apk
                └── release/
                    └── app-release.apk
```

---

## 📱 Passo 6: Instalar no Dispositivo

### Método 1: Conectar via USB
1. Conecte um dispositivo Android via USB
2. Habilite **Modo de Desenvolvedor** (toque 7x em "Versão do Build")
3. Habilite **Depuração USB**
4. No Android Studio: **Run → Run 'app'**

### Método 2: Instalar APK Manualmente
1. Transferir o APK para o dispositivo
2. Navegar até o arquivo no gerenciador de arquivos
3. Tocar para instalar
4. Consentir com as permissões

### Método 3: Via ADB (Linha de Comando)
```bash
adb install app/build/outputs/apk/debug/app-debug.apk
```

---

## 🔄 GitHub Actions - Compilação Automática

O repositório está configurado para compilar automaticamente:

### Acessar os Builds
1. Vá ao repositório GitHub
2. Clique na aba **Actions**
3. Selecione o workflow mais recente
4. Baixe os artefatos (APKs) em **Artifacts**

### Configurar Releases Automáticos
Para gerar APKs em releases:
```bash
# Crie uma tag
git tag -a v1.0.0 -m "Versão 1.0.0"

# Envie a tag
git push origin v1.0.0
```

O GitHub Actions criará automaticamente uma release com os APKs.

---

## ✔️ Verificação de Sucesso

Após a compilação, confirme:

- ✅ Arquivo APK criado (tamanho > 5MB)
- ✅ Sem erros no console
- ✅ Instalação bem-sucedida no dispositivo
- ✅ App abre corretamente
- ✅ Telas carregam sem travamentos

---

## 🐛 Troubleshooting (Solução de Problemas)

### Problema: "Gradle build failed"
```bash
# Solução:
./gradlew clean
./gradlew build
```

### Problema: "No SDK found"
1. File → Project Structure → SDK Location
2. Configure o caminho correto do SDK Android

### Problema: "Gradle not found"
```bash
# Certifique-se de estar no diretório correto
cd ouro-fino-turismo
./gradlew assembleDebug
```

### Problema: Erro de permissões
```bash
# Linux/Mac
chmod +x gradlew

# Execute novamente
./gradlew assembleDebug
```

---

## 📊 Informações da Compilação

| Item | Detalhes |
|------|----------|
| **Linguagem** | Kotlin |
| **Framework** | Jetpack Compose |
| **Min SDK** | 35 (Android 15.0) |
| **Target SDK** | 35 |
| **Tamanho Aprox.** | 15-20 MB |

---

## 🎉 Próximos Passos

Depois de gerar o APK:

1. **Testar** em múltiplos dispositivos
2. **Publicar** na Google Play Store (opcional)
3. **Compartilhar** com a comunidade
4. **Coletar feedback** dos usuários

---

## 📚 Recursos Adicionais

- [Documentação Android](https://developer.android.com/docs)
- [Jetpack Compose Docs](https://developer.android.com/jetpack/compose/documentation)
- [Material Design 3](https://m3.material.io/)
- [Google Maps SDK](https://developers.google.com/maps/documentation/android-sdk)

---

## 💬 Suporte

Dúvidas? Abra uma issue no GitHub:
- [Issues](https://github.com/seu-usuario/ouro-fino-turismo/issues)

---

**Boa sorte com sua compilação! 🚀**
