package com.example.android.newfragmentcommunication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentCommunicator{

    private FragmentA fragA;
    private FragmentB fragB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragA = new FragmentA();
        fragB = new FragmentB();

        getSupportFragmentManager().beginTransaction().add(R.id.frag_a_container, fragA).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frag_b_container, fragB).commit();
    }

    //"message" is the message being sent, "tag" is the tag of the sending activity
    @Override
    public void sendMessage(String message, String tag) {
        if(tag.equals(getString(R.string.tagFragA))) {
            fragB.receiveMessage(message);
        }

        if (tag.equals(getString(R.string.tagFragB))) {
            fragA.receiveMessage(message);
        }
    }
}
