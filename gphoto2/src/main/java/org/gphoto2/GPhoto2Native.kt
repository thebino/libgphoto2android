@file:Suppress("FunctionName")

package org.gphoto2

@Suppress("unused")
object GPhoto2Native {
    /**
     * Corrupted data received
     *
     * Data is corrupt. This error is reported by camera drivers if corrupted
     * data has been received that can not be automatically handled. Normally,
     * drivers will do everything possible to automatically recover from this
     * error.
     *
     */
    const val GP_ERROR_CORRUPTED_DATA = -102

    /**
     * File already exists
     *
     * An operation failed because a file existed. This error is reported for
     * example when the user tries to create a file that already exists.
     *
     */
    const val GP_ERROR_FILE_EXISTS = -103

    /**
     * Specified camera model was not found
     *
     * The specified model could not be found. This error is reported when the
     * user specified a model that does not seem to be supported by any driver.
     *
     */
    const val GP_ERROR_MODEL_NOT_FOUND = -105

    /**
     * Specified directory was not found
     *
     * The specified directory could not be found. This error is reported when
     * the user specified a directory that is non-existent.
     *
     */
    const val GP_ERROR_DIRECTORY_NOT_FOUND = -107

    /**
     * Specified file was not found
     *
     * The specified file could not be found. This error is reported when the
     * user wants to access a file that is non-existent.
     *
     */
    const val GP_ERROR_FILE_NOT_FOUND = -108

    /**
     * Specified directory already exists
     *
     * The specified directory already exists. This error is reported for
     * example when the user wants to create a directory that already exists.
     *
     */
    const val GP_ERROR_DIRECTORY_EXISTS = -109

    /**
     * The camera is already busy
     *
     * Camera I/O or a command is in progress.
     *
     */
    const val GP_ERROR_CAMERA_BUSY = -110

    /**
     * Path is not absolute
     *
     * The specified path is not absolute. This error is reported when the user
     * specifies paths that are not absolute, i.e. paths like
     * "path/to/directory". As a rule of thumb, in gphoto2, there is nothing
     * like relative paths.
     *
     */
    const val GP_ERROR_PATH_NOT_ABSOLUTE = -111

    /**
     * Cancellation successful.
     *
     * A cancellation requestion by the frontend via progress callback and
     * GP_CONTEXT_FEEDBACK_CANCEL was successful and the transfer has been
     * aborted.
     */
    const val GP_ERROR_CANCEL = -112

    /**
     * Unspecified camera error
     *
     * The camera reported some kind of error. This can be either a photographic
     * error, such as failure to autofocus, underexposure, or violating storage
     * permission, anything else that stops the camera from performing the
     * operation.
     */
    const val GP_ERROR_CAMERA_ERROR = -113

    /**
     * Unspecified failure of the operating system
     *
     * There was some sort of OS error in communicating with the camera, e.g.
     * lack of permission for an operation.
     */
    const val GP_ERROR_OS_FAILURE = -114

    /**
     * \brief Everything is OK
     *
     * Note that this is also the value 0, and every error is negative (lower).
     */
    const val GP_OK = 0

    /**
     * \brief Generic Error
     */
    const val GP_ERROR = -1

    /**
     * \brief Bad parameters passed
     */
    const val GP_ERROR_BAD_PARAMETERS = -2

    /**
     * \brief Out of memory
     */
    const val GP_ERROR_NO_MEMORY = -3

    /**
     * \brief Error in the camera driver
     */
    const val GP_ERROR_LIBRARY = -4

    /**
     * \brief Unknown libgphoto2 port passed
     */
    const val GP_ERROR_UNKNOWN_PORT = -5

    /**
     * \brief Functionality not supported
     */
    const val GP_ERROR_NOT_SUPPORTED = -6

    /**
     * \brief Generic I/O error
     */
    const val GP_ERROR_IO = -7

    /**
     * \brief Buffer overflow of internal structure
     */
    const val GP_ERROR_FIXED_LIMIT_EXCEEDED = -8

    /**
     * \brief Operation timed out
     */
    const val GP_ERROR_TIMEOUT = -10

    /**
     * \brief Serial ports not supported
     */
    const val GP_ERROR_IO_SUPPORTED_SERIAL = -20

    /**
     * \brief USB ports not supported
     */
    const val GP_ERROR_IO_SUPPORTED_USB = -21

    /**
     * \brief Error initialising I/O
     */
    const val GP_ERROR_IO_INIT = -31

    /**
     * \brief I/O during read
     */
    const val GP_ERROR_IO_READ = -34

    /**
     * \brief I/O during write
     */
    const val GP_ERROR_IO_WRITE = -35

    /**
     * \brief I/O during update of settings
     */
    const val GP_ERROR_IO_UPDATE = -37

    /**
     * \brief Specified serial speed not possible.
     */
    const val GP_ERROR_IO_SERIAL_SPEED = -41

    /**
     * \brief Error during USB Clear HALT
     */
    const val GP_ERROR_IO_USB_CLEAR_HALT = -51

    /**
     * \brief Error when trying to find USB device
     */
    const val GP_ERROR_IO_USB_FIND = -52

    /**
     * \brief Error when trying to claim the USB device
     */
    const val GP_ERROR_IO_USB_CLAIM = -53

    /**
     * \brief Error when trying to lock the device
     */
    const val GP_ERROR_IO_LOCK = -60

    /**
     * \brief Unspecified error when talking to HAL
     */
    const val GP_ERROR_HAL = -70
    const val GP_CAPTURE_IMAGE = 0
    const val GP_CAPTURE_MOVIE = 1
    const val GP_CAPTURE_SOUND = 2
    const val GP_FILE_TYPE_NORMAL = 1
    const val GP_VERSION_SHORT = 0
    const val GP_VERSION_VERBOSE = 1

    // TODO: INSTANCE needed??
    //var INSTANCE = System.loadLibrary("gphoto2", GPhoto2Native::class.java) as GPhoto2Native

    external fun gp_camera_new(pcamera: PointerByReference): Int

    external fun gp_camera_init(pcamera: Pointer, gpcontext: Pointer): Int

    external fun gp_camera_exit(pcamera: Pointer, gpcontext: Pointer): Int

    external fun gp_camera_free(pcamera: Pointer): Int

    external fun gp_context_new(): Pointer

    external fun gp_result_as_string(result: Int): String

    external fun gp_file_new(p: PointerByReference): Int

    external fun gp_file_free(cf: Pointer): Int

    external fun gp_camera_capture_preview(camera: Pointer, cf: Pointer, context: Pointer): Int

    external fun gp_file_save(cf: Pointer, filename: String): Int

    external fun gp_camera_capture(camera: Pointer, GP_CAPTURE_IMAGE: Int, path: CameraFilePath, context: Pointer): Int

    external fun gp_camera_file_get(
        cam: Pointer,
        path: String,
        filename: String,
        GP_FILE_TYPE_NORMAL: Int,
        cf: Pointer,
        context: Pointer
    ): Int

    external fun gp_camera_ref(camera: Pointer): Int

    external fun gp_camera_unref(camera: Pointer): Int

    external fun gp_camera_get_config(camera: Pointer, widget: PointerByReference, context: Pointer): Int

    external fun gp_camera_set_config(camera: Pointer, widget: Pointer, context: Pointer): Int

    external fun gp_file_ref(cf: Pointer): Int

    external fun gp_file_unref(cf: Pointer): Int

    external fun gp_library_version(GP_VERSION_VERBOSE: Int): Array<String>

    external fun gp_list_new(ref: PointerByReference): Int

    external fun gp_list_free(list: Pointer): Int

    external fun gp_port_info_list_new(ref: PointerByReference): Int

    external fun gp_port_info_list_load(list: Pointer): Int

    external fun gp_port_info_list_count(list: Pointer): Int

    external fun gp_abilities_list_new(ref: PointerByReference): Int

    external fun gp_abilities_list_load(ptr: Pointer, ctx: Pointer): Int

    external fun gp_abilities_list_detect(
        cameraAbilitiesList: Pointer,
        portInfoList: Pointer,
        list: Pointer,
        context: Pointer
    ): Int

    external fun gp_list_count(list: Pointer): Int

    external fun gp_list_get_name(list: Pointer, i: Int, pmodel: PointerByReference): Int

    external fun gp_list_append(list: Pointer, model: String, path: String): Int

    external fun gp_list_get_value(tempList: Pointer, i: Int, pvalue: PointerByReference): Int

    external fun gp_abilities_list_free(cameraAbilitiesList: Pointer)

    external fun gp_port_info_list_free(portInfoList: Pointer)

    external fun gp_port_info_list_get_info(portInfoList: Pointer, n: Int, portInfo: PointerByReference): Int

    external fun gp_camera_set_port_info(camera: Pointer, portInfo: Pointer): Int

    external fun gp_file_clean(cf: Pointer): Int

    /**
     * A structure created by the capture operation.
     *
     * A structure containing the folder and filename of an object after a
     * successful capture and is passed as reference to the gp_camera_capture()
     * function.
     */
//    class CameraFilePath : Structure() {
//        /**
//         * Name of the captured file.
//         */
//        var name = ByteArray(128)
//        /**
//         * Name of the folder of the captured file.
//         */
//        var folder = ByteArray(1024)
//
//        // fixes compatibility with JNA 3.5.0 and higher.
//        // see https://github.com/mvysny/gphoto2-java/issues/10 for details.
//        val fieldOrder: List<*>
//            get() = Arrays.asList("name", "folder")
//
//        init {
//            // must not call with JNA 3.5.0 or higher.
//            //            setFieldOrder(new String[] { "name", "folder" });
//        }
//
//        class ByReference : CameraFilePath(), Structure.ByReference
//    }

    const val GP_WIDGET_WINDOW =
        0//  # Window widget This is the toplevel configuration widget. It should likely contain multiple GP_WIDGET_SECTION entries.
    const val GP_WIDGET_SECTION = 1// # Section widget (think Tab).
    const val GP_WIDGET_TEXT = 2//    # Text widget.
    const val GP_WIDGET_RANGE = 3//   # Slider widget.
    const val GP_WIDGET_TOGGLE = 4//  # Toggle widget (think check box).
    const val GP_WIDGET_RADIO = 5//   # Radio button widget.
    const val GP_WIDGET_MENU = 6//    # Menu widget (same as RADIO).
    const val GP_WIDGET_BUTTON = 7//  # Button press widget.
    const val GP_WIDGET_DATE = 8//    # Date entering widget.

    external fun gp_widget_new(type: Int, label: String, widget: PointerByReference): Int

    external fun gp_widget_free(widget: Pointer): Int

    external fun gp_widget_ref(widget: Pointer): Int

    external fun gp_widget_unref(widget: Pointer): Int

    external fun gp_widget_append(widget: Pointer, child: Pointer): Int

    external fun gp_widget_prepend(widget: Pointer, child: Pointer): Int

    external fun gp_widget_count_children(widget: Pointer): Int

    external fun gp_widget_get_child(widget: Pointer, child_number: Int, child: PointerByReference): Int

    /* Retrieve Widgets */
    external fun gp_widget_get_child_by_label(widget: Pointer, label: String, child: PointerByReference): Int

    external fun gp_widget_get_child_by_id(widget: Pointer, id: Int, child: PointerByReference): Int

    external fun gp_widget_get_child_by_name(widget: Pointer, name: String, child: PointerByReference): Int

    external fun gp_widget_get_root(widget: Pointer, root: PointerByReference): Int

    external fun gp_widget_get_parent(widget: Pointer, parent: PointerByReference): Int

    external fun gp_widget_set_value(widget: Pointer, value: Pointer): Int

    // TODO: use cameraFilePath instead of String
    //external fun gp_widget_get_value(widget: Pointer, value: CameraFilePath.ByReference): Int
    external fun gp_widget_get_value(widget: Pointer, value: String): Int

    external fun gp_widget_set_name(widget: Pointer, name: String): Int

    external fun gp_widget_get_name(widget: Pointer, name: PointerByReference): Int

    external fun gp_widget_set_info(widget: Pointer, info: String): Int

    external fun gp_widget_get_info(
        widget: Pointer,
        /**
         * char ** *
         */
        info: PointerByReference
    ): Int

    external fun gp_widget_get_id(widget: Pointer, id: IntByReference): Int

    external fun gp_widget_get_type(widget: Pointer, type: IntByReference): Int

    external fun gp_widget_get_label(
        widget: Pointer,
        /**
         * char ** *
         */
        label: PointerByReference
    ): Int

    external fun gp_widget_set_range(range: Pointer, low: Float, high: Float, increment: Float): Int

    external fun gp_widget_get_range(
        range: Pointer,
        min: FloatByReference,
        max: FloatByReference,
        increment: FloatByReference
    ): Int

    external fun gp_widget_add_choice(widget: Pointer, choice: String): Int

    external fun gp_widget_count_choices(widget: Pointer): Int

    external fun gp_widget_get_choice(
        widget: Pointer, choice_number: Int,
        /**
         * char ** *
         */
        choice: PointerByReference
    ): Int

    external fun gp_widget_changed(widget: Pointer): Int

    external fun gp_widget_set_changed(widget: Pointer, changed: Int): Int

    external fun gp_widget_set_readonly(widget: Pointer, readonly: Int): Int

    external fun gp_widget_get_readonly(widget: Pointer, readonly: IntByReference): Int
}
