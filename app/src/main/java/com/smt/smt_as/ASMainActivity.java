package com.smt.smt_as;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
//import android.widget.Toast;
//import androidx.annotation.NonNull;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.iid.FirebaseInstanceId;
//import com.google.firebase.iid.InstanceidResult;

public class ASMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asmain);


//        Intent intent = getIntent();
//        if (intent != null) {//푸시알림을 선택해서 실행한것이 아닌경우 예외처리
//            String notificationData = intent.getStringExtra("test");
//            if (notificationData != null)
//                Log.d("FCM_TEST", notificationData);
//        }

    }
}
//        FirebaseInstanceId.getInstance().getInstanceId()
//                .addOnCompleteListener(new OnCompleteListener<InstanceidResult>(){
//                    @Override
//                    public void onComplete(@NonNull Task<InstanceidResult> task) {
//                        if(!task.isSuccessful()){
//                            Log.w("FCM Log","getInstanceId failed",task.getException());
//                            return;
//                        }
//                        String token = task.getResult().getToken();
//                        Log.d("FCM Log","FCM 토큰" + token);
//                        Toast.makeText(ASMainActivity.this, token,Toast.LENGTH_SHORT).show();
//                    }
//                });
//    Call<data_model> call;
//    TextView textView;
//    // 푸시알림
//    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";
//    private NotificationManager mNotificationManager;
//    private static final int NOTIFICATION_ID = 0;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_asmain);
//
//        textView =findViewById(R.id.textview);
//
//        call = retrofit_client.getApiService().test_api_get("name");
//        call.enqueue(new Callback<data_model>(){
//            //콜백 받는 부분
//            @Override
//            public void onResponse(Call<data_model> call, Response<data_model> response) {
//                data_model result = response.body();
//                String str;
//                str= result.getName();
////                        +"\n"+ result.getID() +"\n"+
////                        result.getTitle()+"\n"+
////                        result.getBody();
//                textView.setText(str);
//            }
//
//            @Override
//            public void onFailure(Call<data_model> call, Throwable t) {
//
//            }
//        });
//////////////////////////////////////////////////////////////////////////////////////////
//        Button addpushalertbutton = (Button) findViewById(R.id.alertTitle);
//        addpushalertbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                sendNotification();
//            }
//        });
//        createNotificationChannel();
//    }
//
//    public void createNotificationChannel() //푸시 알림 채널 필수
//    {
//        Log.d("", "알림 채널");
//        mNotificationManager = (NotificationManager)
//                getSystemService(NOTIFICATION_SERVICE);
//
//        if(android.os.Build.VERSION.SDK_INT
//                >= android.os.Build.VERSION_CODES.O){
//
//            NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL_ID
//                    ,"AS PUSH ALERT",mNotificationManager.IMPORTANCE_HIGH);
//
//            notificationChannel.enableLights(true);
//            notificationChannel.enableVibration(true);
//            notificationChannel.setDescription("Notification from AS");
//
//            mNotificationManager.createNotificationChannel(notificationChannel);
//        }
//
//    }
//
//
//    private NotificationCompat.Builder getNotificationBuilder() {
//        Intent notificationIntent = new Intent(this, ASWebViewActivity.class);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this,NOTIFICATION_ID,notificationIntent,PendingIntent.FLAG_UPDATE_CURRENT);
//        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(this, PRIMARY_CHANNEL_ID)
//                .setSmallIcon(android.R.drawable.btn_star_big_on) // 아이콘 필수 콘텐츠임
//                .setAutoCancel(true) // 알림 클릭시 사라짐 false 할시, 알림 눌러도 안 사라짐
//                .setContentIntent(pendingIntent) //링크로 들어감
//                .setContentTitle("AS 관련 문의가 들어왔습니다.")
//                .setContentText("은영님 한대만 때려 주시길 바랍니다.")
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT) // 맨위 헤더로이동
//                .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE); // 알림시 진동,소리
//                Log.d("", "알림 빌더");
//        return notifyBuilder;
//    }
//
//
//    public void sendNotification(){ //푸시 알림 메서드
//        NotificationCompat.Builder notifyBuilder = getNotificationBuilder();
//        mNotificationManager.notify(NOTIFICATION_ID,notifyBuilder.build());
//        Log.d("", "알림 메서드 ");
//    }
//////////////////////////////////////////////////////////////////////////////////////////
