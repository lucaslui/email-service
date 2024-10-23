<h1 align="center"> 📭 Simple Email Service  </h1>

<p align="center">
  <img alt="GitHub top language" src="https://img.shields.io/github/languages/top/lucaslui/email-service">
  <a href="https://github.com/tgmarinho/nlw1/commits/master">
    <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/lucaslui/email-service">
  </a>
  <a href="https://github.com/lukemorales/rocketshoes-react-native/issues">
    <img alt="Repository issues" src="https://img.shields.io/github/issues/lucaslui/email-service.svg">
  </a>
</p>

<p align="center">
 <a href="#overview">Overview</a> •
 <a href="#features">Features</a> •
 <a href="#technologies">Technologies</a> • 
 <a href="#prerequisites">Pre-requisites</a> • 
 <a href="#install">Install</a> • 
 <a href="#run">Run</a> •
 <a href="#author">Author</a>
</p>

<h4 align="center"> 🚧  <b> Status do projeto </b>: Em progresso...  🚧 </h4>

<h2 id="overview"> 💻 Overview </h2>

The Simple Email Service is responsible for sending emails of notification. The application was developed to be used in a microservices environment, being capable of sending emails asynchronously and scalable. 

The service is also integrated with a database, which is responsible for storing the email history.

<h2 id="features"> 📑 Features </h2>

The email service has the following features:

- [✔] Send emails
- [⨯] List email history

<h2 id="technologies"> 🧰 Technologies </h2>

The following technologies were used in the construction of the project:

- [Java](https://openjdk.org/)
- [Maven](https://maven.apache.org/)
- [Spring Boot](https://spring.io/)
- [Mongodb](https://www.mongodb.com/)
- [Swagger](https://swagger.io/)

<h2 id="prerequisites"> 🛠 Pre-Requisites </h2>

Before you begin, you will need to have the following tools installed on your machine:

  - Java == 23.0
  - Maven == 4.0.0
  - Docker >= 23.0.1

I would like recommends that you have installed the SDKman to management Java and Maven versions. To install SDKman, run the following commands:
    
```bash
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
```

In addition, you will need to set the following environment variables in your .env file:

```bash
EMAIL_PROVIDER_HOST=
EMAIL_PROVIDER_PORT=
EMAIL_PROVIDER_USERNAME=
EMAIL_PROVIDER_PASSWORD=

MONGO_DB_URI=
```

<h2 id="install"> 🏗️ Install </h2>

To install via command line:

```bash
# Clone this repository
$ git clone https://github.com/lucaslui/email-service.git

# Go into the repository
$ cd email-service

# Clean, compile and install dependencies and package .jar
$ ./mvnw clean install
```

<h2 id="run"> 🚀 Run </h2>

It is possible to run locally with:

```sh
# MongoDB start container
docker compose up

# Executando localmente
./mvnw spring-boot:run
```

<h2 id="author"> 👤 Author </h2>

Created by **Lucas Lui Motta**. Feel free to contact me at [Linkedin](https://www.linkedin.com/in/lucas-lui-motta/)!
