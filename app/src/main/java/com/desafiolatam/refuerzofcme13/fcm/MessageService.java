package com.desafiolatam.refuerzofcme13.fcm;

import android.util.Log;

import com.desafiolatam.refuerzofcme13.notification.NewMessageNotification;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MessageService extends FirebaseMessagingService {

    @Override
    public void onNewToken(String token) {
        super.onNewToken(token);
        Log.d("TOKEN", token);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        String title = remoteMessage.getNotification().getTitle();
        String body = remoteMessage.getNotification().getBody();

        Log.e("TITLE", String.valueOf(title));
        Log.e("BODY", String.valueOf(body));

        String data = remoteMessage.getData().get("data");
        Log.e("DATA", String.valueOf(data));
        String key = remoteMessage.getData().get("key");
        Log.e("KEY",String.valueOf(key));


        if (remoteMessage.getData().size() > 0) {
            NewMessageNotification.notify(this, data, key);
        } else {
            NewMessageNotification.notify(this, title, body);
        } 

    }


}

