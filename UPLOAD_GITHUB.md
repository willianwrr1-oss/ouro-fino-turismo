# 📤 GUIA: Upload no GitHub em 5 Minutos

## ⚡ MÉTODO RÁPIDO (Recomendado)

### 1️⃣ Criar Repositório no GitHub

1. Acesse: **https://github.com/new**
2. Preencha:
   - **Repository name**: `ouro-fino-turismo`
   - **Description**: `Aplicativo Android de turismo de Ouro Fino, MG`
   - **Public/Private**: Escolha sua preferência
   - **NÃO inicialize** com README, .gitignore, ou license
3. Clique em **Create Repository**

---

### 2️⃣ Copiar as URLs Mostradas

O GitHub mostrará algo como:
```
git@github.com:SEU_USUARIO/ouro-fino-turismo.git
ou
https://github.com/SEU_USUARIO/ouro-fino-turismo.git
```

**Copie uma dessas URLs!**

---

### 3️⃣ Fazer Upload via Terminal

```bash
# Entre na pasta do projeto
cd /caminho/para/ouro-fino-turismo

# Configure Git (primeira vez)
git config --global user.name "Seu Nome"
git config --global user.email "seu.email@example.com"

# Inicialize repositório
git init

# Adicione todos os arquivos
git add .

# Faça o commit inicial
git commit -m "Commit inicial: Ouro Fino Turismo v1.0.0"

# Adicione o repositório remoto
# Substitua SEU_USUARIO pelo seu usuário do GitHub
git remote add origin https://github.com/SEU_USUARIO/ouro-fino-turismo.git

# Configure a branch main
git branch -M main

# Faça o push para GitHub
git push -u origin main
```

---

## ✅ PRONTO!

Seu repositório está no GitHub!

Acesse: `https://github.com/SEU_USUARIO/ouro-fino-turismo`

---

## 🎁 BÔNUS: Criar Release com APKs

Depois que estiver no GitHub, você pode criar releases automáticas:

```bash
# Crie uma tag (versão)
git tag -a v1.0.0 -m "Versão 1.0.0 - Release Inicial"

# Faça o push da tag
git push origin v1.0.0
```

GitHub Actions criará automaticamente uma **Release** com os APKs gerados! 🚀

---

## 🆘 PROBLEMAS COMUNS

### "fatal: not a git repository"
```bash
# Certifique-se que está no diretório correto:
cd /seu/caminho/para/ouro-fino-turismo
git init
```

### "Permission denied" (SSH)
Use HTTPS em vez de SSH:
```bash
git remote set-url origin https://github.com/SEU_USUARIO/ouro-fino-turismo.git
```

### "Your push would publish a private email"
Desabilite emails privados no GitHub:
- Settings → Email → Desmarque "Keep my email address private"

---

## 📊 O QUE SERÁ ENVIADO

```
ouro-fino-turismo/
├── Código Kotlin (8 arquivos)
├── Recursos XML (11 arquivos)
├── Configuração Gradle (3 arquivos)
├── GitHub Actions workflow
├── Documentação (7 arquivos)
└── Licença MIT
```

**Total**: 35 arquivos | 300 KB

---

## 🔐 Verificar no GitHub

Após fazer push:

1. Acesse seu repositório
2. Veja os arquivos listados
3. Verifique a aba **Actions** (GitHub Actions)
4. Espere o build completar
5. Baixe os APKs gerados em **Artifacts**

---

## 🎯 PRÓXIMA ENTREGA

Após cada mudança local:

```bash
# Edite/adicione arquivos...

git add .
git commit -m "Descrição da mudança"
git push origin main
```

---

**Pronto! Seu app está no GitHub! 🎉**
