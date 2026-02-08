LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0-only;md5=c79ff39f19dfec6d293b95dea7b07891"

#LIC_FILES_CHKSUM = "md5=c79ff39f19dfec6d293b95dea7b07891"

SRC_URI="git://github.com/GStreamer/qt-gstreamer;branch=master;protocol=https "
SRCREV="${AUTOREV}"

LICENSE_FLAGS_ACCEPTED = "commercial"

S = "${WORKDIR}/git"

inherit pkgconfig cmake_qt5

DEPENDS += "abseil zlib gstreamer1.0 qtbase qtdeclarative qwt-qt5 boost doxygen gst-devtools"

BBCLASSEXTEND = "native"

EXTRA_OECMAKE += "-DCMAKE_POSITION_INDEPENDENT_CODE=ON -DBUILD_SHARED_LIBS=ON -DCMAKE_CXX_STANDARD=17"
EXTRA_OECMAKE += "-DQT_VERSION=5 -DCMAKE_BUILD_TYPE=Release -DCMAKE_CXX_FLAGS=-std=c++17"
EXTRA_OECMAKE += "-DCMAKE_INSTALL_LIBDIR=lib"
EXTRA_OECMAKE += "-DCMAKE_INSTALL_INCLUDEDIR=include"

#FILES:${PN} += "${D}/*.so.*"
#
#FILES:${PN}-dev += "${D}/*.so"
#FILES:${PN}-dev += "${D}/pkgconfig"
#FILES:${PN}-dev += "${D}/cmake"
#FILES:${PN}-dev += "${D}${libdir}"
#FILES:${PN}-dev += "${CMAKE_CURRENT_BINARY_DIR}/qmldir"

#FILES:${PN}-dev += "${libdir}/lib/*.so"
FILES:${PN} += "${libdir}/gstreamer-1.0/libgstqt5videosink.so"
#FILES:${PN}-dbg += "/usr/QtGStreamer/.debug/libQtGStreamerQuick2.so"
FILES:${PN} += "/usr/QtGStreamer/libQtGStreamerQuick2.so"
FILES:${PN} += "/usr/lib/QtGStreamer/libQtGStreamerQuick2.so"
FILES:${PN} += "${includedir}/Qt5GStreamer/QGlib/*.h"
FILES:${PN} += "${includedir}/Qt5GStreamer/QGlib/Error"
FILES:${PN} += "${includedir}/Qt5GStreamer/QGst/*.h"
#d
do_install:append(){
    # Your code here
    echo "D: ${D}"
    echo "libdir: ${libdir}"
    echo "includedir: ${includedir}"
    echo "${FILES:${PN}}"
}