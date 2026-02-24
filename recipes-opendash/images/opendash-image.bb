require recipes-core/images/core-image-minimal.bb

IMAGE_INSTALL:append = " libstdc++" 
#IMAGE_INSTALL:append = " openssh openssl openssh-sftp-server"
#IMAGE_INSTALL:append = " raspi-gpio"
#IMAGE_INSTALL += "kernel-module-spidev kernel-module-spi-bcm2835"
#IMAGE_INSTALL:append = " rpi-gpio"
#IMAGE_INSTALL += "bluez5"

IMAGE_INSTALL:append = " dash"
IMAGE_INSTALL:append = " xserver-xorg"
IMAGE_INSTALL:append = " xinit"
IMAGE_INSTALL:append = " xf86-video-modesetting"
IMAGE_INSTALL:append = " xf86-input-evdev"
IMAGE_INSTALL:append = " xauth"
IMAGE_INSTALL:append = " mesa"
IMAGE_INSTALL:append = " libgl-mesa libegl-mesa"
IMAGE_INSTALL:append = " xterm"
#IMAGE_INSTALL:append = " xf86-video-fbdev"
#IMAGE_INSTALL:append = " xkeyboard-config"
#IMAGE_INSTALL:append = " xkbcomp glfw"
#IMAGE_INSTALL:append = " qtbase"
#IMAGE_INSTALL:append = " qtbase-plugins"
#IMAGE_INSTALL:append = " libxkbcommon"
IMAGE_INSTALL:append = " xf86-input-libinput "
#IMAGE_INSTALL:append = " fontconfig libxft pango ttf-pt-sans"
IMAGE_INSTALL:append = " xserver-xorg-extension-glx"
IMAGE_INSTALL:append = " dropbear"
IMAGE_INSTALL:append = " xclock xterm"
IMAGE_INSTALL:append = " openbox"

IMAGE_INSTALL:append = " \
    libdrm \
    libegl \
    libgbm \
"
IMAGE_INSTALL:append = " glibc-localedata-en-us libinput"
IMAGE_INSTALL:append = " xinput "
