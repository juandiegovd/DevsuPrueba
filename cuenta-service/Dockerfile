## builder
FROM maven:3.6.3 AS  builder
ENV APP_HOME=/apps/CuentaService
WORKDIR ${APP_HOME}/service/app
COPY . .

RUN mvn install


## target
FROM adoptopenjdk:11-jre-hotspot as release
ENV APP_HOME=/apps/CuentaService
WORKDIR ${APP_HOME}/service/app

COPY --from=builder ${APP_HOME}/service/app/target/*.jar cuenta-service.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","cuenta-service.jar"]
