package com.huawei.huaweitoolkitexample;

import android.app.Application;
import org.xms.g.utils.GlobalEnvSetting;
import org.xms.adapter.utils.XLoader;

public class MyApp extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		GlobalEnvSetting.init(this, null);
		XLoader.init(this);
	}
}
