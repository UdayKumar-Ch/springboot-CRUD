FROM openjdk:13-oracle

WORKDIR /usr/src/myapp

COPY build/libs/* .

EXPOSE 8000

CMD java -jar *