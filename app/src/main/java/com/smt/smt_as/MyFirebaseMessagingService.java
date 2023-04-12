package com.smt.smt_as;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
//import android.media.RingtoneManager;
//import android.net.Uri;
import android.os.Build;
import android.util.Log;

//import androidx.annotation.NonNull;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

//import com.google.firebase.messaging.FirebaseMessaging;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    String token = FirebaseMessaging.getInstance().getToken().getResult();

    @Override
    public void onNewToken(@NonNull String token) {
       Log.w("FCM Log"," token: " + token);
    }

//    @Override
//    public void onNewToken(String token) {
//        super.onNewToken(token);
//        Log.d("디바이스 토큰", token);
//    }
///////////////////////////////////////////////////////////////////////////////////////////////////
//    @Override
//    public void onMessageReceived(RemoteMessage remoteMessage) {
//        super.onMessageReceived(remoteMessage);
//
//        String title = remoteMessage.getData().get("title");//firebase에서 보낸 메세지의 title
//        String message = remoteMessage.getData().get("message");//firebase에서 보낸 메세지의 내용
//        String test = remoteMessage.getData().get("test");
//
//        Intent intent = new Intent(this, ASWebViewActivity.class);
//        intent.putExtra("test", test);
//
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//
//            String channel = "AS_Channel";
//            String channel_nm = "SMT_AS";
//
//            NotificationManager notichannel = (android.app.NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//            NotificationChannel channelMessage = new NotificationChannel(channel, channel_nm,
//                    android.app.NotificationManager.IMPORTANCE_DEFAULT);
//            channelMessage.setDescription("채널에 대한 설명.");
//            channelMessage.enableLights(true);
//            channelMessage.enableVibration(true);
//            channelMessage.setShowBadge(false);
//            channelMessage.setVibrationPattern(new long[]{1000, 1000});
//            notichannel.createNotificationChannel(channelMessage);
//
//            //푸시알림을 Builder를 이용하여 만듭니다.
//            NotificationCompat.Builder notificationBuilder =
//                    new NotificationCompat.Builder(this, channel)
//                            .setSmallIcon(R.drawable.ic_launcher_background)
//                            .setContentTitle(title)//푸시알림의 제목
//                            .setContentText(message)//푸시알림의 내용
//                            .setChannelId(channel)
//                            .setAutoCancel(true)//선택시 자동으로 삭제되도록 설정.
//                            .setContentIntent(pendingIntent)//알림을 눌렀을때 실행할 인텐트 설정.
//                            .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE);
//
//            NotificationManager notificationManager =
//                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//
//            notificationManager.notify(9999, notificationBuilder.build());
//
//        } else {
//            NotificationCompat.Builder notificationBuilder =
//                    new NotificationCompat.Builder(this, "")
//                            .setSmallIcon(R.drawable.ic_launcher_background)
//                            .setContentTitle(title)
//                            .setContentText(message)
//                            .setAutoCancel(true)
//                            .setContentIntent(pendingIntent)
//                            .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE);
//
//            NotificationManager notificationManager =
//                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//
//            notificationManager.notify(9999, notificationBuilder.build());
//
//        }
//    }
///////////////////////////////////////////////////////////////////////////////////////////////////
}

//    String token = FirebaseMessaging.getInstance().getToken().getResult();

//    @Override
//    public void onNewToken(@NonNull String token) {
//        Log.d("FCM Log","Refreshed token: " + token);
//    }

//    @Override
//    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
//        if(remoteMessage.getNotification() != null){
//            Log.d("FCM Log","알림 메시지: " + remoteMessage.getNotification().getBody());
//            String messageBody = remoteMessage.getNotification().getBody();
//            String messageTitle = remoteMessage.getNotification().getTitle();
//            Intent intent = new Intent(this, MainActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
//            String channelId = "Channel ID";
//            Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//            NotificationCompat.Builder notificationBuilder =
//                    new NotificationCompat.Builder(this, channelId)
//                            .setSmallIcon(android.R.drawable.btn_star_big_on) // 아이콘 필수 콘텐츠임
//                            .setAutoCancel(true) // 알림 클릭시 사라짐 false 할시, 알림 눌러도 안 사라짐
//                            .setContentIntent(pendingIntent) //링크로 들어감
//                            .setContentTitle(messageTitle)
//                            .setContentText(messageBody)
//                            .setPriority(NotificationCompat.PRIORITY_DEFAULT) // 맨위 헤더로이동
//                            .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE); // 알림시 진동,소리
//            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//            //Build.VERSION_CODES.O
//            if(Build.VERSION.SDK_INT >= 26){
//                String channelName = "Channel Name";
//                NotificationChannel channel = new NotificationChannel(channelId,channelName,NotificationManager.IMPORTANCE_HIGH);
//                notificationManager.createNotificationChannel(channel);
//            }
//            notificationManager.notify(0,notificationBuilder.build());
//        }
//    }
