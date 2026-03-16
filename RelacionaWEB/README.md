# Projeto Site de Relacionamentos - RelacionaWebs

## Descrição

Este projeto consiste em um site de relacionamentos no qual o sistema permite que usuários se cadastrem, realizem login, e preencham um perfil com perguntas pessoais para encontrar matches.

O site utiliza integração com APIs externas para melhorar a experiência do usuário: a API dos Correios para preenchimento automático do endereço via CEP, e uma API em Node.js para consultar dados via CPF.

## Tecnologias utilizadas

- Java (Servlets, Java Class)  
- PostgreSQL (Banco de Dados)
- pgAdmin 4 (IDE para gerenciamento do banco PostgreSQL)
- HTML, CSS, JavaScript  
- API Node.js para consulta de CPF  
- API dos Correios para consulta de CEP  
- NetBeans IDE  

## Como executar o projeto

1. Configure o banco de dados PostgreSQL com o script disponível na pasta `SQL` (se aplicável).  
2. Importe o projeto no NetBeans.  
3. Configure o servidor (Tomcat ou outro) para rodar o projeto.  
4. Garanta que a API Node.js esteja rodando localmente na porta 3000.  
5. Acesse `http://localhost:8080/RelacionaWEB/cadastrar.html` para abrir o formulário de cadastro.  

## Funcionalidades principais

- Cadastro de usuário com preenchimento automático de endereço via CEP e CPF.  
- Consulta de dados do usuário via CPF usando API Node.js.  
- Perguntas de perfil para encontrar pares.  
- Interface responsiva e agradável.  
- Mensagens de erro amigáveis junto aos campos do formulário.  

## Como executar

1. Configure o banco de dados PostgreSQL usando o pgAdmin 4 com o script fornecido.

2. Importe o projeto no NetBeans IDE.

3. Ajuste as configurações do banco de dados (usuário, senha, URL) no projeto.

4. Inicie o servidor local (Tomcat, GlassFish, etc.) pelo NetBeans.

5. Acesse o site no navegador via localhost.

## Como usar

- Preencha o formulário de cadastro com os dados solicitados.  
- Utilize o campo CPF para buscar dados existentes (se cadastrados).  
- Preencha o CEP para preenchimento automático do endereço.  
- Responda as perguntas para criar seu perfil.  
- Clique em “Cadastrar” para enviar o formulário.  
- Faça o Login para entrar com sua conta criada.
- Vá para 'Procurar Par'.
- Veja os detalhes dos usuários cadastrados no banco de dados.
- A listagem é feita com a pontuação (respostas iguais) de cada usuário.

## Observações

- API Node.js para consulta de CPF deve estar rodando localmente na porta 3000.
- Requisições ao serviço dos Correios dependem de conexão com a internet.

## Arquitetura

O projeto segue o padrão MVC com separação entre as camadas de modelo, visão e controle. A interface utiliza HTML, CSS e JavaScript para interação. A camada de backend é feita em Java com Servlets e comunicação com o banco PostgreSQL. Integração com APIs externas ocorre via chamadas HTTP.  

## Melhorias futuras

- Implementar testes automatizados para garantir a qualidade do código.  
- Melhorar a segurança com validação avançada e proteção contra ataques.  
- Expandir a experiência do usuário com páginas de perfil, navegação e menu.  

## Autores

- Matheus Sant’Ana Fuckner Clementino
- Ana Clara Maranho Globleckner Silva
