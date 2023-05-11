FROM maven:3.8.7-openjdk-18
WORKDIR /FootballTest
COPY pom.xml .
RUN mvn -B dependency:resolve
COPY scr /FPOM/src
CMD mvn clean install
RUN export JAVA_HOME="$(dirname $(dirname $(readlink -f $(openjdk-17 java))))"
CMD mvn clean test

