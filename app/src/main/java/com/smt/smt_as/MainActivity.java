package com.smt.smt_as;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.smt.smt_as.retrofit.API_AS;
import com.smt.smt_as.retrofit.API_BASE;
import com.smt.smt_as.retrofit.API_MODEL_UpdateToken;
import com.smt.smt_as.util.PhoneUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private String TAG = MainActivity.class.getSimpleName();
    private WebView webView = null;
    String token = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getToken(); //토큰값
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_SMS}, 0);

//        Button loginbutton = (Button) findViewById(R.id.button);
//        loginbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "TOKEN : " + token, Toast.LENGTH_SHORT).show();
//            }
//        });

        webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setSupportMultipleWindows(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.loadUrl("http://211.117.60.119/ars/as");

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // requestCode는 권한 요청 시 사용한 임의의 정수 상수입니다.
        // 여러 개의 권한을 요청한 경우를 대비하여 switch문을 사용하여 처리할 수도 있습니다.
        if (requestCode == 0) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getToken();
            } else {
                AlertDialog.Builder dialog =  new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("권한 설정");
                dialog.setMessage("앱 권한을 설정해주세요.");
                dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                dialog.show();
            }
        }
    }


//  디바이스 토큰 값: dm2UWBR-SQCvK4IX02u0ol:APA91bGYaM7bCSBob_sVUez3Nc5yRrsYkz90gcuUaWwVsXyx8SrcQNIln_DHlyGpoRIL5Norw4QERTYyVLHWUeRmXcwvXhPhCEuh163B2n42lLkF1HkgsOwkLiLItU79VQwyB_W-hvk8
//  토큰 불러오기
    private void getToken() {

            FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
                        @Override
                        public void onComplete(@NonNull Task<String> task) {

                            API_BASE api_base = new API_BASE();
                            API_AS api_as = api_base.getAPI_BASE_AS().create(API_AS.class);

                            if (task.isSuccessful()) {
                                token = task.getResult();
                                api_as.updateToken("EMPTY",
                                        token,
                                        PhoneUtils.getPhoneNumber(getApplicationContext(), MainActivity.this).trim(),
                                        "A",
                                        "").enqueue(new Callback<API_MODEL_UpdateToken>() {
                                    @Override
                                    public void onResponse(Call<API_MODEL_UpdateToken> call, Response<API_MODEL_UpdateToken> response) {
                                        Log.d("TESTLOG", "RESULT : " + response.body().toString());
                                    }

                                    @Override
                                    public void onFailure(Call<API_MODEL_UpdateToken> call, Throwable t) {
                                        Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                        }

            });
    }
}