package org.cocos2dx.lib;

import com.yandex.metrica.YandexMetrica;

public class YandexMetrikaAdapter {
	public static void reportEvent(String eventName)
	{
		YandexMetrica.reportEvent(eventName);
	}

	public static void reportEvent(String eventName, String eventParams)
	{
		YandexMetrica.reportEvent(eventName, eventParams);
	}
}