#!/usr/bin/env bash

# format java
gitroot=$(git rev-parse --show-toplevel)
java_formatter=$gitroot/thirdparty/format/java/google-java-format-1.7-all-deps.jar
find $gitroot/java -name '*.java' | xargs java -jar $java_formatter --replace

# format python
find $gitroot/python -name '*.py' | xargs bazel run thirdparty:format-python -- -pir --style=google
