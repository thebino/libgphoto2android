cmake_minimum_required(VERSION 3.4.1)

# download libgphoto from sourceforge, unzip and build with make (configure && make && make install
include(ExternalProject)

set(LIBGPHOTO2_ROOT ${Project_BINARY_DIR}/project_libgphoto2/src)

ExternalProject_Add(project_libgphoto2
        URL https://sourceforge.net/projects/gphoto/files/latest/download
        DOWNLOAD_NO_PROGRESS 1

        # Configure
        CONFIGURE_COMMAND <SOURCE_DIR>/configure --prefix=<INSTALL_DIR> --host aarch64-linux-android
        LOG_CONFIGURE 1
        )

#add_library(libgphoto2 SHARED IMPORTED)
#add_dependencies(libgphoto2 project_libgphoto2)



# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

#add_library(gphoto2 SHARED IMPORTED)
#set_target_properties(gphoto2 PROPERTIES
#        # so location
#        IMPORTED_LOCATION "${CMAKE_CURRENT_LIST_DIR}/../jniLibs/libgphoto2.dylib"
#        # header location
#        INTERFACE_INCLUDE_DIRECTORIES "${CMAKE_CURRENT_LIST_DIR}"
#        )


add_library( # Sets the name of the library.
        jni-wrapper

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        jni-wrapper.c)
add_dependencies(jni-wrapper project_libgphoto2)

## Searches for a specified prebuilt library and stores the path as a
## variable. Because CMake includes system libraries in the search path by
## default, you only need to specify the name of the public NDK library
## you want to add. CMake verifies that the library exists before
## completing its build.
#
#find_library( # Sets the name of the path variable.
#        log-lib
#
#        # Specifies the name of the NDK library that
#        # you want CMake to locate.
#        log)


# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
        jni-wrapper

        # Links the target library to the log library
        # included in the NDK.
        log libgphoto2)


include_directories(jni-wrapper PRIVATE gphoto2)
