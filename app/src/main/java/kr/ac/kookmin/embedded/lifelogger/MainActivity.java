package kr.ac.kookmin.embedded.lifelogger;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {


    Button bt_map;
    Button bt_data;
    Button bt_record;
    Context mContext;
    Intent mapintent;
    Intent dataintent;
    Intent selectintent;
    Intent splash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this.getApplication().getApplicationContext();

        bt_map = (Button) findViewById(R.id.bt_map);
        bt_data = (Button) findViewById(R.id.bt_data);
        bt_record = (Button) findViewById(R.id.bt_record);

        mapintent = new Intent(this, GoogleMapActivity.class);
        dataintent = new Intent(this, DBListActivity.class);
        selectintent = new Intent(this, SelectAct.class);
        splash = new Intent(this, SplashActivity.class);

        // Splash(로딩화명) 띄우기
        startActivity(splash);

        bt_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "GPS 를 사용합니다 \n 잠시 기다려 주세요", Toast.LENGTH_LONG).show();
                startActivity(mapintent);
            }
        });

        bt_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "데이터 를 조회합니다", Toast.LENGTH_LONG).show();
                startActivity(dataintent);
            }
        });

        bt_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "통계를 조회합니다", Toast.LENGTH_LONG).show();
                startActivity(selectintent);
            }
        });
    }

}