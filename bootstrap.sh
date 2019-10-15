#!/usr/bin/env bash

# This script bootstraps student environments with a private fork of the public assignment
# repository. You should not run this script from a clone of the repository. Rather, run this script
# directly:
#
#   curl https://raw.githubusercontent.com/fsareshwala/cs404.1/master/bootstrap.sh | bash username

function log_error() {
    echo "error: $1"
    exit
}

function ensure_exists() {
    program=$1
    command -v "$program" > /dev/null 2>&1 || log_error "$program not available on path"
}

function usage() {
    echo "usage: $0 username

$0 bootstraps student environments with a private fork of the public assignment repository.

    Positional arguments:
        username            Your GitHub username

    Example:
        $ bash $0 fsareshwala
    "
}

function main() {
    ensure_exists git

    if [[ $# -ne 1 ]]; then
        usage
        exit
    fi

    username=$1
    repo=cs404.1

    test -d $repo && rm -rf $repo

    git clone git@github.com:fsareshwala/$repo.git
    cd $repo.git || log_error "directory $repo.git does not exist"

    git remote remove origin
    git remote add origin git@github.com:$username/$repo.git
    git remote add upstream git@github.com:fsareshwala/$repo.git
    git push -uf origin master
}

main "$@"
