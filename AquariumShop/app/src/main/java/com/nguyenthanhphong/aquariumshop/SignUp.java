package com.nguyenthanhphong.aquariumshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    EditText hoten,username, password,email,country,dob;
    RadioGroup gender;
    Button registe, back_login;
    DBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getSupportActionBar().hide();


        hoten= findViewById(R.id.edittext_hoten);
        username= findViewById(R.id.edittext_tennd);
        password= findViewById(R.id.edittext_matkhau);
        email= findViewById(R.id.edittext_email);
        country= findViewById(R.id.edittext_diachi);
        dob= findViewById(R.id.edittext_ngaysinh);
        gender= findViewById(R.id.gioi_tinh);
        registe= findViewById(R.id.button_dangky);
        back_login = findViewById(R.id.back_login);
        helper = new DBHelper(this);
        registe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();
                String emailValue = email.getText().toString();
                String countryValue = country.getText().toString();
                String dobValue = dob.getText().toString();
                String hotenValue = hoten.getText().toString();
                RadioButton checkBtn = findViewById(gender.getCheckedRadioButtonId());
                String genderValue = checkBtn.getText().toString();

                if (usernameValue.length()>1){
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("hoten", hotenValue);
                    contentValues.put("username", usernameValue);
                    contentValues.put("country", countryValue);
                    contentValues.put("email", emailValue);
                    contentValues.put("dob", dobValue);
                    contentValues.put("password", passwordValue);
                    contentValues.put("gender", genderValue);

                    helper.insertUser(contentValues);
                    Toast.makeText(SignUp.this, "Đăng ký tài khoản thành công !", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(SignUp.this, "Đăng ký tài khoản thất bại !", Toast.LENGTH_SHORT).show();
                }
            }
        });
        back_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });
    }
}