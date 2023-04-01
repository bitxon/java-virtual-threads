#!/bin/bash
./gradlew build
java -Xms256m -Xmx512m -jar build/libs/spring-netty-reactive-0.0.1-SNAPSHOT.jar
