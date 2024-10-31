FROM amazoncorretto:21-alpine3.17-jdk

COPY HelloWorld.java /app/

WORKDIR /app/

RUN javac HelloWorld.java

ENTRYPOINT ["java","HelloWorld"]
