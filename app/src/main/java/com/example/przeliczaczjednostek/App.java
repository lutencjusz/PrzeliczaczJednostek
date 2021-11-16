package com.example.przeliczaczjednostek;

import android.app.Application;
import android.content.Context;

public class App extends Application {

    private int activeNav;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base, LocaleHelper.getLanguage(base)));
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public int getActiveNav() {
        return activeNav;
    }

    public void setActiveNav(int activeNav) {
        this.activeNav = activeNav;
    }
}
