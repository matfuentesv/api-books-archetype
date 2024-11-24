FROM eclipse-temurin:22-jdk AS buildstage

RUN apt-get update && apt-get install -y maven

WORKDIR /app

COPY pom.xml .
COPY src /app/src
COPY Wallet_NKYTD6DF15M2NHAO /app/wallet

ENV TNS_ADMIN=/app/wallet

RUN mvn clean package

FROM eclipse-temurin:22-jdk

COPY --from=buildstage /app/target/api-books-archetype-1.0.0.jar /app/api-book.jar

COPY Wallet_NKYTD6DF15M2NHAO /app/wallet

ENV TNS_ADMIN=/app/wallet
EXPOSE 8080

ENTRYPOINT [ "java", "-jar","/app/api-book.jar" ]