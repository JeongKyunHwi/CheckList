package com.example.jeong_kyunhwi.tdcl;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class New_Character extends AppCompatActivity {

    final String[] popup_class_list = {"워로드", "디스트로이어", "버서커", "홀리나이트", "인파이터", "배틀마스터", "기공사", "창술사", "스트라이커",
            "데빌헌터", "블래스터", "호크아이", "스카우터", "건슬링어", "서머너", "바드", "아르카나", "블레이드", "데모닉", "리퍼"};

    String class_name = "";

    ImageView select_class;
    EditText character_name;
    EditText item_level;

    List_DB.CharacterDbHelper dbHelper = new List_DB.CharacterDbHelper(getApplicationContext());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__character);

        select_class = (ImageView) findViewById(R.id.Character_class);
        character_name = (EditText)findViewById(R.id.Character_name);
        item_level = (EditText)findViewById(R.id.item_level);

        select_class.setOnClickListener(new Select_class());
    }


    class Select_class implements View.OnClickListener {
        ImageView select_class = (ImageView) findViewById(R.id.Character_class);

        @Override
        public void onClick(View v) {
            Toast myToast = Toast.makeText(New_Character.this, "이미지 터치", Toast.LENGTH_SHORT);
            myToast.show();

            AlertDialog.Builder class_list = new AlertDialog.Builder(New_Character.this);

            class_list.setTitle("직업을 선택하세요")
                    .setItems(popup_class_list, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(), popup_class_list[which], Toast.LENGTH_LONG).show();
                            //온클릭시 이미지 변경으로 수정
                            select_class.setImageResource(R.drawable.ic_launcher_background);
                            class_name = popup_class_list[which];
                        }
                    })
                    .setCancelable(true)
                    .show();
        }
    }

    public void create_button(View view) {
        Intent intent = new Intent(New_Character.this, MainActivity.class);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(List_DB.CharacterEntry.COLUMN_NAME_TITLE, character_name.getText().toString());
        values.put(List_DB.CharacterEntry.COLUMN_NAME_FIRST_SUBTITLE, class_name);
        values.put(List_DB.CharacterEntry.COLUMN_NAME_SECOND_SUBTITLE, item_level.getText().toString());

        long newRowId = db.insert(List_DB.CharacterEntry.TABLE_NAME,null, values);

        //db 이용을 생각해보자.
        //db를 업데이트하고 인텐트
        startActivity(intent);
    }


}
