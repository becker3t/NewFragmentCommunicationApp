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
public class FragmentB extends Fragment implements View.OnClickListener{

    private FragmentCommunicator communicator;

    private Button helloBtnB;
    private Button goodbyeBtnB;
    private TextView resultTvB;

    public FragmentB() {
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
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        helloBtnB = (Button) view.findViewById(R.id.fragmentB_HelloBtn);
        goodbyeBtnB = (Button) view.findViewById(R.id.fragmentB_GoodbyeBtn);
        helloBtnB.setOnClickListener(this);
        goodbyeBtnB.setOnClickListener(this);
        resultTvB = (TextView) view.findViewById(R.id.resultTv_B);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fragmentB_HelloBtn:
                communicator.sendMessage("Hello, from FragmentB!", getString(R.string.tagFragB));
                break;
            case R.id.fragmentB_GoodbyeBtn:
                communicator.sendMessage("Goodbye, from FragmentB!", getString(R.string.tagFragB));
                break;
        }
    }

    public void receiveMessage(String message) {
        resultTvB.setText(message);
    }
}
