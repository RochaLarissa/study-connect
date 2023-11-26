# Study-Connect
Projeto back-end Java para o trabalho de conclusão de curso em ADS - Unifor.

Trata-se de um site para encontrar outras pessoas da Universidade com interesse em estudar matérias em comum e com disponibilidade de horário semelhante.

A idéia é que o usuário se cadastre no site usando email e senha, adicione as matérias que tem interesse de estudar, bem como o melhor turno para estudar a matéria e local para o encontro [presencial ou ead]. Com base nisso, você será adicionado a um grupo com pessoas com o mesmo interesse e disponibilidade.

Você também pode consultar os grupos já formados e ingressar neles.

## Back-End
API baseada em Java e Spring Boot, Maven e banco MySql, com login seguro Spring Security e autenticação através de JWT.

### Preparando o ambiente
Para rodar a API é necessário ter uma IDE como Intellij para rodar o projeto localmente, banco MySql instalado na máquina, bem como Postman para acessar os endpoints.

### Endpoints disponíveis
Todos os endpoints disponíveis estão anexados ao arquivo 'Projeto Postman' disponível no seguinte caminho study-connect > src > main > resources: Projeto Postman

#### Login e Acesso
- Primeiro é necessário cadastrar um novo usuário em http://localhost:8080/api/usuarios
- Em seguida, você deve gerar um token para acessar as demais urls no caminho http://localhost:8080/api/auth
- Insira o token gerado na aba "Authorization" do Postman como Bearer Token para todas as requisições que desejar fazer
