package com.example.jeong_kyunhwi.tdcl;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //manifest 수정사항 확인할 것.
    //Adapter 오류 수정할 것.
    //DB를 사용해야 할지 고려할 것.

    ArrayList<CharacterData> characterDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.InitializeCharacterData();
        ListView Character_List = (ListView)findViewById(R.id.Character_List);
        final ListAdapter listAdapter = new ListAdapter(this,characterDataList);


        Character_List.setAdapter(listAdapter);

        
    }

    //Button new_button = (Button)findViewById(R.id.new_button);
    public void new_button(View view){
        Intent intent = new Intent(this,New_Character.class);
        startActivity(intent);
    }

    public void InitializeCharacterData(){
        characterDataList = new ArrayList<CharacterData>();
        Bundle extras = getIntent().getExtras();
        String class_name = extras.getString("class_name");
        String name = extras.getString("name");
        characterDataList.add(new CharacterData(R.drawable.ic_launcher_foreground, class_name,name));



    }

    public class CharacterData{
        private int class_img;
        private String character_nickname;
        private String character_level;

        public CharacterData(int img, String nickname, String level){
            this.class_img = img;
            this.character_nickname = nickname;
            this.character_level = level;
        }

        public int getClass_img(){
            return this.class_img;
        }

        public String getCharacter_nickname() {
            return this.character_nickname;
        }

        public String getCharacter_level() {
            return this.character_level;
        }
    }

    public class ListAdapter extends BaseAdapter{
        Context mContext = null;
        LayoutInflater mLayoutInflater = null;
        ArrayList<CharacterData> C_data;

        public ListAdapter(Context context, ArrayList<CharacterData> data){
            mContext = context;
            C_data = data;
            mLayoutInflater = LayoutInflater.from(mContext);

        }

        @Override
        public int getCount() {
            return C_data.size();
        }

        @Override
        public Object getItem(int position) {
            return C_data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = mLayoutInflater.inflate(R.layout.character_list, null);

            ImageView class_img = (ImageView)findViewById(R.id.Class_img);
            TextView nickname = (TextView)findViewById(R.id.nickname);
            TextView character_level = (TextView)findViewById(R.id.character_level);

            class_img.setImageResource(C_data.get(position).getClass_img());
            nickname.setText(C_data.get(position).getCharacter_nickname());
            character_level.setText(C_data.get(position).getCharacter_level());

            return view;
        }
    }

}
