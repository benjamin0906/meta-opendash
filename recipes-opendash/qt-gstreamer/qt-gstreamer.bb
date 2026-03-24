LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0-only;md5=c79ff39f19dfec6d293b95dea7b07891"

#LIC_FILES_CHKSUM = "md5=c79ff39f19dfec6d293b95dea7b07891"

SRC_URI="git://github.com/GStreamer/qt-gstreamer;branch=master;protocol=https "
SRCREV="${AUTOREV}"

SRC_URI += "file://0001-one-patch.patch"
SRC_URI += "file://0001-GST_TRACE_OBJECT-abspath-fix.patch"
SRC_URI += "file://0001-proper-libdir.patch"

LICENSE_FLAGS_ACCEPTED = "commercial"

S = "${WORKDIR}/git"

inherit pkgconfig cmake_qt5

DEPENDS += "abseil zlib gstreamer1.0 qtbase qtdeclarative qwt-qt5 boost doxygen gst-devtools h264bitstream"
#RDEPENDS:${PN} += "gstreamer1.0"
#RDEPENDS:${PN} += "h264bitstream"

EXTRA_OECMAKE += "-DCMAKE_POSITION_INDEPENDENT_CODE=ON -DBUILD_SHARED_LIBS=ON -DCMAKE_CXX_STANDARD=17"
EXTRA_OECMAKE += "-DQT_VERSION=5 -DCMAKE_BUILD_TYPE=Release -DCMAKE_CXX_FLAGS=-std=c++17"
EXTRA_OECMAKE += "-DCMAKE_INSTALL_LIBDIR=lib"
EXTRA_OECMAKE += "-DCMAKE_INSTALL_INCLUDEDIR=include"
EXTRA_OECMAKE += "-DUSE_QT_PLUGIN_DIR=OFF"
EXTRA_OECMAKE += "-DCMAKE_USE_RELATIVE_PATHS=ON"


FILES:${PN} += "${libdir}/gstreamer-1.0/libgstqt5videosink.so"
FILES:${PN} += "${libdir}/*"
FILES:${PN} += "${includedir}/Qt5GStreamer/QGlib/*.h"
FILES:${PN} += "${includedir}/Qt5GStreamer/QGlib/Error"
FILES:${PN} += "${includedir}/Qt5GStreamer/QGst/*.h"
