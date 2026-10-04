# 🚀 Publicar no GitHub - Guia Passo a Passo

## 1. Criar Repositório no GitHub

### Opção A: Via Website (Recomendado)
1. Acesse: https://github.com/new
2. Preencha os dados:
   - **Repository name**: `ouro-fino-turismo`
   - **Description**: `Aplicativo Android de turismo de Ouro Fino, MG`
   - **Visibility**: Public ou Private (sua escolha)
   - **Initialize**: NÃO marque nenhuma opção

3. Clique em **Create Repository**

### Opção B: Via GitHub CLI
```bash
gh repo create ouro-fino-turismo --public --description "Aplicativo Android de turismo de Ouro Fino, MG"
```

---

## 2. Configurar Git Localmente

Antes de fazer o push, configure suas credenciais:

```bash
git config --global user.name "Seu Nome"
git config --global user.email "seu.email@example.com"
```

---

## 3. Fazer o Push para GitHub

### No diretório do projeto:

```bash
# 1. Inicializar repositório local (se ainda não estiver)
git init

# 2. Adicionar todos os arquivos
git add .

# 3. Commit inicial
git commit -m "Commit inicial: App Ouro Fino Turismo"

# 4. Adicionar repositório remoto
# Substitua SEU_USUARIO pelo seu usuário do GitHub
git remote add origin https://github.com/SEU_USUARIO/ouro-fino-turismo.git

# 5. Fazer o push para a branch main
git branch -M main
git push -u origin main
```

---

## 4. Verificar no GitHub

1. Acesse seu repositório: `https://github.com/SEU_USUARIO/ouro-fino-turismo`
2. Confirme que todos os arquivos foram enviados
3. Verifique se a aba **Actions** mostra o workflow de build

---

## 5. Habilitar GitHub Actions (se necessário)

1. Vá para a aba **Settings** do repositório
2. Selecione **Actions** no menu lateral
3. Clique em **General**
4. Certifique-se de que **Allow all actions and reusable workflows** está selecionado

---

## 6. Criar Releases Automáticas

Para que o GitHub Actions crie releases automaticamente:

```bash
# Criar uma tag (versão)
git tag -a v1.0.0 -m "Versão 1.0.0 - Release Inicial"

# Fazer o push da tag
git push origin v1.0.0
```

Isso acionará o workflow e criará automaticamente uma release com os APKs.

---

## 7. Atualizações Futuras

Para enviar mudanças ao repositório:

```bash
# Fazer as alterações no código...

# Adicionar mudanças
git add .

# Fazer commit
git commit -m "Descrição da alteração"

# Fazer push
git push origin main
```

---

## 🔐 Autenticação no GitHub

### Via HTTPS (Recomendado)
```bash
# Na primeira vez, o Git solicitará sua senha
# Use seu token pessoal do GitHub, não sua senha
```

#### Criar um Token Pessoal:
1. GitHub → Settings → Developer Settings → Personal Access Tokens
2. Clique em **Generate New Token**
3. Selecione escopos: `repo` e `workflow`
4. Copie o token e use como senha

### Via SSH (Avançado)
```bash
# Gerar chave SSH
ssh-keygen -t ed25519 -C "seu.email@example.com"

# Adicionar chave ao ssh-agent
eval "$(ssh-agent -s)"
ssh-add ~/.ssh/id_ed25519

# Copiar a chave pública
# Depois adicionar em GitHub → Settings → SSH Keys
```

---

## 📊 Acompanhar Builds Automáticos

### Na aba Actions:
1. Clique na aba **Actions** do repositório
2. Veja os workflows executados
3. Clique em um workflow para ver os detalhes
4. Baixe os APKs gerados em **Artifacts**

---

## 🔧 Resolução de Problemas

### Erro: "fatal: not a git repository"
```bash
# Solução
cd /caminho/do/ouro-fino-turismo
git init
```

### Erro: "Permission denied (publickey)"
```bash
# Solução: Use HTTPS em vez de SSH
git remote set-url origin https://github.com/SEU_USUARIO/ouro-fino-turismo.git
```

### Erro: "Your push would publish a private email address"
```bash
# Solução: Desabilite email privado no GitHub
# Settings → Email → Desabilite "Keep my email address private"
```

---

## 📝 Exemplo Completo (Copie e Adapte)

```bash
# Abrir terminal no diretório do projeto
cd ~/ouro-fino-turismo

# Configurar Git
git config --global user.name "Seu Nome"
git config --global user.email "seu.email@example.com"

# Inicializar repositório
git init
git add .
git commit -m "Commit inicial: App Ouro Fino Turismo"

# Adicionar repositório remoto
git remote add origin https://github.com/SEU_USUARIO/ouro-fino-turismo.git
git branch -M main
git push -u origin main

# Criar primeira release
git tag -a v1.0.0 -m "Versão 1.0.0 - Release Inicial"
git push origin v1.0.0
```

---

## 📚 Links Úteis

- [Documentação Git](https://git-scm.com/doc)
- [GitHub Docs](https://docs.github.com)
- [GitHub Actions](https://github.com/features/actions)
- [Personal Access Tokens](https://github.com/settings/tokens)

---

**Pronto! Seu projeto está no GitHub! 🎉**

Agora você pode compartilhar o link com outras pessoas e eles conseguem clonar seu repositório:

```bash
git clone https://github.com/SEU_USUARIO/ouro-fino-turismo.git
```
