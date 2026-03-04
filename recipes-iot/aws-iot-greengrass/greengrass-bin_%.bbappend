FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = "\
    file://01-gg-data-root.conf \
    "

do_install:append() {
    if [ "${@bb.utils.filter('DISTRO_FEATURES', 'systemd', d)}" ]; then
        install -Dm 0644 ${UNPACKDIR}/01-gg-data-root.conf \
            ${D}${systemd_system_unitdir}/greengrass.service.d/01-gg-data-root.conf
    fi
}

FILES:${PN}:append = " ${systemd_system_unitdir}/greengrass.service.d"
