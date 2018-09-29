package com.github.caliburn.log;

import android.util.Log;

public class Info implements ILog{

    @Override
    public void info(String tag, String msg) {
        Log.i(tag,msg);
    }

}
