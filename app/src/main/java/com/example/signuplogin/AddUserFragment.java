package com.example.signuplogin;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddUserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddUserFragment extends Fragment {
    private EditText etid,etfirstname,etlastname,etbirtdate,etphone,etusername;
    private Button btnAdd;
    private FireBaseServices fbs;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddUserFragment() {
        // Required empty public constructor
    }
    @Override
    public void onStart(){
        super.onStart();
        connectComponents();
    }

    private void connectComponents() {
        etid=getActivity().findViewById(R.id.etId);
        etfirstname=getActivity().findViewById(R.id.etfirstname);
        etlastname=getActivity().findViewById(R.id.etlastname);
        etbirtdate=getActivity().findViewById(R.id.etbirthDate);
        etphone=getActivity().findViewById(R.id.etphone);
        fbs=FireBaseServices.getInstance();
        btnAdd=getActivity().findViewById(R.id.btnAdd);
        etusername=getActivity().findViewById(R.id.etusername);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Id,firstname,lastname,birthdate,phone,username;
                Id=etid.getText().toString();
                firstname=etfirstname.getText().toString();
                lastname=etlastname.getText().toString();
                birthdate=etbirtdate.getText().toString();
                phone=etphone.getText().toString();
                username=etusername.getText().toString();
                if(Id.trim().isEmpty()||firstname.trim().isEmpty()||lastname.trim().isEmpty()||birthdate.trim().isEmpty()||phone.trim().isEmpty()||username.trim().isEmpty())
                {
                    Toast.makeText(getActivity(), "some fields are empty!", Toast.LENGTH_SHORT).show();
                    return;
                }
                User rest=new User("",username,phone,birthdate,lastname,firstname,Id);
                fbs.getFire().collection("users").add(rest).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getActivity(), "successs!", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getActivity(), "failure!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddUserFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddUserFragment newInstance(String param1, String param2) {
        AddUserFragment fragment = new AddUserFragment();
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
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }
}