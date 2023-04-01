#!/bin/bash
./gradlew build
java -Xms256m -Xmx512m -jar build/libs/spring-tomcat-0.0.1-SNAPSHOT.jar
