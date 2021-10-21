package com.fabian.fyi;

import android.util.Log;

import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;

public class HmsPushService extends HmsMessageService {
    @Override
    public void onNewToken(String token) {
        Log.i("push","received refresh token:" + token);
        //...
    }
    private void refreshedTokenToServer(String token) {
        Log.i("push","sending token to server. token:" + token);
        //...
    }

    /**
     * 接收透传消息
     * @param message RemoteMessage
     */
    @Override
    public void onMessageReceived(RemoteMessage message) {
        Log.i("push","onMessageReceived is called");
        if (message == null) {
            Log.w("push","Received message entity is null!");
        }
        //...
    }
    private void startJob(RemoteMessage message){
        Log.i("push","Processing now.");
        //...
    }


    @Override
    public void onTokenError(Exception e) {
        super.onTokenError(e);
    }
}
