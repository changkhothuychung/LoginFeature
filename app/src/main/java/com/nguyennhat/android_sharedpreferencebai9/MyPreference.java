package com.nguyennhat.android_sharedpreferencebai9;

import android.content.Context;
import android.content.SharedPreferences;

public class MyPreference {

    private static final String PREFS_NAME = "myPreference";
    private SharedPreferences mSharedPreferences;
    private static MyPreference myPreference;

    private MyPreference() {
        mSharedPreferences = App.getApplication().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public static MyPreference getInstance() {
        if (myPreference == null) {
            myPreference = new MyPreference();
        }
        return myPreference;
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key, Class<T> anonymousClass) {
        if (anonymousClass == String.class) {
            return (T) mSharedPreferences.getString(key, "");
        } else if (anonymousClass == Boolean.class) {
            return (T) Boolean.valueOf(mSharedPreferences.getBoolean(key, false));
        } else if (anonymousClass == Float.class) {
            return (T) Float.valueOf(mSharedPreferences.getFloat(key, 0));
        } else if (anonymousClass == Integer.class) {
            return (T) Integer.valueOf(mSharedPreferences.getInt(key, 0));
        } else if (anonymousClass == Long.class) {
            return (T) Long.valueOf(mSharedPreferences.getLong(key, 0));
        } else {
            return (T) App.getApplication()
                    .getGson()
                    .fromJson(mSharedPreferences.getString(key, ""), anonymousClass);
        }
    }

    public <T> void put(String key, T data) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        if (data instanceof String) {
            editor.putString(key, (String) data);
        } else if (data instanceof Boolean) {
            editor.putBoolean(key, (Boolean) data);
        } else if (data instanceof Float) {
            editor.putFloat(key, (Float) data);
        } else if (data instanceof Integer) {
            editor.putInt(key, (Integer) data);
        } else if (data instanceof Long) {
            editor.putLong(key, (Long) data);
        } else {
            editor.putString(key, App.getApplication().getGson().toJson(data));
        }
        editor.apply();
    }

}
