cmake_minimum_required(VERSION 3.4.1)
project("libgphoto2")

#include(ExternalProject)
#ExternalProject_add(libexif
#        URL https://sourceforge.net/projects/gphoto/files/libgphoto/2.5.23/libgphoto2-2.5.23.tar.gz
#        PREFIX ${CMAKE_CURRENT_BINARY_DIR}/libgphoto2-2.5.23
#        CONFIGURE_COMMAND <SOURCE_DIR>/configure --prefix=<INSTALL_DIR>
#        BUILD_COMMAND make
#        INSTALL_COMMAND make install
#        DOWNLOAD_DIR ${CMAKE_CURRENT_BINARY_DIR}/download
#        BUILD_IN_SOURCE 1
#        )


# specify path to header files during compile time
include_directories(.)  # config.h
include_directories(libgphoto2-2.5.23/gphoto2)
include_directories(libgphoto2-2.5.23)

add_library(libgphoto2 SHARED
        libgphoto2-2.5.23/gphoto2/
        libgphoto2-2.5.23/libgphoto2/ahd_bayer.c
        libgphoto2-2.5.23/libgphoto2/bayer.c
        libgphoto2-2.5.23/libgphoto2/bayer.h
        libgphoto2-2.5.23/libgphoto2/exif.c
        libgphoto2-2.5.23/libgphoto2/exif.h
        libgphoto2-2.5.23/libgphoto2/gamma.c
        libgphoto2-2.5.23/libgphoto2/gamma.h
        libgphoto2-2.5.23/libgphoto2/gphoto2-abilities-list.c
        libgphoto2-2.5.23/libgphoto2/gphoto2-camera.c
        libgphoto2-2.5.23/libgphoto2/gphoto2-context.c
        libgphoto2-2.5.23/libgphoto2/gphoto2-file.c
        libgphoto2-2.5.23/libgphoto2/gphoto2-filesys.c
        libgphoto2-2.5.23/libgphoto2/gphoto2-list.c
        libgphoto2-2.5.23/libgphoto2/gphoto2-result.c
        libgphoto2-2.5.23/libgphoto2/gphoto2-setting.c
        libgphoto2-2.5.23/libgphoto2/gphoto2-version.c
        libgphoto2-2.5.23/libgphoto2/gphoto2-widget.c
        libgphoto2-2.5.23/libgphoto2/jpeg.c
        libgphoto2-2.5.23/libgphoto2/jpeg.h)



# specify path to header files during compile time
include_directories(libgphoto2-2.5.23/libgphoto2_port/gphoto2)
include_directories(libgphoto2-2.5.23/libgphoto2_port)

add_library(libgphoto2_port SHARED
        libgphoto2-2.5.23/libgphoto2_port/libgphoto2_port/gphoto2-port.c
        libgphoto2-2.5.23/libgphoto2_port/libgphoto2_port/gphoto2-port-info.h
        libgphoto2-2.5.23/libgphoto2_port/libgphoto2_port/gphoto2-port-info-list.c
        libgphoto2-2.5.23/libgphoto2_port/libgphoto2_port/gphoto2-port-log.c
        libgphoto2-2.5.23/libgphoto2_port/libgphoto2_port/gphoto2-port-portability.c
        libgphoto2-2.5.23/libgphoto2_port/libgphoto2_port/gphoto2-port-result.c
        libgphoto2-2.5.23/libgphoto2_port/libgphoto2_port/gphoto2-port-version.c)


target_link_libraries(libgphoto2
        ltdl
        libgphoto2_port)


set_target_properties(libgphoto2
        PROPERTIES
        LIBRARY_OUTPUT_DIRECTORY
        "${distribution_DIR}/libgphoto2/lib/${ANDROID_ABI}")

add_custom_command(TARGET libgphoto2 POST_BUILD
        COMMAND "${CMAKE_COMMAND}" -E
        copy "libgphoto2-2.5.23/gphoto2/gphoto2.h" "${distribution_DIR}/gphoto2/include/gphoto2.h"
        COMMENT "Copying libgphoto2 to output directory")
