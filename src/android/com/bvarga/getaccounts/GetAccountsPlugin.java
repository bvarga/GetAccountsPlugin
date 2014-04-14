package com.bvarga.getaccounts;

import org.json.JSONArray;
import org.json.JSONException;

import android.accounts.Account;
import android.accounts.AccountManager;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;

public class GetAccountsPlugin extends CordovaPlugin {

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    try {
      if ("get".equals(action)){
        AccountManager am = AccountManager.get(cordova.getActivity());
        
        Account[] accounts;
        accounts = am.getAccounts();
        
        JSONArray res = new JSONArray();
        for (int i = 0; i < accounts.length; i++) {
          Account a = accounts[i];
          res.put(a.name);
        }
        callbackContext.success(res);
        return true;

      }
      return false;
      
    } catch (Exception e) {
      callbackContext.error(e.getMessage());
    }
    return true;
  }
}
