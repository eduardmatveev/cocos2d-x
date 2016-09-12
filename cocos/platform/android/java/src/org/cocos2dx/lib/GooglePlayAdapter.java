package org.cocos2dx.lib;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class GooglePlayAdapter {
    
    public static final int RC_SIGN_IN = 9001;
    
    private static Activity m_context;
    private static GoogleApiClient m_googleApiClient;
    private static GoogleSignInOptions m_gso;
    
    public static void init(Activity context, String server_client_id)
    {
    	m_context = context;
    	
        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        m_gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        		.requestId()
                .requestIdToken(server_client_id)
                .build();
    }
    
    public static void signIn()
    {
    	GoogleApiClient client = new GoogleApiClient.Builder(m_context)
                .addApi(Auth.GOOGLE_SIGN_IN_API, m_gso)
                .build();
        
        OptionalPendingResult<GoogleSignInResult> pendingResult =
        	    Auth.GoogleSignInApi.silentSignIn(client);
        if (pendingResult.isDone()) {
            // There's immediate result available.
            handleSignInResult(pendingResult.get());
        } else {
            pendingResult.cancel();
            Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(client);
            m_context.startActivityForResult(signInIntent, RC_SIGN_IN);
        }
    }
    
    private static class SignOutConnectionListener implements GoogleApiClient.ConnectionCallbacks
    {
		@Override
		public void onConnected(Bundle arg0) {
			Log.d("Imperial_GooglePlayAdapter", "connected");
			
			Auth.GoogleSignInApi.signOut(m_googleApiClient);
			m_googleApiClient = null;
			
			Log.d("Imperial_GooglePlayAdapter", "signed out");
		}

		@Override
		public void onConnectionSuspended(int arg0) {
		}
    }
    
    public static void signOut()
    {
    	GoogleApiClient.ConnectionCallbacks listener = new SignOutConnectionListener();
    	
    	m_googleApiClient = new GoogleApiClient.Builder(m_context)
                .addApi(Auth.GOOGLE_SIGN_IN_API, m_gso)
                .addConnectionCallbacks(listener)
                .build();
    	
    	m_googleApiClient.connect();
    }

    public static void handleSignInResult(GoogleSignInResult result)
    {
    	String id = "";
    	String token = "";
    	if(result != null)
    	{
    		GoogleSignInAccount account = result.getSignInAccount();
    		if(account != null)
    		{
		    	id = account.getId();
		    	token = account.getIdToken();
		    	
		    	Log.d("Imperial_GooglePlayAdapter", "id '" + id + "'");
		    	Log.d("Imperial_GooglePlayAdapter", "token '" + token + "'");
    		}
    		else
    		{
    			/// \todo handle an error
    			Log.d("Imperial_GooglePlayAdapter", "account is a null");
    		}
    	}
    	
    	handleSignInResultNative(id, token);
    }
    
    public static boolean checkExistedGoogleAccounts()
    {
		AccountManager am = AccountManager.get(m_context);
		Account[] accounts = am.getAccountsByType("com.google");
		Log.d("GooglePlayAdapter: Google accounts", accounts.length + "");
		return accounts.length > 0;
    }

    public static native void handleSignInResultNative(String id, String token);  
}