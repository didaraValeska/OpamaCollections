package com.opama.ditha.opamacollection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class  MainActivity extends AppCompatActivity{
    Button btnSapi;
    Button btnTazmania;
    Button btnJerapah;
    Button btnMickey;
    Button btnMinnie;
    Button btnKitty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSapi = (Button) findViewById(R.id.btn_1);
        btnTazmania = (Button) findViewById(R.id.btn_2);
        btnJerapah = (Button) findViewById(R.id.btn_3);
        btnMickey = (Button) findViewById(R.id.btn_4);
        btnMinnie = (Button) findViewById(R.id.btn_5);
        btnKitty = (Button) findViewById(R.id.btn_6);

        btnSapi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent sapiActivity = new Intent(MainActivity.this, SapiActivity.class);
                startActivity(sapiActivity);
            }
        });

        btnTazmania.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent tazmaniaActivity = new Intent(MainActivity.this, TazmaniaActivity.class);
                startActivity(tazmaniaActivity);
            }
        });

        btnJerapah.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent btnJerapah = new Intent(MainActivity.this, JerapahActivity.class);
                startActivity(btnJerapah);
            }
        });

        btnMickey.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent btnMickey = new Intent(MainActivity.this, MickeyActivity.class);
                startActivity(btnMickey);
            }
        });

        btnMinnie.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent btnMinnie = new Intent(MainActivity.this, MinnieActivity.class);
                startActivity(btnMinnie);
            }
        });

        btnKitty.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent btnKitty = new Intent(MainActivity.this, KittyActivity.class);
                startActivity(btnKitty);
            }
        });
     }
}
