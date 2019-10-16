package(default_visibility = ["//visibility:public"])

sh_library(
    name = "bashunit",
    srcs = ["shell/unittest.bash"],
    data = ["shell/testenv.sh"],
)

java_import(
    name = "junit4",
    jars = [
        "hamcrest/hamcrest-core-1.3.jar",
        "junit/junit-4.12.jar",
    ],
)

py_binary(
    name = "format-python",
    main = "__main__.py",
    srcs = glob(["format/yapf/**/*.py"]),
    imports = ["format/yapf"],
)
