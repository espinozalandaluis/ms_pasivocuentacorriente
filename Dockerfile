FROM openjdk:11
#VOLUME /tmp
EXPOSE 8085
COPY "./target/pasivocuentacorriente-0.0.1-SNAPSHOT.jar" "pasivocuentacorriente.jar"
ENTRYPOINT ["java","-jar","pasivocuentacorriente.jar"]