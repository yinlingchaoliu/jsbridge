package com.caliburn.app;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;

import com.caliburn.app.plugin.GlobalPlugin;
import com.caliburn.app.plugin.UIManager;
import com.github.caliburn.JsPluginManager;
import com.github.caliburn.jsbridge.BridgeWebView;
import com.github.caliburn.jsbridge.DefaultHandler;

/**
 * @author chentong
 * @date 2017/12/18
 */
public class DemoActivity extends Activity {

    private BridgeWebView birdgeWebview;
    private JsPluginManager jsPluginManager ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_jsbridge_webview);
        birdgeWebview = (BridgeWebView)findViewById(R.id.birdgeWebview);
        initWebView(birdgeWebview);
    }

    private void initWebView(BridgeWebView webView) {
        webView.loadUrl("file:///android_asset/demo.html");

        WebSettings settings = webView.getSettings();
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);

        jsPluginManager = JsPluginManager.getInstance();
        jsPluginManager.initWebView(this, webView);

        /**
         * 必须设置公共方法 或者默认方法
         */
//        webView.setDefaultHandler(new DefaultHandler());
        webView.setDefaultHandler(new GlobalPlugin());

        /**
         * 设置特殊方法
         */
//加载约束限制
        jsPluginManager.loadHandlerName("goBack");
        /*设置UIManger*/
        jsPluginManager.loadHandlerName("UIManager$showToast");

//加载插件
        jsPluginManager.loadPluginClass(UIManager.class);
        jsPluginManager.startup();
    }

    @Override
    protected void onDestroy() {
        jsPluginManager.shutdown();
        super.onDestroy();
    }

}
