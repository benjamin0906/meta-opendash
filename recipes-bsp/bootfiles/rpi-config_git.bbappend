do_deploy:append() {
    sed -i '/#kernel=/ c\kernel=kernel8.img' $CONFIG
    echo 'arm_64bit=1' >> $CONFIG
    #sed -i '/#dtparam=spi=off/ c\dtparam=spi=on' $CONFIG
}
