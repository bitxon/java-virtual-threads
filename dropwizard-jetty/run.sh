#!/bin/bash
./gradlew build
java -Xms256m -Xmx512m -jar build/libs/dropwizard-jetty-1.0-SNAPSHOT-all.jar server config.yml
