package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (EditText) findViewById(R.id.tv1);

        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        tv1.setText(preferences.getString("mail", ""));
    }

    //Metodo para el boton guardar
    public void guardar (View view){
        SharedPreferences preferences1 = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferences1.edit();
        obj_editor.putString("mail", tv1.getText().toString());
        obj_editor.commit();
        finish();
    }
}