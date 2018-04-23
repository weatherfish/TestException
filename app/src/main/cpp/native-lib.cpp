#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring

JNICALL
Java_com_felix_test_exp_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

int i;
void doSth(){
    printf("hello   %d", i++);
    doSth();
    printf("hello end  %d", i++);
}


extern "C" JNIEXPORT void
JNICALL
Java_com_felix_test_exp_VMErrorActivity_testStackOVerError(
        JNIEnv *env,
        jobject /* this */) {
    doSth();
}