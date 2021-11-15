package com.example.przeliczaczjednostek;

import android.app.Application;
import android.content.Context;
import com.squareup.otto.Bus;

public class App extends Application {

    private int activeNav;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base, "pl"));
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
