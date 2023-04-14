package com.example.registerandlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    TextView btn;
    EditText inputEmail, inputPassword;
    Button btnLogin;
    ProgressDialog mLoadingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    btn=findViewById(R.id.textViewSignUp);
    inputEmail=findViewById(R.id.inputEmail);
    inputPassword=findViewById(R.id.inputPassword);
    btnLogin=findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(view -> checkCredentials());
    mLoadingBar=new ProgressDialog(Login.this);

        btn.setOnClickListener(view -> startActivity(new Intent(Login.this,register.class)));
}

    private void checkCredentials() {
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();

        if (email.isEmpty() || email.length()<12)
        {
            showError(inputEmail, "Email is not valid");
        }
        else if (password.isEmpty() || password.length()<7)
        {
            showError(inputPassword, "Password must be over 7 characters");
        }
        else
        {
            mLoadingBar.setTitle("Login");
            mLoadingBar.setMessage("Please wait as we check your credentials");
            mLoadingBar.setCanceledOnTouchOutside(false);
            mLoadingBar.show();


                        mLoadingBar.dismiss();
                        Toast.makeText(Login.this,"Login is Successful",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(Login.this,MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    }
        }

    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }

}