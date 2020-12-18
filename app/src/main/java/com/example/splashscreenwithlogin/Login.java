package com.example.splashscreenwithlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText User_Name, Password;
    Button Login;

    public static final String MyPREFERENCES = "MyPrefs";

    public static final String Name_KEY = "UserName";
    public static final String Password_KEY = "PASSWORD";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        User_Name = (EditText) findViewById(R.id.User_NAME);
        Password = (EditText) findViewById(R.id.Passwordd);
        Login = (Button) findViewById(R.id.Btn_Login);

            Login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String NAME = User_Name.getText().toString();
                    String PWD = Password.getText().toString();

                    if (NAME.isEmpty() && PWD.isEmpty())  {

                        Toast.makeText(Login.this, "Fields are empty", Toast.LENGTH_LONG).show();

                    }
                    else
                    {
                        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

                        final String name = sharedpreferences.getString(Name_KEY, null);
                        final String password = sharedpreferences.getString(Password_KEY, null);

                        SharedPreferences.Editor editor = sharedpreferences.edit();

                        editor.putString(Name_KEY, NAME);
                        editor.putString(Password_KEY, PWD);
                        editor.apply();

                        Toast.makeText(Login.this, "DONE", Toast.LENGTH_LONG).show();
                        openHome_Activity();
                    }

            }

                private void openHome_Activity() {

                    Intent intent = new Intent(Login.this, Home_Activity.class);
                    startActivity(intent);

                }
                });

            }

}
