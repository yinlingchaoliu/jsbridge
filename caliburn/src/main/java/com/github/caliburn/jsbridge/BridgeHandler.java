package com.github.caliburn.jsbridge;

public interface BridgeHandler {
	
	void handler(String data, CallBackFunction function);

	void destory();
}
