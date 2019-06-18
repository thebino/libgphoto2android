@file:Suppress("FunctionName", "MemberVisibilityCanBePrivate")

package org.gphoto2

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class Camera {
    private var isInitialized = false

    companion object {
        init {
//            val libs = arrayOf("exif2", "ltdl", "regex", "usb2", "usb-compat", "gphoto2_port", "gphoto2", "gphoto2_jni")
//            for (lib in libs) {
//                System.loadLibrary(lib)
//            }
            System.loadLibrary("jni-wrapper")
        }
    }

    private var ptr: Long = 0

    init {
        if (!isInitialized) {
            ptr = create()
        }
    }

    private external fun create(): Long

    private external fun getLibraryVersion(): String

    private external fun capture(): Long

    fun libraryVersion(): String {
        return getLibraryVersion()
    }


    fun captureImage() {
        val foo  = GlobalScope.launch(Dispatchers.Main) {
            val result = withContext(Dispatchers.IO) {
                // TODO: do long running staff
                capture()
            }

            // TODO: send result to ui
        }
    }
}
