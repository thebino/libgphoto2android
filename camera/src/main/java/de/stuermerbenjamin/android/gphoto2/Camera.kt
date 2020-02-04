package de.stuermerbenjamin.android.gphoto2

class Camera {

    companion object {
        init {
            System.loadLibrary("camera")
        }
    }

    private external fun getLibraryVersion(): String
    private external fun create(): Long

    fun libraryVersion(): String {
        return getLibraryVersion()
    }

    fun createCamera() {
        create()
    }
}
