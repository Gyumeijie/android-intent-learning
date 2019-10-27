package com.github.gyumeijie.intentusage;

import android.app.Activity;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends Activity {
    static final String TAG = "MAIN_ACTIVITY_LIFECYCLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart()");
    }

    public void phoneCall(View view) {
        Uri uri = Uri.parse("tel:10086");
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(intent);
    }

    public void sendMessage(View view) {
        Uri uri = Uri.parse("smsto:10086");
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body", "Hello");
        startActivity(intent);
    }

    public void openBrowser(View view) {
        Uri uri = Uri.parse("http://www.baidu.com");
        Intent intent  = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void wifiSetting(View view) {
        Intent intent = new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
        startActivityForResult(intent, RESULT_OK);
    }

    public void google(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY,"searchString");
        startActivity(intent);
    }

    public void openOtherAPP(View view) {
        Intent intent = new Intent();
        ComponentName componentName = new ComponentName("com.github.gyumeijie.activitylifecycle",
                "com.github.gyumeijie.activitylifecycle.MainActivity");
        intent.setComponent(componentName);
        intent.setAction("android.intent.action.MAIN");
        startActivityForResult(intent, RESULT_OK);
    }

    public void sendEmailWithoutContent(View view) {
        Uri uri = Uri.parse("mailto:yumeijie@zju.edu.cn");
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        startActivity(intent);
    }

    public void sendEmailWithContent(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, "yumeijie@zju.edu.cn");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        intent.putExtra(Intent.EXTRA_TEXT, "Hello");
        intent.setType("text/plain");
        startActivity(intent);
    }

    public void openMap(View view) {
        Uri uri = Uri.parse("geo:39.9,116.3");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void setAlarm(View view) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
        ArrayList<Integer> alarmDays = new ArrayList();
        alarmDays.add(Calendar.MONDAY);
        alarmDays.add(Calendar.TUESDAY);
        intent.putExtra(AlarmClock.EXTRA_MESSAGE, "set alarm")
              .putExtra(AlarmClock.EXTRA_HOUR, 7)
              .putExtra(AlarmClock.EXTRA_MINUTES, 50)
              .putExtra(AlarmClock.EXTRA_DAYS, alarmDays)
              .putExtra(AlarmClock.EXTRA_SKIP_UI, false);
        startActivity(intent);
    }
}