FROM openjdk:10-jdk-slim

RUN apt-get update && apt-get install curl -y
RUN apt-get update && apt-get install netcat-openbsd -y
RUN apt-get update && apt-get install bash -y

ARG JAR_FILE
ENV JAVA_OPTS "-Xmx256m -Xms128m"

RUN apt-get update && apt-get install tzdata -y
RUN cp -f /usr/share/zoneinfo/America/Sao_Paulo /etc/localtime

ADD ${JAR_FILE} app.jar

ADD ./wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

ADD ./entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh

ENTRYPOINT ["/entrypoint.sh"]

