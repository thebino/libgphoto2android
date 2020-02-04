cmake_minimum_required(VERSION 3.4.1)
project("libltdl")

set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -DHAVE_CONFIG_H -DHAVE_LIBDL")
set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -fPIC -DPIC")
#set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -W -Wall")

add_library(ltdl SHARED src/ltdl.c)
include_directories(src)
include_directories(src/android)


# copy out the lib binary and remove generated files
set(distribution_DIR ${CMAKE_CURRENT_SOURCE_DIR}/../../../../../distribution)
set_target_properties(ltdl
        PROPERTIES
        LIBRARY_OUTPUT_DIRECTORY
        "${distribution_DIR}/ltdl/lib/${ANDROID_ABI}")
add_custom_command(TARGET ltdl POST_BUILD
        COMMAND "${CMAKE_COMMAND}" -E
        copy "${CMAKE_CURRENT_SOURCE_DIR}/src/ltdl.h"
        "${distribution_DIR}/ltdl/include/ltdl.h"
        COMMENT "Copying ltdl to output directory")
