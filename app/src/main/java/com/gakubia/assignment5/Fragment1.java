package com.gakubia.assignment5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {
    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View v;
        v=inflater.inflate(R.layout.fragment1_layout,container,false);
        final EditText fnameView=(EditText) v.findViewById(R.id.fnameView);
        final EditText lnameView=(EditText) v.findViewById(R.id.lnameView);
        final EditText idView=(EditText) v.findViewById(R.id.idView);
        final EditText yearView=(EditText) v.findViewById(R.id.yearView);
        RadioGroup attemptsView=(RadioGroup) v.findViewById(R.id.attemptsView);
        final RadioButton attempt1=(RadioButton) v.findViewById(R.id.attempt1);
        final RadioButton attempt2=(RadioButton) v.findViewById(R.id.attempt2);
        final RadioButton femaleRadio=(RadioButton) v.findViewById(R.id.femaleRadio);
        final RadioButton maleRadio=(RadioButton) v.findViewById(R.id.maleRadio);
        Button submitBtn=(Button)v.findViewById(R.id.submitBtn);

        final Student student=new Student();
        final DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child("Student");

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idView.getText().toString();
                student.setFirstname(fnameView.getText().toString());
                student.setLastname(lnameView.getText().toString());
                student.setID(idView.getText().toString());
                student.setYear_of_study(yearView.getText().toString());
                databaseReference.child(id).setValue(student);

                String gender1 = maleRadio.getText().toString();
                String gender2 = femaleRadio.getText().toString();

                if (maleRadio.isChecked()) {
                    student.setGender(gender1);
                    databaseReference.child(id).setValue(student);
                } else {
                    student.setGender(gender2);
                    databaseReference.child(id).setValue(student);
                }

                String firstAttempt = attempt1.getText().toString();
                String secondAttempt = attempt2.getText().toString();
                if (attempt1.isChecked()) {
                    student.setAttempt(firstAttempt);
                    databaseReference.child(id).setValue(student);
                } else {
                    student.setAttempt(secondAttempt);
                    databaseReference.child(id).setValue(student);
                }
                Toast.makeText(getActivity(),"Successfully saved!", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
}
    //
    //return inflater.inflate(R.layout.fragment2_layout, container, false);