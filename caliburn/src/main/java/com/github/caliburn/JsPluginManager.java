package com.github.caliburn;

import android.content.Context;
import android.util.Log;

import com.github.caliburn.jsbridge.BridgeHandler;
import com.github.caliburn.jsbridge.BridgeWebView;
import com.github.caliburn.log.ILog;
import com.github.caliburn.log.Info;
import com.github.caliburn.util.StringUtil;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author chentong
 * 12-28
 */
public class JsPluginManager {
    private String TAG = getClass().getSimpleName();

    private LinkedHashMap<String, Class<? extends BridgePlugin>> pluginClassMap = new LinkedHashMap<>();
    private List<String> handlerNameList = new ArrayList<>();

    private static JsPluginManager jsPluginManager;
    private BridgeWebView webView;
    private Context context;
    private static ILog log = new Info();

    private JsPluginManager() {
        super();
    }

    public static JsPluginManager getInstance() {

        if (jsPluginManager == null) {
            synchronized (JsPluginManager.class) {
                if (jsPluginManager == null) {
                    jsPluginManager = new JsPluginManager();
                    return jsPluginManager;
                }
            }
        }

        return jsPluginManager;
    }

    public void initWebView(Context context, BridgeWebView webView) {
        this.context = context;
        this.webView = webView;
    }

    public void loadPluginClass(Class<? extends BridgePlugin> pluginClass) {
        pluginClassMap.put(pluginClass.getSimpleName(), pluginClass);
    }

    public Class<? extends BridgePlugin> getPluginClass(String serverName) {
        Class clazz = pluginClassMap.get(serverName);
        return clazz;
    }

    public void loadHandlerName(String handlerNamme) {
        handlerNameList.add(handlerNamme);
    }

    public void loadHandlerList(List<String> list) {
        handlerNameList.addAll(list);
    }

    /**
     * TODO 修改 globalPlugin 采用系统调用defaultHandler  20170926 代办事项
     */
    public void startup() {
        Log.i("chentong", handlerNameList.toString());
        for (String handlerName : handlerNameList) {
            JsPluginEntity entity = new JsPluginEntity();
            BridgePlugin plugin = null;
            if (StringUtil.contains(handlerName, "$")) {
                String[] spitName = handlerName.split("\\$");
                String serverName = StringUtil.trim(spitName[0]);
                String actionName = StringUtil.trim(spitName[1]);
                entity.setHandlerName(handlerName);
                entity.setServerName(serverName);
                entity.setActionName(actionName);
                entity.setWebView(webView);
                entity.setContext(context);
                try {
                    plugin = getPluginClass(serverName).newInstance();
                    plugin.setEntity(entity);
                    plugin.init(entity);
                    registerHandler(handlerName, plugin);
                } catch (Exception e) {

                }

            } else {
                String actionName = handlerName;
                entity.setActionName(actionName);
                entity.setWebView(webView);
                entity.setContext(context);
                plugin = (BridgePlugin) webView.getDefaultHandler();
                plugin.setEntity(entity);
                plugin.init(entity);
                registerHandler(handlerName, plugin);
            }

        }

    }

    /**
     * 关闭
     */
    public void shutdown(){
        webView.unregister();
        pluginClassMap.clear();
        handlerNameList.clear();
    }


    //封装jsbridge 核心调用
    private void registerHandler(String handlerName, BridgeHandler handler) {
        webView.registerHandler(handlerName, handler);
    }

    /**
     * 日志策略
     * @param newLog
     */
    public static void setLog(ILog newLog){
        log = newLog;
    }

    public static ILog getLog(){
        return log;
    }

    /**
     * 日志打印
     * @param tag
     * @param msg
     */
    private void log(String tag, String msg) {
        if (log != null) {
            log.info(tag, msg);
        }
    }
}
