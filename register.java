/**/package com.example.registerandlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class register extends AppCompatActivity {

    TextView btn;
    private EditText inputPassword,inputEmail,inputConfirmPassword;
    Button btnRegister;
    private ProgressDialog mloadingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn=findViewById(R.id.alreadyHaveAccount);
        inputEmail=findViewById(R.id.inputEmail);
        inputPassword=findViewById(R.id.inputPassword);
        inputConfirmPassword= findViewById(R.id.inputConfirmPassword);
        mloadingBar=new ProgressDialog(register.this);

        btnRegister=findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(view -> checkCredentials());

        checkCredentials();

        btn.setOnClickListener(view -> startActivity(new Intent(register.this,Login.class)));

    }

    private void checkCredentials() {
        String email=inputEmail.getText().toString();
        String password=inputPassword.getText().toString();
        String confirmPassword=inputPassword.getText().toString();

        if (!email.contains("damadeesimiyu@gmail.com"))
        {
            showError(inputEmail, "Email is not valid");
        }
        else if (password.isEmpty() || password.length()<7)
        {
            showError(inputPassword, "Password must be over 7 characters");
        }
        else if (confirmPassword.isEmpty() || !confirmPassword.equals(password))
        {
            showError(inputConfirmPassword, "Password does not match");
        }
        else
        {
            mloadingBar.setTitle("Registration");
            mloadingBar.setMessage("Please wait as we Authenticate your account");
            mloadingBar.setCanceledOnTouchOutside(false);
            mloadingBar.show();


                        mloadingBar.dismiss();
                        Toast.makeText(register.this, "Registration is Successful", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(register.this,MainActivity.class );
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    }
                }


    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }
}

