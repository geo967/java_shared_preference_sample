package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText userName,password;
    //String name,pass;

    //when using onPause()
    /*private static final String SHARED_PREFERENCE_NAME="myLoginDetails";
    private static final String USER_NAME="username";
    private static final String USER_PASSWORD="password";*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName=findViewById(R.id.edittext1);
        password=findViewById(R.id.edittext2);
        Button button=findViewById(R.id.login);

        //clearData();
        button.setOnClickListener(v -> saveData()
        );
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                Intent intent=new Intent(MainActivity.this,Page2.class);
                startActivity(intent);
            }
        });

        viewData();

        //used with onPause()
        /*SharedPreferences mySharedPreferences=getSharedPreferences(SHARED_PREFERENCE_NAME,MODE_PRIVATE);
        name=mySharedPreferences.getString(USER_NAME,"");
        pass=mySharedPreferences.getString(USER_PASSWORD,"");

        if(name!=null && pass!=null){
            userName.setText(name);
            password.setText(pass);
        }*/
    }

    /*@Override
    protected void onPause() {
        super.onPause();

        SharedPreferences mySharedPreferences=getSharedPreferences("myLoginDetails",MODE_PRIVATE);
        SharedPreferences.Editor myEditor=mySharedPreferences.edit();
        myEditor.putString(USER_NAME, userName.getText().toString());
        myEditor.putString(USER_PASSWORD,password.getText().toString());
        myEditor.apply();
    }*/

    //when no button click
   /* @Override
    protected void onPause() {
        super.onPause();
        saveData();
    }*/

    public void saveData(){
        SharedPreferences sp=getSharedPreferences("datafile",MODE_PRIVATE);
        SharedPreferences.Editor ed=sp.edit();
        ed.putString("username",userName.getText().toString());
        ed.putString("password",password.getText().toString());
        ed.apply();
    }
    public void viewData(){
        SharedPreferences sp=getSharedPreferences("datafile",MODE_PRIVATE);
        if(sp.contains("username")){
            userName.setText(sp.getString("username",""));
            password.setText(sp.getString("password",""));
        }
    }
    public void clearData(){
        SharedPreferences sp=getSharedPreferences("datafile",MODE_PRIVATE);
        SharedPreferences.Editor ed=sp.edit();
        if(sp.contains("username")){
            ed.remove("username");
            ed.remove("password");
        }
        ed.apply();
    }


}