# Imagem Ubuntu
FROM ubuntu:latest AS build 

# Atualização de pacotes
RUN apt-get update
# Instalação do OpenJDK
RUN apt-get install openjdk-17-jdk -y
# Copia arquivos a partir da raíz do projeto para a raiz do contâiner
COPY . .

# Instalação do Maven
RUN apt-get install maven -y
# Gera .jar na pasta /target
RUN mvn clean install

FROM openjdk:17-jdk-slim
EXPOSE 8080

COPY --from=build /target/healthsubscriptionapi-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]