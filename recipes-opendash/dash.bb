FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0-only;md5=c79ff39f19dfec6d293b95dea7b07891"

SRC_URI="git://github.com/benjamin0906/dash.git;branch=develop;protocol=https"
SRCREV="${AUTOREV}"

SRC_URI += "file://51-dashusb.rules"
SRC_URI += "file://autostart"

S = "${WORKDIR}/git"

IMAGE_INSTALL:append = " qtconnectivity"
IMAGE_INSTALL:append = " qt5bluetooth"
DISTRO_FEATURES:append = " pi-bluetooth bluetooth"
IMAGE_INSTALL:append = " pi-bluetooth"
DEPENDS += "aasdk pulseaudio qtbase rtaudio protobuf protobuf-native bluez5 qtconnectivity qtmultimedia abseil"
DEPENDS += "h264bitstream openauto boost libusb1 bluez-qt qtserialbus qtwebsockets taglib glibc qtbase-native"
RDEPENDS:${PN} += "qt-gstreamer"

inherit cmake pkgconfig cmake_qt5

EXTRA_OECMAKE += "-DGST_BUILD=true"
EXTRA_OECMAKE += "-DBoost_NO_SYSTEM_PATHS=ON"
EXTRA_OECMAKE += "-DBOOST_ROOT=${RECIPE_SYSROOT}/usr"
EXTRA_OECMAKE += "-DBOOST_INCLUDEDIR=${RECIPE_SYSROOT}/usr/include"
EXTRA_OECMAKE += "-DBOOST_LIBRARYDIR=${RECIPE_SYSROOT}/usr/lib"
EXTRA_OECMAKE += "-DQt5GStreamer=${RECIPE_SYSROOT}/usr/lib/libQt5GStreamer-1.0.so"

FILES:${PN} += "${sysconfdir}/udev/rules.d/51-dashusb.rules"
FILES:${PN} += "/home/root/.config/openbox"

do_install:append() {
    install -d ${D}${sysconfdir}/udev/rules.d
    install -m 0644 ${UNPACKDIR}/51-dashusb.rules ${D}${sysconfdir}/udev/rules.d/

    install -d ${D}/home/root/.config/openbox
    install -m 0755 ${UNPACKDIR}/autostart ${D}/home/root/.config/openbox/
}