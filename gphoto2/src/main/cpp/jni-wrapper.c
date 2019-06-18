/** \file
 * \brief java native interface for GPHOTO2 camera

 * \author Copyright 2019 Benjamin Stürmer

 * \par License
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 *
 * \par
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * \par
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor,
 * Boston, MA  02110-1301  USA
*/

#include <jni.h>
#include <android/log.h>
#include <malloc.h>

#include <gphoto2/gphoto2-version.h>
#include <gphoto2/gphoto2-camera.h>
#include <gphoto2/gphoto2-port-version.h>
#include <gphoto2/gphoto2-context.h>
#include <gphoto2/gphoto2-port-log.h>

jlong Java_de_stuermerbenjamin_Camera_create(JNIEnv *env, jobject obj)
{
    (void) env;
    (void) obj;

    Camera	*camera;
    gp_camera_new(&camera);

    return (jlong) camera;
}


jstring Java_de_stuermerbenjamin_Camera_getLibraryVersion(Camera camera, JNIEnv *env, jobject obj) {
    (void) env;
    (void) obj;

    return (jstring) gp_library_version(GP_VERSION_VERBOSE);
}

jlong Java_de_stuermerbenjamin_Camera_capture(Camera camera, JNIEnv *env, jobject obj) {
    GPContext *context = gp_context_new();
    CameraFilePath camera_file_path;

    /* NOP: This gets overridden in the library to /capt0000.jpg */
    strcpy(camera_file_path.folder, "/");
    strcpy(camera_file_path.name, "foo.jpg");

    long retval = gp_camera_capture(&camera, GP_CAPTURE_IMAGE, &camera_file_path, context);
    printf("  Retval: %li\n", retval);

    printf("Pathname on the camera: %s/%s\n", camera_file_path.folder, camera_file_path.name);

    return (jlong) retval;
}
