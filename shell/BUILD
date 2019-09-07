sh_binary(
    name = "info",
    srcs = ["info.sh"],
)

sh_binary(
    name = "seq",
    srcs = ["seq.sh"],
)

sh_binary(
    name = "sum",
    srcs = ["sum.sh"],
)

sh_binary(
    name = "stdio",
    srcs = ["stdio.sh"],
)

sh_library(
    name = "libshell",
    srcs = glob(
        ["*.sh"],
        exclude = ["test.sh"],
    ),
)

sh_test(
    name = "tests",
    size = "small",
    srcs = ["test.sh"],
    deps = [
        ":libshell",
        "//thirdparty:bashunit",
        "@bazel_tools//tools/bash/runfiles",
    ],
)
