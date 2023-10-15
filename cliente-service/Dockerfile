## builder
FROM maven:3.6.3 AS  builder
ENV APP_HOME=/apps/ClienteService
WORKDIR ${APP_HOME}/service/app
COPY . .

RUN mvn install


## target
FROM adoptopenjdk:11-jre-hotspot as release
ENV APP_HOME=/apps/ClienteService
WORKDIR ${APP_HOME}/service/app

COPY --from=builder ${APP_HOME}/service/app/target/*.jar cliente-service.jar

EXPOSE 8090

ENTRYPOINT ["java","-jar","cliente-service.jar"]
