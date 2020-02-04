#ifndef __CAMERA_H
#define __CAMERA_H
#include <gphoto2/gphoto2-camera.h>

#ifdef __cplusplus
extern "C" {
#endif

extern int get_config_value_string (Camera *, const char *, char **, GPContext *);
extern int set_config_value_string (Camera *, const char *, const char *, GPContext *);


#ifdef __cplusplus
};
#endif

#endif //__CAMERA_H
