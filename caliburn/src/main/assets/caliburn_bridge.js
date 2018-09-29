(function() {

    //js调用java
    if (!window.jsbridge) {
        window.jsbridge = {
            exec: function(successCallback, failCallback, service, action, actionArgs) {
                var handlerName = (service ? (service + '$') : '') + action;
                WebViewJavascriptBridge.callHandler(handlerName, actionArgs, function(msg) {
                    console.log(msg);
                    var response = JSON.parse(msg);
                    if (response && response.error) {
                        failCallback && failCallback(response.error);
                    } else {
                        successCallback && successCallback(response && response.data ? JSON.parse(response.data) : null);
                    }
                });
            }
        };
    }

    //java调用js

})();
