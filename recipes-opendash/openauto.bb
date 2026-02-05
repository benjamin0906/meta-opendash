LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0-only;md5=c79ff39f19dfec6d293b95dea7b07891"

SRC_URI="git://github.com/benjamin0906/openauto.git;branch=develop;protocol=https"
SRCREV="${AUTOREV}"

S = "${WORKDIR}/git"

IMAGE_INSTALL:append = " qtconnectivity"
IMAGE_INSTALL:append = " qt5bluetooth"
DISTRO_FEATURES:append = " pi-bluetooth bluez5 bluetooth"
IMAGE_INSTALL:append = " pi-bluetooth bluez5"
DEPENDS += "aasdk gstreamer1.0 pulseaudio qtbase rtaudio protobuf protobuf-native bluez5 qtconnectivity qtmultimedia abseil"
DEPENDS += "h264bitstream"

inherit cmake pkgconfig cmake_qt5

EXTRA_OECMAKE += "-DCMAKE_CXX_STANDARD=17 -DCMAKE_CXX_STANDARD_REQUIRED=ON -DCMAKE_CXX_FLAGS=-std=c++17 -DGST_BUILD=true"