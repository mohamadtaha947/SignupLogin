package com.example.signuplogin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class SubjectListFragment extends Fragment {

    private RecyclerView rvSubjects;
    private SubjectAdapter adapter;
    private List<Subject> subjectList;
    private Button btnAddSubject;
    private FireBaseServices fbs;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subject_list, container, false);

        rvSubjects = view.findViewById(R.id.rvSubjects);
        rvSubjects.setLayoutManager(new LinearLayoutManager(getContext()));
        subjectList = new ArrayList<>();
        adapter = new SubjectAdapter(subjectList);
        rvSubjects.setAdapter(adapter);btnAddSubject = view.findViewById(R.id.btnAddSubject);
        btnAddSubject.setOnClickListener(v -> {
            // Navigate to the AllSubjectsFragment
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.FrameLayoutsMain, new AllSubjectsFragment()) // Adjust ID as needed
                    .addToBackStack(null).commit();
        });
        fbs = FireBaseServices.getInstance();

        loadSubjectsFromFirebase();

        return view;
    }

    private void loadSubjectsFromFirebase() {
        String userId = fbs.getAuth().getUid();

        fbs.getFire().collection("users")
                .document(userId)
                .collection("subjects")
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    subjectList.clear();
                    for (DocumentSnapshot doc : queryDocumentSnapshots) {
                        Subject subject = doc.toObject(Subject.class);
                        subjectList.add(subject);
                    }
                    adapter.notifyDataSetChanged();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(getContext(), "Failed to load subjects", Toast.LENGTH_SHORT).show();
     });
}
}
