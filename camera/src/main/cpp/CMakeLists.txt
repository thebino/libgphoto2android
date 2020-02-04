cmake_minimum_required(VERSION 3.4.1)

# enable verbose output from Makefile builds
set(CMAKE_VERBOSE_MAKEFILE on)

# show all common compiler warnings
set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -Wall")

# show all more common warnings
set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -Wextra")

# treat warnings as errors
set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -Werror")

# enables strict standard conformance
set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -pedantic-errors")

# enables warnings about conversions (float to int)
set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -Wconversion")

# enables warnings about sign conversions (signed and unsigned)
set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -Wsign-conversion")


# use CMAKE_FIND_ROOT_PATH and CMAKE_SYSROOT for find_library()
set(CMAKE_FIND_ROOT_PATH_MODE_LIBRARY BOTH)

# use CMAKE_FIND_ROOT_PATH and CMAKE_SYSROOT for find_file() and find_path()
set(CMAKE_FIND_ROOT_PATH_MODE_INCLUDE BOTH)

# use CMAKE_FIND_ROOT_PATH and CMAKE_SYSROOT for find_package()
set(CMAKE_FIND_ROOT_PATH_MODE_PACKAGE BOTH)


#
# camera-lib
#
add_library(camera SHARED camera.c camera.h config.c)

#
# libgphoto2
#
include_directories(libgphoto2/libgphoto2-2.5.23)
include_directories(libgphoto2/libgphoto2-2.5.23/gphoto2)

#
# libgphoto2_port
#
include_directories(libgphoto2/libgphoto2-2.5.23/libgphoto2_port)
include_directories(libgphoto2/libgphoto2-2.5.23/libgphoto2_port/gphoto2)

# create tmp dir
set(lib_build_DIR $ENV{HOME}/tmp/${ANDROID_ABI})
file(MAKE_DIRECTORY ${lib_build_DIR})


#
# export camera lib into distribution dir
#
set(distribution_DIR ${CMAKE_CURRENT_SOURCE_DIR}/../../../../../distribution)
set_target_properties(camera PROPERTIES
        LIBRARY_OUTPUT_DIRECTORY
        "${distribution_DIR}/camera/lib/${ANDROID_ABI}")

# copy camera header into distribution
add_custom_command(TARGET camera POST_BUILD
        COMMAND "${CMAKE_COMMAND}" -E
        copy "${CMAKE_CURRENT_SOURCE_DIR}/camera.h"
        "${distribution_DIR}/camera/include/camera.h"
        COMMENT "Copying camera to output directory")

#
# libltdl
#
add_subdirectory(${CMAKE_CURRENT_SOURCE_DIR}/ltdl ${lib_build_DIR}/ltdl)
include_directories(${CMAKE_CURRENT_SOURCE_DIR}/ltdl/src)

add_subdirectory(${CMAKE_CURRENT_SOURCE_DIR}/libgphoto2 ${lib_build_DIR}/libgphoto2)

#
# android log
#
find_library(log-lib log)

#
# linking
#
target_link_libraries(camera
        libgphoto2
        libgphoto2_port
        ${log-lib})

#
# libusb1
#
#add_subdirectory(${lib_src_DIR}/usb ${CMAKE_CURRENT_SOURCE_DIR}/usb)
