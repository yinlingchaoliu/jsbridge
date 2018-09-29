package com.caliburn.app.plugin;

import android.content.Context;
import android.text.TextUtils;

import android.view.Gravity;
import android.widget.Toast;


import com.github.caliburn.BridgePlugin;
import com.github.caliburn.JsPluginEntity;
import com.github.caliburn.util.StringUtil;

public class UIManager extends BridgePlugin {

    @Override
    public void init(JsPluginEntity jsPluginEntity) {

    }

    @Override
    public void exec(JsPluginEntity entity) {
        this.jsPluginEntity = entity;
        if (StringUtil.equals(entity.getActionName(), "showToast")) {
            showToast(entity.getContext(),"js调用原生");
        }
    }

    private void showToast(Context context, String msg) {
        if (!TextUtils.isEmpty(msg)) {
            Toast toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }

    @Override
    public void destory() {

    }

}
