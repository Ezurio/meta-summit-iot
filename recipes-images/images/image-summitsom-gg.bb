DESCRIPTION = "Summit SOM AWS Greengrass Image"

inherit image-summitsom-gen image-summitsom-sd-gen image-summitsom-swu-gen

CORE_IMAGE_EXTRA_INSTALL += "\
    ${IMAGE_INSTALL_BASIC} \
    libp11 \
    opensc \
    procps \
    sudo \
    openjre-8 \
    summit-gg \
    python3 \
    python3-can \
    python3-core \
    python3-daemon \
    python3-dbus \
    python3-libconf \
    python3-pathtools3 \
    python3-pyaudio \
    python3-pyserial \
    python3-psutil \
    python3-pyudev \
    python3-requests \
    python3-spidev \
	"
