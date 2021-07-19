package com.example.app1;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceHelper {
    private static final String SHARED_PREFERENCE_KEY = "com.xyz.sharedpreferences";
    private static SharedPreferences sharedPreferences;

    public static SharedPreferences getInstance(Context context) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_KEY, Context.MODE_PRIVATE);
        }
        return sharedPreferences;
    }
    public static void writeStringToPreference(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getIntSharedPreferenceKey(String key) {
        return sharedPreferences.getString(key, " ");
    }
}
