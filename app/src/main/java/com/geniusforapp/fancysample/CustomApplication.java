package com.geniusforapp.fancysample;

import android.app.Application;

/**
 * Created by Marcin Wróblewski (wróblewski.info) on 23.09.2017.
 */

public class CustomApplication extends Application {

    private boolean wasDialogOpened;

    public boolean wasDialogOpened() {
        return wasDialogOpened;
    }

    public void setDialogOpened(boolean wasDialogOpened) {
        this.wasDialogOpened = wasDialogOpened;
    }
}
