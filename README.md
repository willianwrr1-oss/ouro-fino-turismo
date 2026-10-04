# Ouro Fino Turismo 🏛️

Aplicativo Android moderno e profissional para explorar a história, cultura e atrações turísticas de **Ouro Fino, Minas Gerais**.

## ✨ Características

- 📱 **Interface moderna** com Material Design 3
- 🌍 **Histórico completo** desde a descoberta do ouro até os dias atuais
- 📍 **15+ pontos turísticos** com coordenadas GPS e descrições detalhadas
- 🗺️ **Integração com Google Maps** para localização e navegação
- 🌙 **Modo noturno automático** que se adapta às preferências do sistema
- 🌐 **Suporte multilíngue**: Português e Inglês
- 📸 **Galeria de imagens** dos principais pontos de interesse
- ⚡ **Compatível com Android 15+** (API 35+)

## 🎯 Categorias de Atrações

### Culturais
- **Monumento Menino da Porteira** - Icônico monumento de 10m
- **Monumento Boi Sem Coração** - Homenagem à música famosa
- **Casa do Café com Leite** - Sítio histórico de 1913
- **Pavilhão das Malhas** - Centro comercial têxtil
- **Praça do Berrante** - Espaço público sertanejo
- **Estátua de Luiz Gonzaga** - Tributo musical
- **Cinema Prof. Matilde Isabel** - Teatro histórico
- **Monumento do Bateador** - Ofício da mineração

### Naturais
- **Cachoeira do Tabuão** - Beleza natural incomparável
- **Pedra do Itaguaçu** - Formação rochosa panorâmica
- **Lagos dos Palomos** - Cenário tranquilo e bucólico
- **Jardim Municipal** - Espaço verde bem cuidado

### Religiosos
- **Santuário São Francisco de Paula** - Igreja Matriz histórica
- **Santo Cruzeiro** - Monumento espiritual

## 🏗️ Estrutura do Projeto

```
ouro-fino-turismo/
├── app/
│   ├── src/main/
│   │   ├── java/com/willian/ourofino/
│   │   │   ├── MainActivity.kt
│   │   │   ├── ui/
│   │   │   │   ├── OuroFinoApp.kt
│   │   │   │   └── screens/
│   │   │   │       ├── HomeScreen.kt
│   │   │   │       ├── HistoryScreen.kt
│   │   │   │       ├── AttractionsScreen.kt
│   │   │   │       └── AboutScreen.kt
│   │   │   └── data/
│   │   │       ├── model/
│   │   │       └── repository/
│   │   └── res/
│   └── build.gradle.kts
├── .github/workflows/
│   └── build-apk.yml
└── README.md
```

## 🚀 Como Usar

### 1. Clone o Repositório

```bash
git clone https://github.com/seu-usuario/ouro-fino-turismo.git
cd ouro-fino-turismo
```

### 2. Configure o Ambiente

Certifique-se de ter:
- **Android Studio** 2023.1.1 ou superior
- **JDK 17** ou superior
- **SDK Android 35+**

### 3. Configure a Chave do Google Maps (Opcional)

Para usar a integração completa com mapas:

1. Obtenha uma chave de API do Google Maps
2. Edite `app/src/main/AndroidManifest.xml`
3. Substitua `YOUR_GOOGLE_MAPS_API_KEY_HERE` pela sua chave

### 4. Compile o Projeto

```bash
# Via Gradle
./gradlew build

# Via Android Studio
Build > Make Project
```

### 5. Gere o APK

```bash
# APK Release (otimizado)
./gradlew assembleRelease

# APK Debug (desenvolvimento)
./gradlew assembleDebug
```

Os APKs estarão em:
- Release: `app/build/outputs/apk/release/app-release.apk`
- Debug: `app/build/outputs/apk/debug/app-debug.apk`

## 🔧 Compilação Automática no GitHub

Este projeto usa **GitHub Actions** para compilação automática. A cada push ou pull request, os APKs são gerados automaticamente.

### Acessar Builds Automáticos

1. Vá para a aba **Actions** do repositório
2. Clique no workflow **Build APK**
3. Baixe os artefatos (APK Debug e Release)

## 📋 Requisitos do Sistema

- **Android**: 15.0+ (API 35+)
- **RAM**: Mínimo 2GB
- **Armazenamento**: ~50MB
- **Conexão**: Internet (para imagens e mapas)

## 🎨 Tecnologias Utilizadas

- **Kotlin** - Linguagem de programação
- **Jetpack Compose** - Framework de UI moderno
- **Material Design 3** - Design system
- **Google Maps SDK** - Integração de mapas
- **Coil** - Carregamento de imagens
- **Gradle** - Sistema de build

## 📱 Screens Principais

- **Home** - Bem-vindo com informações gerais
- **História** - Timeline completa de Ouro Fino
- **Atrações** - Catálogo filtrado por categoria
- **Mapa** - Visualização geográfica dos pontos
- **Sobre** - Informações do aplicativo

## 🌍 Suporte de Idiomas

- 🇧🇷 Português (Brasil)
- 🇬🇧 English (United Kingdom)

Adicione mais idiomas criando arquivos em `res/values-<language>/strings.xml`

## 📊 Dados da Cidade

| Informação | Valor |
|----------|-------|
| **População** | 33.791 habitantes |
| **Altitude** | 908 metros |
| **Região** | Sul de Minas Gerais |
| **Estado** | Minas Gerais |
| **País** | Brasil |
| **Coordenadas** | 22°16′58″S 46°22′8″W |

## 🎵 Curiosidade

A música **"O Menino da Porteira"** (1955), de Teddy Vieira e Luís Raimundo, imortalizou Ouro Fino na cultura brasileira, tornando-a símbolo da tradição sertaneja mineira.

## 📄 Licença

Este projeto é de código aberto e pode ser utilizado livremente para fins educacionais e comerciais. Consulte o arquivo LICENSE para mais detalhes.

## 🤝 Contribuindo

Contribuições são bem-vindas! Siga os passos:

1. Fork o projeto
2. Crie uma branch para sua feature (`git checkout -b feature/MinhaFeature`)
3. Commit suas mudanças (`git commit -m 'Adiciona MinhaFeature'`)
4. Push para a branch (`git push origin feature/MinhaFeature`)
5. Abra um Pull Request

## 📞 Contato

Para dúvidas ou sugestões:
- 📧 Email: contato@ourofino.mg.gov.br
- 🌐 Site: [ourofino.mg.gov.br](http://www.ourofino.mg.gov.br)

## 🙏 Agradecimentos

Desenvolvido com ❤️ para a comunidade de Ouro Fino, Minas Gerais.

---

**Versão**: 1.0.0  
**Última atualização**: Outubro de 2026  
**Compatibilidade**: Android 15.0+
