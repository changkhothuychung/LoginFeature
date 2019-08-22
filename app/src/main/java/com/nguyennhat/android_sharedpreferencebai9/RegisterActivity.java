package com.nguyennhat.android_sharedpreferencebai9;

import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class RegisterActivity extends AppCompatActivity {
    private Button btn;
    private EditText edt1, edt2;
//    private SharedPreferences myPreferences;
//    private SharedPreferences.Editor mEditor;

    private MyPreference myPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btn = (Button) findViewById(R.id.dkytaikhoan);
        edt1 = (EditText) findViewById(R.id.dkyusername);
        edt2 = (EditText) findViewById(R.id.dkypassword);
        //myPreferences = getSharedPreferences("abc", MODE_PRIVATE);
       // myPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        //mEditor = myPreferences.edit();

        myPreference = MyPreference.getInstance();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = edt1.getText().toString();
                String password = edt2.getText().toString();

                User user = new User(username,password);
                //myPreference.put(Constant.KEY_USER, username);
                //myPreference.put(Constant.KEY_PASSWORD, password);

                myPreference.put(Constant.KEY_USER, user);
//                mEditor.putString(Constant.KEY_USER, username);
//                mEditor.putString(Constant.KEY_PASSWORD, password);
//                mEditor.apply();
                finish();

            }
        });
    }
}
