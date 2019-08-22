package com.nguyennhat.android_sharedpreferencebai9;

import android.app.Application;

import com.google.gson.Gson;

public class App extends Application {

    private static App sApp;
    private Gson mGson;

    public static App getApplication() {
        return sApp;
    }

    public Gson getGson() {
        return mGson;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
        mGson = new Gson();
    }




}
