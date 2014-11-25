package com.cordava.plugins.toast;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

public class toast extends CordovaPlugin {
	
	public void toastshow(String mensaje){
		Context context = cordova.getActivity().getApplicationContext();
		Toast m = Toast.makeText(context, mensaje, Toast.LENGTH_LONG);
		m.setGravity(Gravity.CENTER, 0, 0);
		m.show();
	}
	@Override
	public boolean execute(String action,JSONArray args,CallbackContext callbackContext){
		try {
			JSONObject jsonObj = args.getJSONObject(0);
			toastshow(jsonObj.getString("mensaje"));
			callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK));
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("PhoneGapLog", "Notificacion Plugin: Error: " + PluginResult.Status.JSON_EXCEPTION);
			e.printStackTrace();
			callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.JSON_EXCEPTION));
			return false;
		}
		return true;
	}
}
