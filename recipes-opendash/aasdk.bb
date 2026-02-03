LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0-only;md5=c79ff39f19dfec6d293b95dea7b07891"

SRC_URI="git://github.com/benjamin0906/aasdk.git;branch=develop;protocol=https"
SRCREV="${AUTOREV}"

S = "${WORKDIR}/git"

inherit cmake pkgconfig
#PREFERRED_VERSION_openssl = "3.0.0"
DEPENDS += "protobuf protobuf-native boost libusb1 openssl"


EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release -DCMAKE_CXX_STANDARD=17 -DCMAKE_CXX_STANDARD_REQUIRED=ON"
#-DProtobuf_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc -DProtobuf_INCLUDE_DIR=${RECIPE_SYSROOT}/usr/include -DProtobuf_LIBRARY=${RECIPE_SYSROOT}/usr/lib/libprotobuf.so 