# Use a imagem oficial do OpenJDK 11 como base
FROM openjdk:17-jdk-alpine

# Defina o diretório de trabalho no contêiner
WORKDIR /app

# Copie o JAR gerado do seu projeto Spring Boot para o contêiner
COPY build/libs/parking-meter-api-0.0.1-SNAPSHOT.jar app.jar

# Exponha a porta em que a aplicação vai rodar (neste caso, a porta 8082)
EXPOSE 8082

# Comando para executar a aplicação Spring Boot
CMD ["java", "-jar", "app.jar"]