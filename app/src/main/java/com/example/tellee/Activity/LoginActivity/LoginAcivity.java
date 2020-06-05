package com.example.tellee.Activity.LoginActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tellee.Activity.BaseAcitivity;
import com.example.tellee.Activity.Shopping.ShoppingActivity;
import com.example.tellee.Activity.TwoWayActivity.TwoWayActivity;
import com.example.tellee.Models.CreateAllData;
import com.example.tellee.Models.User;
import com.example.tellee.Models.Vendor;
import com.example.tellee.R;

import java.util.ArrayList;
import java.util.Iterator;

public class LoginAcivity extends BaseAcitivity {
    EditText Id_et,pw_et;
    ArrayList userList = CreateAllData.userList;
    Button loginbtn;

    public static String user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_acivity);

        loginbtn = (Button) findViewById(R.id.loginButton);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                checkInput();
            }
        });
    }




    public void checkInput(){
        Id_et = (EditText) findViewById(R.id.sicilnoTextView);
        pw_et = (EditText) findViewById(R.id.passwordTextView);
        String Id =  Id_et.getText().toString();
        String Pw=  pw_et.getText().toString();

        readOrder(Id);

        for (Iterator i = userList.iterator(); i.hasNext(); ) {

                User user = (User) i.next();
                if ((user.getUser_Id().equals(Id)) && (user.getPassword().equals(Pw))) {
                    SharedPreferences sharedPref = getSharedPreferences("myKey", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("user_id", Id);
                    editor.apply();
                    Intent intent = new Intent(LoginAcivity.this, TwoWayActivity.class);

                    user_id = Id;

                    intent.putExtra("user_id",user.getUser_Id());
                    startActivity(intent);
                    finish();
                    return;
                }
        }


        AlertDialog.Builder builder = new AlertDialog.Builder(LoginAcivity.this);
        builder.setTitle("Login Unsuccessful");
        builder.setMessage("Please Try Again !!!");
        builder.setNegativeButton("Okey", null);
        builder.show();
    }

}
