#include <jni.h>
#include <android/log.h>
#include <malloc.h>
#include <stdio.h>
#include <string.h>

#include <jni.h>
#include <android/log.h>
#include <inttypes.h>

#include "camera.h"
#include <gphoto2/gphoto2-camera.h>
#include <gphoto2/gphoto2-version.h>

#define LOGI(...) \
  ((void)__android_log_print(ANDROID_LOG_INFO, "camera-lib::", __VA_ARGS__))

#define LOGW(...) \
  ((void)__android_log_print(ANDROID_LOG_WARN, "camera-lib::", __VA_ARGS__))

#define LOGE(...) \
  ((void)__android_log_print(ANDROID_LOG_ERROR, "camera-lib::", __VA_ARGS__))


JNIEXPORT jstring JNICALL
Java_de_stuermerbenjamin_android_gphoto2_Camera_getLibraryVersion(JNIEnv *env, jobject thiz) {
    LOGE("create() -> TODO: link libgphoto2");

    return gp_library_version(GP_VERSION_SHORT);
}


jlong Java_de_stuermerbenjamin_android_gphoto2_Camera_create(JNIEnv *env, jobject obj) {
    Camera *camera;
    int ret;
    char *owner;
    GPContext *context;
    CameraText text;

    context = gp_context_new();
    gp_camera_new(&camera);

    /* This call will autodetect cameras, take the
     * first one from the list and use it. It will ignore
     * any others... See the *multi* examples on how to
     * detect and use more than the first one.
     */
    ret = gp_camera_init(camera, context);
    if (ret < GP_OK) {
        LOGW("No camera auto detected.\n");
        gp_camera_free(camera);
        return 0;
    }

    /* Simple query the camera summary text */
    ret = gp_camera_get_summary(camera, &text, context);
    if (ret < GP_OK) {
        LOGW("Camera failed retrieving summary.\n");
        gp_camera_free(camera);
        return 0;
    }
    LOGI("Summary:\n%s\n", text.text);

    /* Simple query of a string configuration variable. */
    ret = get_config_value_string(camera, "owner", &owner, context);
    if (ret >= GP_OK) {
        LOGI("Owner: %s\n", owner);
        free(owner);
    }

    gp_camera_exit(camera, context);
    gp_camera_free(camera);
    gp_context_unref(context);

    return 0;
}
