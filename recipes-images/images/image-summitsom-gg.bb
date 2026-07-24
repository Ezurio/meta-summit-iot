DESCRIPTION = "Summit SOM AWS Greengrass Image"

FILESEXTRAPATHS:append := "\
${TOPDIR}/../sources/meta-summit-som/recipes-summit/images/files/nomcu:\
${TOPDIR}/../sources/meta-summit-som/recipes-summit/images/files:\
"

inherit image-summitsom-gen image-summitsom-sd-gen image-summitsom-swu-gen

CORE_IMAGE_EXTRA_INSTALL += "\
    packagegroup-summit-basic \
    packagegroup-summit-dvk \
    packagegroup-summit-diag \
    libp11 \
    opensc \
    procps \
    sudo \
    greengrass-bin \
    python3 \
    python3-can \
    python3-core \
    python3-daemon \
    python3-dbus \
    python3-libconf \
    python3-pyaudio \
    python3-pyserial \
    python3-psutil \
    python3-pyudev \
    python3-requests \
    python3-spidev \
    "
