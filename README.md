<h1 align="center"> 📭 Simple Email Service 📭 </h1>

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

The Simple Email Service is designed for sending notification emails in a microservices environment via Simple Mail Transfer Protocol (SMTP). 

It supports synchronous and asynchronous email delivery and is built with scalability in mind, ensuring reliable performance even under heavy loads.

The service is also integrated with a database, which is responsible for storing the email history.

<h2 id="features"> 📑 Features </h2>

The email service has the following features:

- [✔] Send synchronous emails 
- [⨯] Send asynchronous emails coming from Kafka
- [✔] List email history (with email status, content, date, and recipient)

<h2 id="technologies"> 🧰 Technologies </h2>

The following technologies were used in the construction of the project:

- [Java](https://openjdk.org/)
- [Maven](https://maven.apache.org/)
- [Spring Boot](https://spring.io/)
- [Mongodb](https://www.mongodb.com/)
- [Swagger](https://swagger.io/)

<h2 id="prerequisites"> 🛠 Pre-Requisites </h2>

Before you begin, you will need to have the following tools installed on your machine:

  - Java >= 23.0
  - Maven >= 4.0.0
  - Docker >= 25.0.5 (with docker-compose)

I strongly recommend installing [SDKMAN](https://sdkman.io/) to manage Java and Maven versions efficiently. 

To install SDKMAN, run the following commands:
    
```bash
# Download SDKMAN script
curl -s "https://get.sdkman.io" | bash
# Install SDKMAN through the script
source "$HOME/.sdkman/bin/sdkman-init.sh"
```

<h2 id="install"> 🏗️ Install </h2>

First you must clone the code and go to the project root directory.

```bash
# Clone this repository
$ git clone https://github.com/lucaslui/email-service.git

# Go into the repository
$ cd email-service
```
In the following steps, for greater convenience, it is recommended to use an IDE with support for **Java** and **Spring**, for example, with **VSCode** you can use and install extensions such as:

- [Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)

- [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=Pivotal.vscode-boot-dev-pack)

Even so, if you want to try installing via command line, run:

```bash
# Clone this repository
$ git clone https://github.com/lucaslui/email-service.git

# Go into the repository
$ cd email-service

# Clean, compile and install dependencies and package .jar
$ ./mvnw clean install
```

<h2 id="run"> 🚀 Run </h2>

You'll need to set the following environment variables in your `.env` file:

```bash
EMAIL_PROVIDER_HOST=
EMAIL_PROVIDER_PORT=
EMAIL_PROVIDER_USERNAME=
EMAIL_PROVIDER_PASSWORD=

MONGO_DB_URI=
```

It is possible to run locally with:

```sh
# MongoDB start container
docker compose up

# Run the application
./mvnw spring-boot:run
```

After running the application, you can access the Swagger documentation at the following address:

```bash
http://localhost:8080/docs
```

<h2 id="troubleshoot"> 💉 Troubleshoot </h2>

Exist some common problems that you may encounter when installing the application:

- **MongoDB not connected**: If you encounter this problem, you forgot run the mongo db database through command docker compose up.

- **SMTP server not connected**: If you encounter this problem, you forgot to set the environment variables for the SMTP server.

- **Main Class not found**: If you encounter this problem, you forgot to setting the java application through your IDE.

- **Can Not Compile/Install**: If you encounter this problem, it is possible that the application cannot be installed through CLI commands due to the use of Lombok.

<h2 id="author"> 👤 Author </h2>

Created by **Lucas Lui Motta**. Feel free to contact me at [Linkedin](https://www.linkedin.com/in/lucas-lui-motta/)!
