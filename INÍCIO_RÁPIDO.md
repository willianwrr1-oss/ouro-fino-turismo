# ⚡ Início Rápido (5 minutos)

## 📥 1. Prepare seu Computador

```bash
# Instale:
# - Java 17: https://www.oracle.com/java/technologies/downloads/
# - Android Studio: https://developer.android.com/studio
# - Git: https://git-scm.com/
```

---

## 📂 2. Abra o Projeto

```bash
# Opção A: Abra no Android Studio
# File → Open → Selecione a pasta ouro-fino-turismo

# Opção B: Via terminal
cd /caminho/para/ouro-fino-turismo
android-studio .
```

---

## 🔨 3. Compile o APK

### Via Terminal (Recomendado):
```bash
# APK para teste
./gradlew assembleDebug

# APK para produção
./gradlew assembleRelease
```

### Via Android Studio:
```
Build → Build Bundle(s) / APK(s) → Build APK(s)
```

**Resultado**: APK em `app/build/outputs/apk/`

---

## 📱 4. Instale no Celular

### Opção A: Transferir arquivo
1. Copie o `.apk` para seu celular
2. Abra com gerenciador de arquivos
3. Toque para instalar

### Opção B: Conectar via USB
1. Conecte celular via USB
2. Ative "Modo de Desenvolvedor"
3. No Android Studio: `Run → Run 'app'`

---

## 🚀 5. Publique no GitHub

```bash
# Configure Git
git config --global user.name "Seu Nome"
git config --global user.email "seu.email@example.com"

# Crie repositório em GitHub:
# https://github.com/new

# No projeto:
git init
git add .
git commit -m "Commit inicial: Ouro Fino Turismo v1.0"
git remote add origin https://github.com/SEU_USUARIO/ouro-fino-turismo.git
git branch -M main
git push -u origin main

# Crie primeira release:
git tag -a v1.0.0 -m "Versão 1.0.0"
git push origin v1.0.0
```

---

## ✅ Pronto!

Seu app está:
- ✅ Compilado
- ✅ Instalado
- ✅ No GitHub
- ✅ Com build automático ativo

---

## 📚 Documentação Completa

| Arquivo | Descrição |
|---------|-----------|
| `README.md` | Visão geral do projeto |
| `INSTRUÇÕES.md` | Guia detalhado passo a passo |
| `GITHUB_SETUP.md` | Publicação no GitHub |
| `RESUMO_PROJETO.md` | Resumo completo |

---

## 🎯 Próximos Passos (Opcional)

1. **Configurar Google Maps**
   - Obter chave em: https://console.cloud.google.com/
   - Adicionar em `AndroidManifest.xml`

2. **Publicar na Google Play**
   - Criar conta em: https://play.google.com/console
   - Enviar APK release

3. **Adicionar mais pontos turísticos**
   - Editar `LocalDataRepository.kt`
   - Adicionar novas descrições

---

## 🆘 Problemas Comuns

| Problema | Solução |
|----------|---------|
| "Gradle not found" | `chmod +x gradlew` (Mac/Linux) |
| "Build failed" | `./gradlew clean build` |
| "No SDK found" | Settings → SDK → Configure SDK path |

---

**Mais detalhes?** Leia `INSTRUÇÕES.md` e `README.md`

**Boa sorte! 🚀**
