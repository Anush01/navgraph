package com.example.anushmp.navgraphdemo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentSpecifyAmount#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentSpecifyAmount extends Fragment {

    TextView recipientnametextview;
    EditText amountedittext;
    Button cancelbutton2,sendbutton2;
    NavController navcon;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentSpecifyAmount() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentSpecifyAmount.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentSpecifyAmount newInstance(String param1, String param2) {
        FragmentSpecifyAmount fragment = new FragmentSpecifyAmount();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recipientnametextview = view.findViewById(R.id.recipientNameTextView);
        amountedittext = view.findViewById(R.id.amountEditText);
        cancelbutton2 = view.findViewById(R.id.cancelButton2);
        sendbutton2 = view.findViewById(R.id.sendButton2);

        navcon = Navigation.findNavController(view);

        recipientnametextview.setText(getArguments().getString("recname"));


        //String data =
        //Bundle b = getArguments();
        //FragmentSpecifyAmountArgs.fromBundle();
       // FragmentConfirmationArgs.fromBundle()



        //getting the data from the choose rec fragment the args is called recname
        //String datafromchooserecipient = FragmentSpecifyAmountArgs.fromBundle(getArguments()).getRecname();
        //recipientnametextview.setText(datafromchooserecipient);



        cancelbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                getActivity().onBackPressed();

            }
        });


        sendbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bb = new Bundle();

                bb.putString("recname2",getArguments().getString("recname"));
                bb.putInt("amount",Integer.parseInt(amountedittext.getText().toString()));

                navcon.navigate(R.id.action_fragmentSpecifyAmount_to_fragmentConfirmation,bb);

            }
        });



    }
}