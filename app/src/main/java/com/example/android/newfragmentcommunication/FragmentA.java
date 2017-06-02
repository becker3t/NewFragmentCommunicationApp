package com.example.android.newfragmentcommunication;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentA extends Fragment implements View.OnClickListener {

    private FragmentCommunicator communicator;

    private Button helloBtnA;
    private Button goodbyeBtnA;
    private TextView resultTvA;

    public FragmentA() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            communicator = (FragmentCommunicator) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + " must implement FragmentCommunicator.");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        helloBtnA = (Button) view.findViewById(R.id.fragmentA_HelloBtn);
        goodbyeBtnA = (Button) view.findViewById(R.id.fragmentA_GoodbyeBtn);
        helloBtnA.setOnClickListener(this);
        goodbyeBtnA.setOnClickListener(this);
        resultTvA = (TextView) view.findViewById(R.id.resultTv_A);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fragmentA_HelloBtn:
                communicator.sendMessage("Hello, from FragmentA!", getString(R.string.tagFragA));
                break;
            case R.id.fragmentA_GoodbyeBtn:
                communicator.sendMessage("Goodbye, from FragmentA!", getString(R.string.tagFragA));
                break;
        }
    }

    public void receiveMessage(String message) {
        resultTvA.setText(message);
    }
}
