LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0-only;md5=c79ff39f19dfec6d293b95dea7b07891"

SRC_URI="git://github.com/benjamin0906/openauto.git;branch=develop;protocol=https"
SRCREV="${AUTOREV}"

S = "${WORKDIR}/git"

DEPENDS         += "alsa-utils alsa-plugins pulseaudio"
#RDEPENDS:${PN}  += "alsa-utils alsa-plugins pulseaudio"

DEPENDS += "aasdk"
DEPENDS += "qtbase"
DEPENDS += "rtaudio"
DEPENDS += "protobuf"
DEPENDS += "protobuf-native"
DEPENDS += "bluez5"
DEPENDS += "qtconnectivity"
DEPENDS += "qtmultimedia"
DEPENDS += "abseil"
DEPENDS += "h264bitstream"
DEPENDS += "qt-gstreamer"
DEPENDS += "gstreamer1.0"
DEPENDS += "gstreamer1.0-libav"
DEPENDS += "gstreamer1.0-plugins-base"
DEPENDS += "gstreamer1.0-plugins-bad"
DEPENDS += "gstreamer1.0-plugins-good"
RDEPENDS:${PN} += "qt-gstreamer"
RDEPENDS:${PN} += "gstreamer1.0"
RDEPENDS:${PN} += "gstreamer1.0-libav"
RDEPENDS:${PN} += "gstreamer1.0-plugins-base"
RDEPENDS:${PN} += "gstreamer1.0-plugins-bad"
RDEPENDS:${PN} += "gstreamer1.0-plugins-good"
RDEPENDS:${PN} += "rtaudio"
RDEPENDS:${PN} += "h264bitstream"

inherit cmake pkgconfig cmake_qt5

EXTRA_OECMAKE += "-DCMAKE_CXX_STANDARD=17 -DCMAKE_CXX_STANDARD_REQUIRED=ON -DCMAKE_CXX_FLAGS=-std=c++17 -DGST_BUILD=true"

FILES:${PN}-dev += "${libdir}/*.so"
