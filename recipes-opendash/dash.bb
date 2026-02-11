LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0-only;md5=c79ff39f19dfec6d293b95dea7b07891"

SRC_URI="git://github.com/benjamin0906/dash.git;branch=develop;protocol=https"
SRCREV="${AUTOREV}"

S = "${WORKDIR}/git"

IMAGE_INSTALL:append = " qtconnectivity"
IMAGE_INSTALL:append = " qt5bluetooth"
DISTRO_FEATURES:append = " pi-bluetooth bluetooth"
IMAGE_INSTALL:append = " pi-bluetooth"
DEPENDS += "aasdk pulseaudio qtbase rtaudio protobuf protobuf-native bluez5 qtconnectivity qtmultimedia abseil"
DEPENDS += "h264bitstream gstreamer openauto boost libusb1 bluez-qt qtserialbus qtwebsockets taglib openssl glibc"
#RDEPENDS:${PN} += "boost-thread"

inherit cmake pkgconfig cmake_qt5

#EXTRA_OECMAKE += "-DCMAKE_CXX_STANDARD=17"
#EXTRA_OECMAKE += "-DCMAKE_CXX_STANDARD_REQUIRED=ON"
#EXTRA_OECMAKE += "-DCMAKE_CXX_FLAGS=-std=c++17"
EXTRA_OECMAKE += "-DGST_BUILD=true"
#EXTRA_OECMAKE += "-DCMAKE_THREAD_PREFER_PTHREAD=TRUE"
#EXTRA_OECMAKE += "-DCMAKE_HAVE_THREADS_LIBRARY=1"
#EXTRA_OECMAKE += "-DCMAKE_FIND_ROOTH_PATH=${RECIPE_SYSROOT}"
#EXTRA_OECMAKE += "-DCMAKE_PREFIX_PATH=${RECIPE_SYSROOT}"
#EXTRA_OECMAKE += "-DBoost_NO_BOOST_CMAKE=TRUE"
EXTRA_OECMAKE += "-DBoost_NO_SYSTEM_PATHS=ON"
EXTRA_OECMAKE += "-DBOOST_ROOT=${RECIPE_SYSROOT}/usr"
EXTRA_OECMAKE += "-DBOOST_INCLUDEDIR=${RECIPE_SYSROOT}/usr/include"
EXTRA_OECMAKE += "-DBOOST_LIBRARYDIR=${RECIPE_SYSROOT}/usr/lib"
EXTRA_OECMAKE += "-DBoost_VERBOSE=1"
EXTRA_OECMAKE += "-DCMAKE_FIND_ROOTH_PATH=${RECIPE_SYSROOT}/lib"
EXTRA_OECMAKE += "-DCMAKE_THREAD_LIBS_INIT=pthread"