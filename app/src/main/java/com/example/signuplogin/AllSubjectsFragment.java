package com.example.signuplogin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class AllSubjectsFragment extends Fragment {

    private RecyclerView rvAllSubjects;
    private List<Subject> allSubjects = new ArrayList<>();
    private FireBaseServices fbs;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_subjects, container, false);

        rvAllSubjects = view.findViewById(R.id.rvAllSubjects);
        rvAllSubjects.setLayoutManager(new LinearLayoutManager(getContext()));

        fbs = FireBaseServices.getInstance();

        loadAllSubjects();

        return view;
    }

    private void loadAllSubjects() {
        fbs.getFire().collection("subjects")
                .get()
                .addOnSuccessListener(snapshot -> {
                    allSubjects.clear();
                    for (DocumentSnapshot doc : snapshot.getDocuments()) {
                        Subject subject = doc.toObject(Subject.class);
                        subject.setId(doc.getId());
                        allSubjects.add(subject);
                    }

                    rvAllSubjects.setAdapter(new AllSubjectsAdapter(allSubjects, subject -> {
                        addSubjectToUser(subject);
                    }));
                });
    }

    private void addSubjectToUser(Subject subject) {
        String userId = fbs.getAuth().getUid();
        fbs.getFire().collection("users")
                .document(userId)
                .collection("subjects")
                .document(subject.getId()) // or another unique ID
                .set(subject)
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(getContext(), "Subject added!", Toast.LENGTH_SHORT).show();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(getContext(), "Failed to add subject", Toast.LENGTH_SHORT).show();
     });
                 }
}
