package com.example.ndk01application;

/**
 * @auther jjr
 * @date 创建时间： 2016/11/21 18:13
 * @Description
 */

public class Codec {
    static {
        //一定不要忘记调用!!!!
        System.loadLibrary("helper-lib");
    }
    public static native String hexEncode(byte[] data);
    public static native byte[] hexDecode(String data);
}
