# 📊 GitHub Activity CLI

Um utilitário de linha de comando (CLI) escrito em Java para visualizar as atividades recentes de qualquer usuário do GitHub diretamente no seu terminal.

## 🚀 Funcionalidades

- ✅ Buscar atividades recentes de qualquer usuário do GitHub
- ✅ Exibir até 10 eventos mais recentes
- ✅ Traduzir eventos técnicos para português compreensível
- ✅ Tratamento robusto de erros (usuário não encontrado, problemas de conexão)
- ✅ Interface simples e intuitiva via linha de comando

## 📦 Estrutura do Projeto

```
GitHubActivityCLI/
├── main/
│   └── src/
│       └── GitHubActivityCLI.java    # Código fonte principal
├── lib/
│   └── json-20231013.jar            # Biblioteca JSON para Java
├── out/                             # Arquivos compilados (.class)
└── run.bat                          # Script de execução (Windows)
```

## 🛠️ Pré-requisitos

- **Java JDK 8 ou superior**
- **Conexão com internet** (para acesso à API do GitHub)
- **GitHub User Agent** (já configurado no código)

## ⚡ Instalação Rápida

### 1. Clone ou baixe o projeto
```bash
git clone <url-do-repositorio>
cd GitHubActivityCLI
```

### 2. Baixe a biblioteca JSON
```bash
# Crie a pasta lib se não existir
mkdir lib

# Baixe o JAR da biblioteca JSON
curl -o lib/json-20231013.jar https://repo1.maven.org/maven2/org/json/json/20231013/json-20231013.jar
```

## 🎮 Como Usar

### Compilação Manual
```bash
# Compilar o programa
javac -cp lib/json-20231013.jar main/src/GitHubActivityCLI.java

# Executar
java -cp .;lib/json-20231013.jar GitHubActivityCLI <nome-usuario>
```

### Usando o Script (Windows)
```bash
# Executar com script
run.bat torvalds
```

### Exemplos de Uso
```bash
# Ver atividades do Linus Torvalds
java -cp .;lib/json-20231013.jar GitHubActivityCLI torvalds

# Ver atividades do usuário 'octocat'
java -cp .;lib/json-20231013.jar GitHubActivityCLI octocat

# Ver suas próprias atividades
java -cp .;lib/json-20231013.jar GitHubActivityCLI seu-usuario
```

## 📋 Exemplo de Saída

```
Buscando atividades recentes de 'torvalds' no GitHub...

Últimas atividades:
- Enviou 3 commit(s) para torvalds/linux
- Abriu uma issue em torvalds/subsurface  
- Favoritou o repositório linux/kernel
- Criou branch em torvalds/linux
- Removeu tag em torvalds/linux
```

## 🔧 Tipos de Eventos Suportados

- **PushEvent**: Commits enviados
- **IssuesEvent**: Issues abertas/fechadas
- **PullRequestEvent**: Pull requests criados/mergeados
- **WatchEvent**: Repositórios favoritados
- **CreateEvent**: Branches/tags criadas
- **DeleteEvent**: Branches/tags removidas
- **ForkEvent**: Repositórios bifurcados

## ⚠️ Limitações e Considerações

- **Rate Limiting**: A API do GitHub permite ~60 requisições por hora sem autenticação
- **Eventos Recentes**: Mostra apenas os eventos mais recentes disponíveis na API
- **Conexão**: Requer conexão com internet estável
- **Timeout**: Configurado para 5 segundos de conexão e 10 segundos de leitura

## 🐛 Solução de Problemas

### Erro: "Cannot find symbol"
```bash
# Verifique se o JAR está no classpath
javac -cp lib/json-20231013.jar main/src/GitHubActivityCLI.java
```

### Erro: "Usuário não encontrado"
```bash
# Verifique se o nome de usuário está correto
java -cp .;lib/json-20231013.jar GitHubActivityCLI usuario-existente
```

### Erro: "Connection timed out"
```bash
# Verifique sua conexão com a internet
ping api.github.com
```

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para detalhes.

## 🙋‍♂️ Autor

Este projeto foi baseado no desafio [GitHub User Activity CLI do roadmap.sh](https://roadmap.sh/projects/github-user-activity)

Criado como projeto educativo para demonstrar:
- Consumo de APIs REST em Java
- Manipulação de JSON
- Desenvolvimento de CLI tools
- Tratamento de erros robusto

## ✉️ Contato

Breno Souza - [Linkedin](https://www.linkedin.com/in/breno-berllock/) - brenosouzaemp@gmail.com

Link do Projeto: [https://github.com/Berllock/Task-Tracker-CLi.git](https://github.com/Berllock/GitHub-User-Activity-CLI)

---

**💡 Dica**: Use este projeto para aprender sobre APIs REST, tratamento de JSON e desenvolvimento de ferramentas de linha de comando em Java!
