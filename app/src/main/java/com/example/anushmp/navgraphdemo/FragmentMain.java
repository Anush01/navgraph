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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentMain#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentMain extends Fragment {

    //lloyd
    //constraintlayout.
    //nav listner catch 22; dagger job
    //two projects. learning library first iteration.

    Button viewtransaction;
    Button sendmoney;
    Button viewbalance;

    NavController navigationcontroller;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentMain() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentMain.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentMain newInstance(String param1, String param2) {
        FragmentMain fragment = new FragmentMain();
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
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //god mode

        viewtransaction = view.findViewById(R.id.viewTransactionbutton);
        sendmoney = view.findViewById(R.id.sendMoneybutton);
        viewbalance = view.findViewById(R.id.viewBalancebutton);


        viewtransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navigationcontroller.navigate(R.id.action_fragmentMain_to_fragmentViewTransaction);

            }
        });

        sendmoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navigationcontroller.navigate(R.id.action_fragmentMain_to_fragmentChooseRecipient);

            }
        });

        viewbalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navigationcontroller.navigate(R.id.action_fragmentMain_to_fragmentViewBalance);

            }
        });


        navigationcontroller = Navigation.findNavController(view);
    }
}