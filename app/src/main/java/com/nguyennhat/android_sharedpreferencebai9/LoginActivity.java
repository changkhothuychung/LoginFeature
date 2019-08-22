package com.nguyennhat.android_sharedpreferencebai9;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button btn, btn2;
    private EditText edt1, edt2;
//    private SharedPreferences myPreferences;
//    private SharedPreferences.Editor mEditor;
    private MyPreference myPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        btn2 = (Button) findViewById(R.id.dangky);
        edt1 = (EditText) findViewById(R.id.username);
        edt2 = (EditText) findViewById(R.id.password);
        //myPreferences = getSharedPreferences("abc", MODE_PRIVATE);
        myPreferences = MyPreference.getInstance();
//        mEditor = myPreferences.edit();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edt1.getText().toString();
                String password = edt2.getText().toString();

                User user = myPreferences.get(Constant.KEY_USER, User.class);

                    if (    username.equals(user.getUsername()) &&
                            password.equals(user.getPassword())
                        ) {
                    myPreferences.put("key_auto", true);
//                    mEditor.apply();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                } else {
                    Toast.makeText(LoginActivity.this, "Account does not exist", Toast.LENGTH_LONG).show();
                }

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });


    }
}
