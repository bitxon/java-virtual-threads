#!/bin/bash
./gradlew build
java -Xms256m -Xmx512m --enable-preview -jar build/libs/spring-tomcat-virtual-threads-0.0.1-SNAPSHOT.jar
