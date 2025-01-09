FROM openjdk:21-ea-1-jdk

WORKDIR /app
COPY target/api-books-archetype-1.0.0.jar app.jar
COPY Wallet_BBWINOZSJWUGFFF8 /app/oracle_wallet
EXPOSE 8080

CMD [ "java", "-jar", "app.jar" ]
