DEFAULT_DEPS = [
    "//src/org/perses/program",
    "//test/org/perses:test_util",
    "//test/org/perses:truth",
    "@maven//:com_google_guava_guava",
]

load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library", "kt_jvm_test")

kt_jvm_test(
    name = "TokenizedProgramTest",
    srcs = ["TokenizedProgramTest.kt"],
    data = [
        "//test_data/delta_1",
        "//test_data/java_helloworld",
        "//test_data/parentheses",
    ],
    test_class = "org.perses.program.TokenizedProgramTest",
    deps = DEFAULT_DEPS,
)

java_test(
    name = "SourceFileTest",
    srcs = ["SourceFileTest.java"],
    data = [
        "//test_data/delta_1",
    ],
    test_class = "org.perses.program.SourceFileTest",
    deps = DEFAULT_DEPS + [
        "//src/org/perses/grammar/c:language_kind",
        "//src/org/perses/program:language_kind",
    ],
)

kt_jvm_test(
    name = "ScriptFileTest",
    srcs = ["ScriptFileTest.kt"],
    data = [
        "//test_data/delta_1",
    ],
    test_class = "org.perses.program.ScriptFileTest",
    deps = DEFAULT_DEPS + [
        "//src/org/perses/program:language_kind",
    ],
)

kt_jvm_library(
    name = "LanguageKindTestUtil",
    srcs = ["LanguageKindTestUtil.kt"],
    visibility = ["//visibility:public"],
    deps = DEFAULT_DEPS + [
        "//src/org/perses/program:language_kind",
    ],
)

java_test(
    name = "TokenizedProgramFactoryTest",
    srcs = ["TokenizedProgramFactoryTest.java"],
    test_class = "org.perses.program.TokenizedProgramFactoryTest",
    deps = DEFAULT_DEPS + [
        "@maven//:org_antlr_antlr4_runtime",
    ],
)
