#!/usr/bin/env bash

# This script merges in changes from the public assignment repository into private student forks.

function main() {
    git remote remove upstream
    git remote add upstream git@github.com:fsareshwala/cs404.1.git
    git fetch upstream
    git merge upstream/master
}

main
