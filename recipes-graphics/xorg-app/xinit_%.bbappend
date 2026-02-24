SUMMARY = "Overwriting the deployed xinitrc file to meet the layer specific needs"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://xinitrc"

do_install:append() {
    install -m 0755 ${UNPACKDIR}/xinitrc ${D}/etc/X11/xinit/xinitrc
}