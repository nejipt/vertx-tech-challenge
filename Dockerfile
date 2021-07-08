FROM maven:3.6.3-openjdk-11 as builder
WORKDIR /vertx_tech_challenge
COPY . /vertx_tech_challenge/
RUN mvn package -DskipTests -B

FROM adoptopenjdk:11-jre-hotspot
ENV APP_DIR /application
ENV APP_FILE vertx_tech_challenge.jar

EXPOSE 8888

WORKDIR $APP_DIR
COPY --from=builder /vertx_tech_challenge/target/*-fat.jar $APP_DIR/$APP_FILE

ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar $APP_FILE"]
