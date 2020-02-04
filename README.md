# libgphoto2android
> Android Wrapper around libgphoto2 to connect and remote control digital cameras via usb.

[![CC-BY license](https://img.shields.io/badge/License-CC--BY-blue.svg)](https://creativecommons.org/licenses/by-nd/4.0)
[![Build Status](https://travis-ci.org/thebino/libgphoto2android.svg?branch=master)](https://travis-ci.org/thebino/libgphoto2android)

This project is an android wrapper around the gphoto2 library (libgphoto2) 
which main purpose is to connect and remote control digital cameras.

 * For a full description of libgphoto2 visit:
  http://gphoto.org/proj/libgphoto2/

 * To submit bug reports and feature suggestions or to track changes visit:
  https://github.com/thebino/libgphoto2android

## Installation

run docker image with android ndk
```sh
docker run --rm -it -v ${PWD}:/root android-build-environment:0.0.6
```


create a standalone toolchain into `my-toolchain`
```sh
$ANDROID_NDK_HOME/build/tools/make-standalone-toolchain.sh --arch=arm --install-dir=my-toolchain --force
python3 /usr/local/android-sdk/ndk/20.0.5594570/build/tools/make_standalone_toolchain.py --arch arm --install-dir my-toolchain --force
```


add created toolchain to path
```sh
export PATH=$PATH:`pwd`/my-toolchain/bin
```


download and unzip libgphoto2 
```sh
tar -xvf ../libgphoto2-latest.tar.bz2 
```


set environment vars for cross-compile
```sh
target_host=arm-linux-androideabi
export AR=$target_host-ar
export AS=$target_host-clang
export CC=$target_host-clang
export CXX=$target_host-clang++
export LD=$target_host-ld
export STRIP=$target_host-strip
export CFLAGS="-fPIE -fPIC"
export LDFLAGS="-pie"
```


change into libgphoto2 directory and run configure command
```sh
./configure --host=arm-linux-androideabi --prefix=/root/libgphoto2-2.5.23/output --with-sysroot="/usr/local/android-sdk/ndk/20.0.5594570/sysroot/usr/lib/arm-linux-androideabi/"
```

build library
```sh
make install
```


## Release History

* 0.1.0
    * ADD: Add `getLibraryVersion` and `create()`
* 0.0.1
    * First draft

## Meta

Benjamin Stürmer – [@benjaminstrmer](https://twitter.com/benjaminstrmer) – webmaster@stuermer-benjamin.de

Distributed under the Attribution 4.0 International (CC BY 4.0) license. See ``LICENSE`` for more information.

[https://github.com/yourname/github-link](https://github.com/dbader/)

## Contributing

1. Fork it (https://github.com/thebino/libgphoto2android/fork>)
2. Create your feature branch (`git checkout -b feature/fooBar`)
3. Commit your changes (`git commit -am 'Add some fooBar'`)
4. Push to the branch (`git push origin feature/fooBar`)
5. Create a new Pull Request
