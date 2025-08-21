SUMMARY = "Summit Greengrass Support"
DESCRIPTION = "Support for Greengrass V2 on Summit SOM 8M Plus"
PR = "r1"

LICENSE = "Ezurio"
NO_GENERIC_LICENSE[Ezurio] = "LICENSE.ezurio"
LIC_FILES_CHKSUM = "file://LICENSE.ezurio;md5=fd3dd0630b215465b6f50540642d5b93"

SRC_URI += "\
    file://greengrass.service;subdir=src \
    file://LICENSE.ezurio;subdir=src \
    "

S = "${WORKDIR}/src"

FILES:${PN} += "${systemd_system_unitdir}"

SYSTEMD_SERVICE:${PN} = "greengrass.service"
SYSTEMD_AUTO_ENABLE = "enable"

inherit useradd systemd

# Configure Greengrass user and group via useradd
USERADD_PACKAGES = "${PN}"
USERADD_PARAM:${PN} = "--uid 200 --gid 200 --home-dir /home/ggc_user --system --shell /bin/bash ggc_user"
GROUPADD_PARAM:${PN} = "--gid 200 ggc_group"

do_install () {
    if ${@bb.utils.contains('DISTRO_FEATURES','systemd','true','false',d)}; then
        install -D -m 0644 ${S}/greengrass.service ${D}${systemd_system_unitdir}/greengrass.service
    fi
}
