FROM adoptopenjdk/openjdk11:jre-11.0.8_10

ARG APP_VERSION
ENV APP_VERSION=1.0.0

COPY target/scala-2.13/potential-octo-broccoli_2.13-1.jar /opt/app/potential-octo-broccoli.jar

EXPOSE 5000

CMD ["java", "-jar", "/opt/app/potential-octo-broccoli.jar"]