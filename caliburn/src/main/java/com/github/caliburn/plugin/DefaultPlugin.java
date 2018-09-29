package com.github.caliburn.plugin;

import android.util.Log;

import com.github.caliburn.BridgePlugin;
import com.github.caliburn.JsPluginEntity;


/**
 * @author chentong
 */
public class DefaultPlugin extends BridgePlugin {

    @Override
    public void init(JsPluginEntity entity) {
    }

    @Override
    public void exec(JsPluginEntity entity) {
        Log.i("JsPluginManager","DefaultPlugin exec");
    }

    @Override
    public void destory() {

    }

}
