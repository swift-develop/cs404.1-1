#!/usr/bin/env bash

function join() {
    local IFS="$1"
    shift
    echo "$*"
}

function main() {
    java_blessed=(
        "java.util.Arrays"
        "java.util.Iterator"
        "java.util.Random"
    )

    python_blessed=(
        "Enum"
        "math"
        "python.src"
        "python.test"
        "random"
        "unittest"
    )

    error_message="The following imports are invalid (you may not use the standard library):"
    gitroot=$(git rev-parse --show-toplevel)
    cd $gitroot

    java_invalid="$(git grep 'import.*java.util.*' java | grep -Ev $(join '|' ${java_blessed[@]}))"
    if [[ $java_invalid != "" ]]; then
        echo "$error_message"
        echo "$java_invalid"
        exit 1
    fi

    python_invalid="$(git grep 'import ' python | grep -Ev $(join '|' ${python_blessed[@]}))"
    if [[ $python_invalid != "" ]]; then
        echo "$error_message"
        echo "$python_invalid"
        exit 1
    fi
}

main "$@"
