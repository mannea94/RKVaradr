package com.hcvardar.manne.rkvaradr.Model;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.hcvardar.manne.rkvaradr.CheckConnection;

/**
 * Created by manne on 07.7.2019.
 */

public class InternetConnection {
    public Context activity;

    public void checkInternet(Runnable callback) {
        if (CheckConnection.CheckInternetConnectivity(activity, true, callback))
            callback.run();
    }

    public void checkInternet(Runnable callback, boolean showConnectionDialog) {
        if (CheckConnection.CheckInternetConnectivity(activity, showConnectionDialog, callback))
            callback.run();
        else {
            Toast.makeText(activity, "Connection failed, please check your connection settings", Toast.LENGTH_SHORT).show();
        }
    }

    public void checkInternet(Runnable callback, boolean showConnectionDialog, String message) {
        if (CheckConnection.CheckInternetConnectivity(activity, showConnectionDialog, callback))
            callback.run();
        else {
            if (showConnectionDialog)
                Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
            else
                Log.d("Connection failed", "" + message);
        }
    }
}
