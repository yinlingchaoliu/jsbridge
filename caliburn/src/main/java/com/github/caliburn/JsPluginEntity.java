package com.github.caliburn;

import android.content.Context;

import com.github.caliburn.jsbridge.BridgeWebView;
import com.github.caliburn.jsbridge.CallBackFunction;
import com.github.caliburn.util.JsonParser;

/**
 * @author chentong
 *         2017-12-18
 */
public class JsPluginEntity<T> {

    private String handlerName;
    private String serverName;
    private String actionName;
    private String requestData;
    private BridgeWebView webView;
    private Context context;


    private CallBackFunction function;

    public void onSuccess(String msg) {
        if (function != null) {
            function.onCallBack(msg);
        }
    }

    public void onSuccess(JsResponse response) {
        if (function != null) {
            String json = JsonParser.bean2Json(response);
            function.onCallBack(json);
        }
    }

    public void onError(String msg) {
        if (function != null) {
            function.onCallBack(msg);
        }
    }

    public void onError(JsResponse response) {
        if (function != null) {
            String json = JsonParser.bean2Json(response);
            function.onCallBack(json);
        }
    }

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getRequestData() {
        return requestData;
    }

    public void setRequestData(String requestData) {
        this.requestData = requestData;
    }

    public CallBackFunction getFunction() {
        return function;
    }

    public void setFunction(CallBackFunction function) {
        this.function = function;
    }

    public BridgeWebView getWebView() {
        return webView;
    }

    public void setWebView(BridgeWebView webView) {
        this.webView = webView;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
