cmake_minimum_required(VERSION 3.4.1)
project("libexif2")

set(CMAKE_VERBOSE_MAKEFILE on)

#include(ExternalProject)
#ExternalProject_add(libexif
#        URL http://sourceforge.net/projects/libexif/files/libexif/0.6.21/libexif-0.6.21.tar.gz
#        PREFIX ${CMAKE_CURRENT_BINARY_DIR}/libexif-0.6.21
#        CONFIGURE_COMMAND <SOURCE_DIR>/configure --prefix=<INSTALL_DIR>
#        BUILD_COMMAND make
#        INSTALL_COMMAND make install
#        DOWNLOAD_DIR ${CMAKE_CURRENT_BINARY_DIR}/download
#        BUILD_IN_SOURCE 1
#        )

include_directories(.)
include_directories(libexif-0.6.21)
include_directories(libexif-0.6.21/libexif)
include_directories(libexif-0.6.21/libexif/canon)
include_directories(libexif-0.6.21/libexif/fuji)
include_directories(libexif-0.6.21/libexif/olympus)
include_directories(libexif-0.6.21/libexif/pentax)

add_library(libexif SHARED
        config.h
        libexif/exif-byte-order.c
        libexif/exif-content.c
        libexif/exif-data.c
        libexif/exif-entry.c
        libexif/exif-format.c
        libexif/exif-ifd.c
        libexif/exif-loader.c
        libexif/exif-log.c
        libexif/exif-mem.c
        libexif/exif-mnote-data.c
        libexif/exif-mnote-data-priv.h
        libexif/exif-tag.c
        libexif/exif-utils.c
        libexif/i18n.h
        libexif/canon/exif-mnote-data-canon.c
        libexif/canon/mnote-canon-entry.c
        libexif/canon/mnote-canon-tag.c
        libexif/fuji/exif-mnote-data-fuji.c
        libexif/fuji/mnote-fuji-entry.c
        libexif/fuji/mnote-fuji-tag.c
        libexif/olympus/exif-mnote-data-olympus.c
        libexif/olympus/mnote-olympus-entry.c
        libexif/olympus/mnote-olympus-tag.c
        libexif/pentax/exif-mnote-data-pentax.c
        libexif/pentax/mnote-pentax-entry.c
        libexif/pentax/mnote-pentax-tag.c)


add_definitions(/D__STDC_FORMAT_MACROS)

set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -W -Wall")
set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -fPIC -DPIC")
set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -DGETTEXT_PACKAGE=\"libexif-12\"")

# copy out the lib binary
set(distribution_DIR ${CMAKE_CURRENT_SOURCE_DIR}/../../../../../distribution)
set_target_properties(libexif
        PROPERTIES
        LIBRARY_OUTPUT_DIRECTORY
        "${distribution_DIR}/libexif/lib/${ANDROID_ABI}")
add_custom_command(TARGET libexif POST_BUILD
        COMMAND "${CMAKE_COMMAND}" -E
        copy "${CMAKE_CURRENT_SOURCE_DIR}/src/exif.h"
        "${distribution_DIR}/libexif/include/exif.h"
        COMMENT "Copying libexif to output directory")
