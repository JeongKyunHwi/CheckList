package com.example.jeong_kyunhwi.tdcl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView Character_List = (ListView)findViewById(R.id.Character_List);
    }

    //Button new_button = (Button)findViewById(R.id.new_button);
    public void new_button(View view){
        Intent intent = new Intent(this,New_Character.class);
        startActivity(intent);
    }

}
