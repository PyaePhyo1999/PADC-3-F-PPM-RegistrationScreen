package com.padcmyanmar.padcassignment2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.NoCopySpan;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by V3-575G on 15-11-2017.
 */

public class LoginActivity extends AppCompatActivity {
    public static Intent newIntent(Context context){
        Intent intent = new Intent(context,LoginActivity.class);
        return intent;
    }



    private  static final String CORRECT_EMAIL = "ppm1999@gmail.com";
    private static final String CORRECT_PASSWORD="ppm1999";

    private EditText etEmailOrPhone;
    private EditText etPassword;
    private Button btnLogin;
    private TextView btnForgotPassword;
    private TextView btnNewUserOrRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {





        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmailOrPhone=findViewById(R.id.et_email_or_phone);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        btnForgotPassword = findViewById(R.id.btn_forgot_password);
        btnNewUserOrRegister=findViewById(R.id.btn_new_user_or_register);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailorphone = etEmailOrPhone.getText().toString();
                if (TextUtils.isEmpty(emailorphone))
                {
                       etEmailOrPhone.setError("Email or Phone cannot be empty");
                       return;
                }
                String password = etPassword.getText().toString();
                if (TextUtils.isEmpty(password)){
                    etPassword.setError("Password cannot be empty");
                    return;
                }
                if(TextUtils.equals(emailorphone,CORRECT_EMAIL) && TextUtils.equals(password,CORRECT_PASSWORD)){
                    Intent intent = new HelloActivity().newIntent(getApplicationContext());
                    startActivity(intent);
                }
                else{
                    Snackbar.make(v,"Incorrect email or password!.Please try again",Snackbar.LENGTH_INDEFINITE).show();
                }

            }
        });
        btnNewUserOrRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new RegisterActivity().newintent(getApplicationContext());
                startActivity(intent);
            }
        });

    }
}
