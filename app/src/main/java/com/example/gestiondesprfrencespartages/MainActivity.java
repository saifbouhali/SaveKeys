package com.example.gestiondesprfrencespartages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button save;
    private Button  login;
    private Button  clean;
    private CheckBox check;
    private EditText email;
    private EditText password;
    private TextView mail;
    private TextView pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save=findViewById(R.id.save);
        login=findViewById(R.id.login);
        clean=findViewById(R.id.clean);
        check=findViewById(R.id.remamber);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        mail=findViewById(R.id.mail);
        pass=findViewById(R.id.pass);



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check.isChecked()){
                    SharedPreferences sharedPref = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("email",email.getText().toString());
                    editor.putString("password",password.getText().toString());
                    editor.apply();
                }

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPref = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
                mail.setText(sharedPref.getString("email",""));
                pass.setText(sharedPref.getString("password",""));
            }
        });
        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPref = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.clear();
                editor.apply();
                mail.setText("");
                pass.setText("");
            }
        });
    }
}
