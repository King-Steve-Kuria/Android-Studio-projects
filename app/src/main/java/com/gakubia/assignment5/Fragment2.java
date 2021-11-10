package com.gakubia.assignment5;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {
    private Course course;
    private DatabaseReference databaseReference, dbReference;
    CheckBox checkBox, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7;
    TextView errView;
    EditText idcoursesView;
    Button courseBtn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view2=inflater.inflate(R.layout.fragment2_layout,container,false);
        checkBox=view2.findViewById(R.id.checkBox);
        checkBox2=view2.findViewById(R.id.checkBox2);
        checkBox3=view2.findViewById(R.id.checkBox3);
        checkBox4=view2.findViewById(R.id.checkBox4);
        checkBox5=view2.findViewById(R.id.checkBox5);
        checkBox6=view2.findViewById(R.id.checkBox6);
        checkBox7=view2.findViewById(R.id.checkBox7);
        errView=view2.findViewById(R.id.errView);
        courseBtn=view2.findViewById(R.id.courseBtn);
        idcoursesView=view2.findViewById(R.id.idcoursesView);
        course=new Course();

        databaseReference= FirebaseDatabase.getInstance().getReference();
        dbReference=FirebaseDatabase.getInstance().getReference().child("Course");

        courseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int counter=0;

                if (checkBox.isChecked()) {
                    counter++;
                }
                if (checkBox2.isChecked()) {
                    counter++;
                }
                if (checkBox3.isChecked()) {
                    counter++;
                }
                if (checkBox4.isChecked()) {
                    counter++;
                }
                if (checkBox5.isChecked()) {
                    counter++;
                }
                if (checkBox6.isChecked()) {
                    counter++;
                }
                if (checkBox7.isChecked()) {
                    counter++;
                }

                if (counter<=5){
                    final String idno = idcoursesView.getText().toString().trim();
                    databaseReference = FirebaseDatabase.getInstance().getReference().child("Student").child(idno);
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            try {
                                String idnumber = snapshot.child("id").getValue().toString();
                                if (idno.equals(idnumber)) {
                                    String idnum = idcoursesView.getText().toString();
                                    dbReference.child(idnum).setValue(course);
                                    if (checkBox.isChecked()) {
                                        course.setCourse1(checkBox.getText().toString());
                                        dbReference.child(idnum).setValue(course);
                                    }
                                    if (checkBox2.isChecked()) {
                                        course.setCourse2(checkBox2.getText().toString());
                                        dbReference.child(idnum).setValue(course);
                                    }
                                    if (checkBox3.isChecked()) {
                                        course.setCourse3(checkBox3.getText().toString());
                                        dbReference.child(idnum).setValue(course);
                                    }
                                    if (checkBox4.isChecked()) {
                                        course.setCourse4(checkBox4.getText().toString());
                                        dbReference.child(idnum).setValue(course);
                                    }
                                    if (checkBox5.isChecked()) {
                                        course.setCourse5(checkBox5.getText().toString());
                                        dbReference.child(idnum).setValue(course);
                                    }
                                    if (checkBox6.isChecked()) {
                                        course.setCourse6(checkBox6.getText().toString());
                                        dbReference.child(idnum).setValue(course);
                                    }
                                    if (checkBox7.isChecked()) {
                                        course.setCourse7(checkBox7.getText().toString());
                                        dbReference.child(idnum).setValue(course);
                                    }
                                    errView.setTextColor(Color.parseColor("#000000"));
                                    errView.setText("Courses successfully saved!");
                                }

                            } catch (NullPointerException e) {
                                System.out.println(FirebaseError.ERROR_USER_NOT_FOUND);
                                errView.setTextColor(Color.parseColor("#000000"));
                                errView.setText("ID is incorrect or does not exist!");

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                } else {
                    errView.setTextColor(Color.parseColor("#000000"));
                    errView.setText("Maximum courses is 5!");

                }
            }
        });
        return view2;
    }
}
