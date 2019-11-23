package com.example.bazaarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class activitySignup extends AppCompatActivity {
EditText fName,lName,mail,passw;
    Button button;
    DatabaseReference reff;
    DatabaseReference ref;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        fName=findViewById(R.id.editTextfname);
        lName=findViewById(R.id.editTextlname);
        mail=findViewById(R.id.editTextemail);
        passw=findViewById(R.id.editTextpassword);
        user=new User();
        reff= FirebaseDatabase.getInstance().getReference().child("User");

        ref= FirebaseDatabase.getInstance().getReference().child("User");

        addListenerOnButton();

    }


    public void addListenerOnButton()
    {

        final Context context = this;

        button = (Button) findViewById(R.id.buttonSignup1);

        button.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0) {
                user.setfName(fName.getText().toString().trim());
                user.setlName(lName.getText().toString().trim());
                user.setEmail(mail.getText().toString().trim());
                user.setPassword(passw.getText().toString().trim());

                reff.push().setValue(user);
                ref.push().setValue(user);
                Toast.makeText(context,"You have Signed up!",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);

            }

        });

    }
}
