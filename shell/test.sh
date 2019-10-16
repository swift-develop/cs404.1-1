#!/usr/bin/env bash

source ${RUNFILES_DIR}/bazel_tools/tools/bash/runfiles/runfiles.bash
source $(rlocation algorithms/thirdparty/shell/unittest.bash)

info_path=$(rlocation algorithms/shell/info.sh)
sum_path=$(rlocation algorithms/shell/sum.sh)
seq_path=$(rlocation algorithms/shell/seq.sh)
stdio_path=$(rlocation algorithms/shell/stdio.sh)

function test_info() {
    actual=$($info_path)
    expected="Current date: $(date)
Login name: $(whoami)
Current directory: $(pwd)
Home directory: $(realpath ~)"

    assert_equals "$expected" "$actual"
}

function test_sum_zero() {
    actual=$($sum_path 0 0 0 0 0)
    expected="0"
    assert_equals "$expected" "$actual"
}

function test_sum_positive() {
    actual=$($sum_path 10 27 24 42)
    expected="103"
    assert_equals "$expected" "$actual"
}

function test_sum_negative() {
    actual=$($sum_path -10 27 -24 -42)
    expected="-49"
    assert_equals "$expected" "$actual"
}

function test_seq_no_args() {
    disable_errexit
    $seq_path > /dev/null
    if [[ $? != 1 ]]; then
        fail 'seq.sh with no arguments did not result in exit status 1'
    fi
}

function test_seq_1_arg() {
    to=10
    expected="$(seq $to)"
    actual="$($seq_path $to)"
    assert_equals "$expected" "$actual"
}

function test_seq_2_args() {
    from=12
    to=23
    expected="$(seq $from $to)"
    actual="$($seq_path $from $to)"
    assert_equals "$expected" "$actual"
}

function test_seq_3_args() {
    from=0
    to=100
    increment=3
    expected="$(seq $from $increment $to)"
    actual="$($seq_path $from $increment $to)"
    assert_equals "$expected" "$actual"
}

function test_seq_4_args() {
    disable_errexit
    $seq_path 1 2 3 4 > /dev/null
    if [[ $? != 1 ]]; then
        fail 'seq.sh with more than 3 arguments did not result in exit status 1'
    fi
}

function test_seq_zero_increment() {
    disable_errexit
    $seq_path 1 0 100 > /dev/null
    if [[ $? != 1 ]]; then
        fail 'seq.sh with zero increment did not result in exit status 1'
    fi
}

function test_seq_negative_numbers() {
    from=-10
    to=10
    increment=2
    expected="$(seq $from $increment $to)"
    actual="$($seq_path $from $increment $to)"
    assert_equals "$expected" "$actual"
}

function test_seq_noninteger_arguments() {
    disable_errexit
    $seq_path a b > /dev/null
    if [[ $? != 1 ]]; then
        fail 'seq.sh with noninteger arguments did not result in exit status 1'
    fi
}

function test_stdio_no_files() {
    dir=$(mktemp -d)
    $stdio_path $dir
}

function test_stdio_header_no_printf() {
    dir=$(mktemp -d)
    file=$dir/foo.c
    cat << EOF > $file
#include <stdio.h>
int main() {
    return 0;
}
EOF
    $stdio_path $dir
    num=$(grep -l '#include <stdio.h>' $file | wc -l)
    assert_equals 1 $num
}

function test_stdio_no_header_printf() {
    dir=$(mktemp -d)
    file=$dir/foo.c
    cat << EOF > $file
int main() {
    printf("Hello world!\n");
    return 0;
}
EOF
    $stdio_path $dir
    num=$(grep -l '#include <stdio.h>' $file | wc -l)
    assert_equals 1 $num
}

function test_stdio_no_header_no_printf() {
    dir=$(mktemp -d)
    file=$dir/foo.c
    cat << EOF > $file
int main() {
    return 0;
}
EOF
    $stdio_path $dir
    num=$(grep -l '#include <stdio.h>' $file | wc -l)
    assert_equals 0 $num
}

function test_stdio_multiple_files() {
    dir=$(mktemp -d)
    file=$dir/foo.c
    cat << EOF > $file
int main() {
    printf("Hello world!\n");
    return 0;
}
EOF

    cp $file $dir/bar.c
    cp $file $dir/baz.c

    $stdio_path $dir
    num=$(grep -Rl '#include <stdio.h>' $dir | wc -l)
    assert_equals 3 $num
}

function test_stdio_multiple_directories() {
    dir1=$(mktemp -d)
    dir2=$(mktemp -d)
    file=$dir1/foo.c
    cat << EOF > $file
int main() {
    printf("Hello world!\n");
    return 0;
}
EOF

    cp $file $dir2
    $stdio_path $dir1 $dir2
    num=$(grep -Rl '#include <stdio.h>' $dir1 $dir2 | wc -l)
    assert_equals 2 $num
}

run_suite "Program 1 Test Suite"
