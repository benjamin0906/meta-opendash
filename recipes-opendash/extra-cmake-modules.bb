LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0-only;md5=c79ff39f19dfec6d293b95dea7b07891"

SRC_URI="git://github.com/KDE/extra-cmake-modules.git;branch=master;protocol=https"
SRCREV="${AUTOREV}"

S = "${WORKDIR}/git"

inherit cmake pkgconfig cmake_qt5

EXTRA_OECMAKE += "-DCMAKE_CXX_STANDARD=17 -DCMAKE_CXX_STANDARD_REQUIRED=ON -DCMAKE_CXX_FLAGS=-std=c++17 -DGST_BUILD=true"
BBCLASSEXTEND = "native"

FILES:${PN} += "/usr/share/ECM"

RDEPENDS:${PN} += "python3 python3-setuptools python3-core"


do_install:append() {
    echo "SHARE_INSTALL_DIR: ${SHARE_INSTALL_DIR}"
    echo "FIND_MODULES_INSTALL_DIR: ${FIND_MODULES_INSTALL_DIR}"
    echo "share: ${share}"
}