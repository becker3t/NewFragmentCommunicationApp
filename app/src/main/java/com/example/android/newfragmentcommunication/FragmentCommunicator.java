package com.example.android.newfragmentcommunication;

/**
 * Created by Android on 6/1/2017.
 */

public interface FragmentCommunicator {
    //first is the message to be sent, second is the identifier telling what fragment sent the message
    void sendMessage(String message, String tag);
}
