//
// Created by Administrator on 2016/11/21.
//

#include "com_ndkdemo_NativeHelper.h"

#include <jni.h>
#include <string>

extern "C"
jstring
Java_com_example_ndk01application_MainActivity_getAppKey(JNIEnv* env,
                                         jobject /* this */) {
    std::string hello = "Hello World!";
    return env->NewStringUTF(hello.c_str());
}