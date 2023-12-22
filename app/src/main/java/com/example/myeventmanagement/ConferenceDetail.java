package com.example.myeventmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class ConferenceDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conference_detail);
        Button confBack = findViewById(R.id.confButton1);
        Button confReg = findViewById(R.id.confButton2);

        confBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Get the FragmentManager
                FragmentManager fragmentManager = getSupportFragmentManager();

                if (fragmentManager.getBackStackEntryCount() > 0) {
                    // If there are fragments in the back stack, pop the top fragment
                    fragmentManager.popBackStack();
                } else {
                    // If there are no fragments in the back stack, you can handle this case as needed
                    // For example, navigate to a different activity or finish the current activity
                    finish();
                }
            }
        });

        confReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConferenceDetail.this, Register.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        // Handle the back button press here
        // You can perform any additional actions before navigating back if needed

        // Check if there are fragments in the back stack
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 0) {
            // If there are fragments in the back stack, pop the top fragment
            fragmentManager.popBackStack();
        } else {

            super.onBackPressed();
        }
    }
}
