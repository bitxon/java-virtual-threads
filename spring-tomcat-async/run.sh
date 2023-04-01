#!/bin/bash
./gradlew build
java -Xms256m -Xmx512m -jar build/libs/spring-tomcat-async-0.0.1-SNAPSHOT.jar
