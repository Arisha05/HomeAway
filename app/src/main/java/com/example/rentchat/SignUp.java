package com.example.rentchat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    //Variables
    TextInputLayout regName, regUsername, regEmail, regPhoneNo, regPassword;
    Button regBtn, regToLoginBtn;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference().child("Users");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //Hooks to all xml elements in activity_sign_up.xml
        regName = findViewById(R.id.name);
        regUsername = findViewById(R.id.username);
        regEmail = findViewById(R.id.email);
        regPhoneNo = findViewById(R.id.phoneNo);
        regPassword = findViewById(R.id.password);
        regBtn = findViewById(R.id.reg_btn);
        regToLoginBtn = findViewById(R.id.reg_login_btn);
    }

    private Boolean validateName(){
        String val = regName.getEditText().getText().toString();

        if (val.isEmpty()) {
            regName.setError("Field cannot be empty");
            return false;
        } else {
            regName.setError(null);
            regName.setEnabled(false);
            return true;
        }
    }

    private Boolean validateUsername(){
        String val = regUsername.getEditText().getText().toString();
        String noWhiteSpace = "(?=\\S+$)";

        if (val.isEmpty()) {
            regUsername.setError("Field cannot be empty");
            return false;
        } else if(val.length()>=15){
            regUsername.setError("Username too long");
            return false;
        }else if(!val.matches(noWhiteSpace)){
            regUsername.setError("White Spaces are not allowed");
            return false;
        } else {
            regUsername.setError(null);
            regUsername.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateEmail(){
        String val = regEmail.getEditText().getText().toString();
        String emailPattern = "[a-zA-z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            regEmail.setError("Field cannot be empty");
            return false;
        } else if(!val.matches(emailPattern)){
            regEmail.setError("Invalid email address");
            return false;
        } else {
            regEmail.setError(null);
            return true;
        }
    }

    private Boolean validatePhoneNo(){
        String val = regPhoneNo.getEditText().getText().toString();

        if (val.isEmpty()) {
            regPhoneNo.setError("Field cannot be empty");
            return false;
        } else {
            regPhoneNo.setError(null);
            return true;
        }
    }

    private Boolean validatePassword(){
        String val = regPassword.getEditText().getText().toString();
        String passwordVal = "^" +
                             "(?=.*[a-zA-Z)"+
                             "(?=.*[@#$%^&+=])" +
                             "(?=\\S+$)" +
                             ".{4,}" +
                             "$";

        if (val.isEmpty()) {
            regPassword.setError("Field cannot be empty");
            return false;
        } else if(!val.matches(passwordVal)){
            regPassword.setError("Password is too weak");
            return false;
        }else {
            regPassword.setError(null);
            return true;
        }
    }

    //Save data in firebase on button click
    public void onClick(View view) {

        if(!validateName() | validatePassword() | validatePhoneNo() | validateEmail() | validateUsername()){
            return;
        }

        //Get all the values
        String name = regName.getEditText().getText().toString();
        String username = regUsername.getEditText().getText().toString();
        String email = regEmail.getEditText().getText().toString();
        String phoneNo = regPhoneNo.getEditText().getText().toString();
        String password = regPassword.getEditText().getText().toString();

        UserHelperClass helperClass = new UserHelperClass(name, username, email, phoneNo, password);

        reference.child("phoneNo").setValue(helperClass);




    regToLoginBtn.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View view){
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
    }
    });


}
}
