LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0-only;md5=c79ff39f19dfec6d293b95dea7b07891"

SRC_URI="git://github.com/aizvorski/h264bitstream.git;branch=master;protocol=https"
SRCREV="${AUTOREV}"

S = "${WORKDIR}/git"

DEPENDS += "alsa-utils automake-native autoconf-native"

inherit cmake pkgconfig

EXTRA_OECMAKE += "-DCMAKE_POSITION_INDEPENDENT_CODE=ON -DBUILD_SHARED_LIBS=ON -DCMAKE_CXX_STANDARD=17"
EXTRA_OECMAKE += "-DCMAKE_INSTALL_PREFIX=${RECIPE_SYSROOT}"

do_configure:prepend() {
    echo "myecho: ${D}"
    echo "myecho2: ${D}"
}

do_configure() {
    echo "configuring"
    echo "$(pwd)"
    #echo "${S}"
    #cd ${S}
    cmake ../git "-DCMAKE_INSTALL_PREFIX=${RECIPE_SYSROOT}"
}

do_compile(){
    echo "compiling"
    echo "$(pwd)"
    #cd build
    #echo "$(pwd)"
    make
}

FILES:${PN} = "${RECIPE_SYSROOT}/lib/*"
FILES:${PN}-dev = "${RECIPE_SYSROOT}/include/*.h"
FILES:${PN}-share = "${RECIPE_SYSROOT}/share"
FILES:${PN}-bin = "${RECIPE_SYSROOT}/bin"

do_install(){
    echo "myecho2: ${RECIPE_SYSROOT}"
    ls
    echo "$(pwd)"
    make install 
    rm "${RECIPE_SYSROOT}/share" -rf
}
