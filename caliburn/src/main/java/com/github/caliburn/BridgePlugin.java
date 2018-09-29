package com.github.caliburn;

import com.github.caliburn.jsbridge.BridgeHandler;
import com.github.caliburn.jsbridge.CallBackFunction;
import com.github.caliburn.log.ILog;

public abstract class BridgePlugin implements BridgeHandler {

    protected JsPluginEntity jsPluginEntity;
    protected String TAG = getClass().getSimpleName();

    @Override
    public void handler(String data, CallBackFunction function) {

        jsPluginEntity.setRequestData(data);
        jsPluginEntity.setFunction(function);
        String actionName = jsPluginEntity.getActionName();

        try {
            exec(jsPluginEntity);
        } catch (Exception e) {

        }

    }

    public JsPluginEntity getEntity() {
        return jsPluginEntity;
    }

    public void setEntity(JsPluginEntity entity) {
        this.jsPluginEntity = entity;
    }

    /* 初始化 */
    public abstract void init(JsPluginEntity entity);

    public abstract void exec(JsPluginEntity entity);

    /**
     * 日志打印
     *
     * @param tag
     * @param msg
     */
    public void log(String tag, String msg) {
        ILog log = JsPluginManager.getLog();
        if (log != null) {
            log.info(tag, msg);
        }
    }

    /**
     * 打印日志
     * @param msg
     */
    public void log(String msg) {
        log(TAG, msg);
    }

}
