LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0-only;md5=c79ff39f19dfec6d293b95dea7b07891"

SRC_URI="git://github.com/aizvorski/h264bitstream.git;branch=master;protocol=https"
SRCREV="${AUTOREV}"

S = "${WORKDIR}/git"

DEPENDS += "alsa-utils automake-native autoconf-native"

inherit cmake pkgconfig

EXTRA_OECMAKE += "-DCMAKE_POSITION_INDEPENDENT_CODE=ON -DBUILD_SHARED_LIBS=ON -DCMAKE_CXX_STANDARD=17"
#EXTRA_OECMAKE += "-DCMAKE_INSTALL_=${D}/"

#FILES:${PN} += "${libdir}/${PN}/*"
FILES:${PN}-dev += "${includedir}/libh264bitstream.so"


