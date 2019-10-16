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

java_import(
    name = "javaformat",
    jars = ["javaformat/google-java-format-1.7-all-deps.jar"],
)
