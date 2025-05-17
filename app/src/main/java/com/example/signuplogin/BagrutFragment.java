package com.example.signuplogin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class BagrutFragment extends Fragment {

    private RecyclerView rvBagrut;
    private List<Bagrut> bagrutList;
    private FireBaseServices fbs;
    private String subjectId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bagruts, container, false);

        rvBagrut = view.findViewById(R.id.rvBagrut);
        rvBagrut.setLayoutManager(new LinearLayoutManager(getContext()));

        bagrutList = new ArrayList<>();
        fbs = FireBaseServices.getInstance();

        if (getArguments() != null) {
            subjectId = getArguments().getString("subjectId");
            loadBagruts();
        }

        return view;
    }

    private void loadBagruts() {
        fbs.getFire().collection("subjects")
                .document(subjectId)
                .collection("bagruts")
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    bagrutList.clear();
                    for (DocumentSnapshot doc : queryDocumentSnapshots) {
                        Bagrut b = doc.toObject(Bagrut.class);
//                        b.setId(doc.getId());
                        bagrutList.add(b);
                    }

                    rvBagrut.setAdapter(new BagrutAdapter(bagrutList, getContext()));
     });
}
}
