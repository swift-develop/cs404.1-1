#!/usr/bin/env bash

gitroot=$(git rev-parse --show-toplevel)
formatter=$gitroot/thirdparty/javaformat/google-java-format-1.7-all-deps.jar
find $gitroot -name '*.java' | xargs java -jar $formatter --replace
