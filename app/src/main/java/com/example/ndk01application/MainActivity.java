package com.example.ndk01application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static String TAG=MainActivity.class.getSimpleName();
    //member reference type 'JNIEnv' (aka '_JNIEnv') is not a pointer; did you mean to use '.'?
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Java_com_example_ndk01application_Codec_hexEncode
                                                //Java_com_example_ndk01application_Codec_hexDecode

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
//        tv.setText(getAppKey());
        tv.setText(stringFromJNI());

        String s = Codec.hexEncode(new byte[]{0x3c, 0x7c});
        Log.d(TAG, "onCreate: s ==> " + s);
        byte[] bytes = Codec.hexDecode(s);

        for (byte aByte : bytes) {
            Log.d(TAG, "onCreate: byte ==> " + String.format(Locale.CANADA, "%x",aByte ));
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

//    public native String getAppKey();


    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("test-lib");
    }
}
