package org.cocos2dx.lib;

import android.content.Context;

import com.appsflyer.AppsFlyerLib;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import org.json.JSONObject;
import org.json.JSONException;

public class AppsFlyerAdapter {
	
	private static Context m_context;
	
	public static void init(Context context)
	{
		m_context = context;
	}
	
	public static void trackEvent(String eventName, String jsonString)
	{
		try
		{
		    JSONObject jsonObject = new JSONObject(jsonString);
		    Iterator keys = jsonObject.keys();

		    Map<String, Object> map = new HashMap<String, Object>();

		    while (keys.hasNext()) {
		        String key = (String) keys.next();
		        map.put(key, jsonObject.getString(key));
		    }

		    AppsFlyerLib.getInstance().trackEvent(m_context, eventName, map);

		} catch (JSONException e) {
		    e.printStackTrace();
		}
	}

	public static void setCustomerUserId(String id)
	{
		AppsFlyerLib.getInstance().setCustomerUserId(id);
	}
}