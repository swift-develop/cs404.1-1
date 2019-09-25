#!/usr/bin/env bash

# This script merges in changes from the public assignment repository into private student forks.

function log_error() {
    echo "error: $1"
    exit
}

function ensure_exists() {
    program=$1
    command -v "$program" > /dev/null 2>&1 || log_error "$program not available on path"
}

function main() {
    ensure_exists git

    git remote remove upstream
    git remote add upstream git@github.com:fsareshwala/cs404.1.git
    git fetch upstream
    git merge upstream/master
}

main
