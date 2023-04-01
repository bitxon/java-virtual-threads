#!/bin/bash
./gradlew build
java -Xms256m -Xmx512m --enable-preview -jar build/libs/dropwizard-jetty-virtual-threads-1.0-SNAPSHOT-all.jar server config.yml
