# How to use

## Run the app

* ./gradlew bootJAr
* cd build/libs
* java -XX:+PrintCompilation -jar demo-0.0.1-SNAPSHOT.jar

All flags recommended to debug JIT:
* XX:+PrintFlagsFinal
* -XX:+PrintCodeCache
* -XX:+PrintCompilation

## Make some requests

* brew install parallel
* chmod +x warmup.sh
* ./warmup.sh

## Parse the PrintCompilation lines

* Copy PrintCompilation console logs output.txt in /parser
* java Parser.java
* You get another file output.csv

## Upload output.csv to this sheet

https://docs.google.com/spreadsheets/d/1HwgUQPtlJZt6Tpci9GhIr17P1OR6_M89xITyEQRa_z8/edit?usp=sharing

## Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

