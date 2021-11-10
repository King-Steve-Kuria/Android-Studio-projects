package com.gakubia.assignment5;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public class Fragment3 extends Fragment {
    private Fees fees;
    EditText feeView, idfeesView;
    TextView feeErrorView, expectedFeeView;
    DatabaseReference databaseReference, dbaseReference;
    Button feesBtn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view3 = inflater.inflate(R.layout.fragment3_layout, container, false);
        feeView = view3.findViewById(R.id.feeView);
        idfeesView = view3.findViewById(R.id.idfeesView);
        feeErrorView = view3.findViewById(R.id.feeErrorView);
        expectedFeeView = view3.findViewById(R.id.expectedFeeView);
        feesBtn=view3.findViewById(R.id.feesBtn);
        fees = new Fees();

        databaseReference = FirebaseDatabase.getInstance().getReference();
        dbaseReference = FirebaseDatabase.getInstance().getReference().child("Fees");

        feesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String studentId = idfeesView.getText().toString().trim();
                databaseReference = FirebaseDatabase.getInstance().getReference().child("Student").child(studentId);
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        try {
                            String studentNum = snapshot.child("id").getValue().toString();
                            if (studentId.equals(studentNum)) {
                                String id = idfeesView.getText().toString();
                                dbaseReference.child(id).setValue(fees);
                                fees.setPaid(feeView.getText().toString());
                                fees.setExpectedAmount("100000");
                                expectedFeeView.setTextColor(Color.parseColor("#000000"));
                                expectedFeeView.setText("Expected fee is ksh 100,000");

                                double number;
                                number=Double.parseDouble(feeView.getText().toString());
                                double fee = 100000;
                                if (number<fee){
                                    feeErrorView.setTextColor(Color.parseColor("#000000"));
                                    feeErrorView.setText("Not cleared. You have fee balances...");
                                    fees.setStatus("Not Cleared");
                                }else {
                                    feeErrorView.setTextColor(Color.parseColor("#000000"));
                                    feeErrorView.setText("You are cleared!");
                                    fees.setStatus("Cleared");
                                }
                            }

                        } catch (NullPointerException e) {
                            System.out.println(FirebaseError.ERROR_USER_NOT_FOUND);
                            feeErrorView.setTextColor(Color.parseColor("#F000000"));
                            feeErrorView.setText("ID does not exist!");

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
        return view3;
    }
}
