package com.nguyenthanhphong.aquariumshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText username, password;
    Button btn_dangnhap_main;
    DBHelper data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        btn_dangnhap_main = findViewById(R.id.button_login_dangnhap);
        username = findViewById(R.id.edittext_login_tendn);
        password = findViewById(R.id.edittext_login_matkhau);
        data = new DBHelper(this);
        btn_dangnhap_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();

                boolean check = data.checkhang(usernameValue, passwordValue);
                if(username.equals("") || password.equals("")){
                    Toast.makeText(Login.this, "Bạn Cần Nhập Đầy Đủ Thông Tin Đăng Nhập !", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (check == true) {
                        Intent intent1 = new Intent(Login.this, MainActivity.class);
                        startActivity(intent1);
                        Toast.makeText(Login.this, "Đăng nhập thành công !", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Login.this, "Đăng nhập thất bại !", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public void signUp(View view) {
        startActivity(new Intent(Login.this, SignUp.class));
        Toast.makeText(Login.this,"Điền thông tin để tạo tài khoản !", Toast.LENGTH_SHORT).show();
//        accSign.requestFocus();
    }
    public void btn_Signup_From(View view) {
        startActivity(new Intent(getApplicationContext(),SignUp.class));
        
    }
}