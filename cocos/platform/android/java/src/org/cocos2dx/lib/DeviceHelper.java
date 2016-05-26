package org.cocos2dx.lib;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings.Secure;
import android.util.Log;

public class DeviceHelper {
    
	private static String TAG = "DeviceHelper";
	
    private static Activity m_context;
        
    public static void init(Activity context)
    {
    	m_context = context;
    }
    
    public static void scheduleRestart()
    {
    	try {
            //check if the context is given
            if (m_context != null) {
                //fetch the packagemanager so we can get the default launch activity 
                // (you can replace this intent with any other activity if you want
                PackageManager pm = m_context.getPackageManager();
                //check if we got the PackageManager
                if (pm != null) {
                    //create the intent with the default start activity for your application
                    Intent mStartActivity = pm.getLaunchIntentForPackage(
                    		m_context.getPackageName()
                    );
                    if (mStartActivity != null) {
                        mStartActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        //create a pending intent so the application is restarted after System.exit(0) was called. 
                        // We use an AlarmManager to call this intent in 500ms
                        int mPendingIntentId = 223344;
                        PendingIntent mPendingIntent = PendingIntent
                                .getActivity(m_context, mPendingIntentId, mStartActivity,
                                        PendingIntent.FLAG_CANCEL_CURRENT);
                        AlarmManager mgr = (AlarmManager) m_context.getSystemService(Context.ALARM_SERVICE);
                        mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 500, mPendingIntent);
                        //kill the application
                        //System.exit(0);
                    } else {
                        Log.e(TAG, "Was not able to restart application, mStartActivity null");
                    }
                } else {
                    Log.e(TAG, "Was not able to restart application, PM null");
                }
            } else {
                Log.e(TAG, "Was not able to restart application, Context null");
            }
        } catch (Exception ex) {
            Log.e(TAG, "Was not able to restart application");
        }
    }

    public static String getId()
    {
    	return Secure.getString(m_context.getContentResolver(), Secure.ANDROID_ID);
    }

    public static String getModel()
    {
    	return Build.MODEL;
    }

    public static String getSystemVersion()
    {
    	return "android_" + Build.VERSION.RELEASE;
    }
}