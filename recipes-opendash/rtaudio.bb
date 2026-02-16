LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI="git://github.com/thestk/rtaudio.git;branch=master;protocol=https"
SRCREV="${AUTOREV}"

S = "${WORKDIR}/git"

DEPENDS += "alsa-utils automake-native autoconf-native"

inherit autotools pkgconfig

EXTRA_OECMAKE += "-DCMAKE_POSITION_INDEPENDENT_CODE=ON -DBUILD_SHARED_LIBS=ON -DCMAKE_CXX_STANDARD=17"