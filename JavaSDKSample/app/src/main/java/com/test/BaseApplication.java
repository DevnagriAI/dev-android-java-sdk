package com.test;

import android.app.Application;
import android.util.Log;

import com.devnagritranslationsdk.DevNagriTranslationSdk;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class BaseApplication extends Application {

    static String TAG = "baseApplicationTAG";

    static DevNagriTranslationSdk devNagriTranslationSdk;

//    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onCreate() {
        super.onCreate();

        List<String> strings = Arrays.stream(R.string.class.getFields()).map(Field::getName).collect(toList());

        List<String> arrays = Arrays.stream(R.array.class.getFields()).map(Field::getName).collect(toList());
        //List<String> collect = Arrays.stream(R.plurals.class.getFields()).map(Field::getName).collect(toList());

        String API_KEY ="devnagri_9b3a4902cd4111ecbb6002bf838402f8";
        int sync_Time = 10;
        try {
            devNagriTranslationSdk = new DevNagriTranslationSdk();
            devNagriTranslationSdk.init(getApplicationContext(),API_KEY,sync_Time,strings,arrays,null);
            Log.d(TAG, "onCreate: BaseApplication devNagriTranslationSdk::: "+devNagriTranslationSdk);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
