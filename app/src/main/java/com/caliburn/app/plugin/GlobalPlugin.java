package com.caliburn.app.plugin;

import android.app.Activity;

import com.github.caliburn.BridgePlugin;
import com.github.caliburn.JsPluginEntity;
import com.github.caliburn.util.StringUtil;


/**
 * @author chentong
 */
public class GlobalPlugin extends BridgePlugin {

    @Override
    public void init(JsPluginEntity entity) {
    }

    @Override
    public void exec(JsPluginEntity entity) {
        this.jsPluginEntity = entity;
        if (StringUtil.equals(entity.getActionName(), "goBack")) {
            goBack(entity);
        }
    }

    void goBack(JsPluginEntity entity){
        Activity context = (Activity)entity.getContext();
        context.finish();
    }

    @Override
    public void destory() {

    }

}