#!/usr/bin/env bash

gitroot=$(git rev-parse --show-toplevel)

java_formatter=$gitroot/thirdparty/format/java/google-java-format-1.7-all-deps.jar
find $gitroot -name '*.java' | xargs java -jar $java_formatter --replace
