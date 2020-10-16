#!/usr/bin/env bash

set -o nounset
set -o pipefail

if [[ "$(dirname "${0}")" != "." ]] ; then
  echo "ERROR: This script should be run in the folder of the script."
  exit 1
fi


readonly RUSTC_VERSION="nightly"

readonly OUTPUT_FOLDER="$(mktemp -d)"
readonly INVALID_FILE_LIST="${OUTPUT_FOLDER}/syntactically_invalid_rust_programs.txt"
trap "rm -rf ${OUTPUT_FOLDER}" EXIT


readonly PKG="rust_testsuite"
rustup toolchain install "${RUSTC_VERSION}"
for f in $(find "${PKG}" -name '*.rs') ; do
  if [[ "$(dirname "${f}")" == "${PKG}/run-make-fulldeps/dep-info-spaces" ]] ; then
    continue
  elif [[ "$(dirname ${f})" == "." ]] ; then
    # Skip empty dir.
    continue
  fi
  if rustup run "${RUSTC_VERSION}" rustc --edition 2015 -Z ast-json-noexpand=yes "${f}" --out-dir "${OUTPUT_FOLDER}" &> /dev/null || \
     rustup run "${RUSTC_VERSION}" rustc --edition 2018 -Z ast-json-noexpand=yes "${f}" --out-dir "${OUTPUT_FOLDER}" &> /dev/null
  then
    # This file is parsable.
    continue
  else
    echo "\"${f}\"," >> "${INVALID_FILE_LIST}"
    echo "$f"
  fi
done

readonly BUILD_FILE="BUILD"
echo "writing to ${BUILD_FILE}"

cat > "${BUILD_FILE}" <<-EOF
# DO NOT EDIT.
# THIS FILE IS AUTOMATICALLY GENERATED.
# Run '$0' to update this BUILD file.
package(default_visibility = ["//test/org/perses:__subpackages__"])

filegroup(
    name = "rust_testsuite",
    srcs = glob(
        ["rust_testsuite/**/*.rs"],
        exclude = [
            "rust_testsuite/run-make-fulldeps/dep-info-spaces/*.rs",
            "rust_testsuite/ui/closures/deeply-nested_closures.rs",  # TODO: cause infinite loop of antlr.
$(cat "${INVALID_FILE_LIST}")
        ],
    ),
)
EOF