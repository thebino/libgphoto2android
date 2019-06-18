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

Docker based android build including native build with android ndk:

```sh
docker run -v "$PWD":/app libgphoto2android
```

## Release History

* 0.1.1
    * CHANGE: Rename `getVersion()` to `getLibraryVersion()`
* 0.1.0
    * The first proper release
    * ADD: Add `create`, `getVersion()` and `capture()`
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
