FROM maven as builder
COPY . /code/
WORKDIR /code
RUN mvn package

FROM openjdk:11-jre
COPY --from=builder /code/target/*.jar /usr/src/
WORKDIR /usr/src
CMD [ "java", "-jar", "UnderSociety-0.0.1-SNAPSHOT.jar" ]