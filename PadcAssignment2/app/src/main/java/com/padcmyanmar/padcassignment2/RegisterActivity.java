package com.padcmyanmar.padcassignment2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by V3-575G on 16-11-2017.
 */

public class RegisterActivity extends AppCompatActivity {

    public static Intent newintent(Context context) {
        Intent intent = new Intent(context, RegisterActivity.class);
        return intent;


    }


    private EditText etName;
    private EditText etEmail;
    private EditText etAddress;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private RadioGroup rdGender;
    private RadioButton rdMale;
    private RadioButton rdFemale;
    private CheckBox chkHome;
    private CheckBox chkJob;
    private TextView btnLogin;
    private Button btnRegister;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtiy_register);
        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);

        etAddress = findViewById(R.id.et_address);
        etPassword = findViewById(R.id.et_password);
        etConfirmPassword = findViewById(R.id.et_confirm_password);
        rdGender = findViewById(R.id.rd_gender);
        rdMale = findViewById(R.id.rd_male);
        rdFemale = findViewById(R.id.rd_female);
        chkHome = findViewById(R.id.chk_home);

        btnLogin = findViewById(R.id.btn_to_login);
        btnRegister = findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String emailorphone = etEmail.getText().toString();
                String address = etAddress.getText().toString();
                String password = etPassword.getText().toString();
                String confirmpassword = etConfirmPassword.getText().toString();

                if (TextUtils.isEmpty(name)) {
                    etName.setError("Name cannot be empty");
                    return;
                }
                if (TextUtils.isEmpty(emailorphone)) {
                    etEmail.setError("Email or Phone cannot be empty");
                    return;
                }
                if (TextUtils.isEmpty(address)) {
                    etAddress.setError("Address cannot be empty");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    etPassword.setError("Password cannot be empty");
                    return;
                }
                if (TextUtils.isEmpty(confirmpassword)) {
                    etConfirmPassword.setError("Confirm Password cannot be empty");
                    return;
                }
                if (TextUtils.equals(password, confirmpassword)) {

                } else {
                    etConfirmPassword.setError("Password and confirm password must be same");
                    return;
                }
                if (rdMale.isChecked() || rdFemale.isChecked()) {
                    Intent intent = new LoginActivity().newIntent(getApplicationContext());
                    startActivity(intent);
                } else {
                    Snackbar.make(v, "Please check the gender.", Snackbar.LENGTH_INDEFINITE).show();
                    return;
                }
                if (password != null) {

                }


            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new LoginActivity().newIntent(getApplicationContext());
                startActivity(intent);

            }
        });

    }
}
