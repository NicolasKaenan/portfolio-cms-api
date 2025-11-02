# 🚀 Portfolio CMS API
### Backend | Stateles & Secured
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-6DB33F)
![Java](https://img.shields.io/badge/Java-17-007396)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?logo=postgresql&logoColor=white)
![RESTful API](https://img.shields.io/badge/API-RESTful-blue)

Este projeto é o backend de um sistema de gerenciamento de conteúdo (CMS) desenvolvido para sustentar um portfólio profissional. A API foi construída com foco em segurança, escalabilidade e design RESTful.

O objetivo principal é fornecer endpoints limpos e eficientes para o consumo de dados do portfólio (Projetos, Certificados, Imagens e Tags) para minha aplicação frontend.

## Arquitetura e Tecnologias
A aplicação segue rigorosamente o padrão de Arquitetura em 3 Camadas e utiliza os seguintes componentes:

- Linguagem & Framework: Java 17, Spring Boot 3.x
- Acesso a Dados: Spring Data JPA (Hibernate)
- Banco de Dados: PostgreSQL (Serviço gerenciado pelo Railway)
- Design: API RESTful
- Gerenciamento de Dependências: Gradle
- Ferramentas: Lombok, JUnit 5 & Mockito.

## Segurança e Autenticação
A API implementa um modelo de acesso com regras claras:

- GET: Permite qualquer consulta sem autorização e autenticação.
- PUT/POST/DELETE: Precisa de autorização e autenticação.

## Principais Endpoints

| Recurso | Método | Endpoint (URL) | Função |
| :--- | :---: | :---: | ---: |
| Projetos | GET | /api/v1/projects | Lista todos os projetos (Público). |
| Projetos | POST | /api/v1/projects | Cria um novo projeto (Autenticado). |
| Tags | GET | /api/v1/projects/{id}/post_tags | Busca todas as tags de um projeto. |
| Imagens | GET | /api/v1/images/project/{id} | Busca todas as imagens de um projeto. |

## Licença
![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)
