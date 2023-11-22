package com.example.testing.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.testing.R;
import com.example.testing.databinding.FragmentHomeBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeFragment extends Fragment {
    TextView availTV, deptTV, busforTV, mirpurtTV, dhanmonditTV, uttaratTV, naratTV, mirpurnTV, dhanmondinTV, uttaranTV, naranTV;
    CardView availcardView;
    DatabaseReference dbRefAbil, dbRefDep, dbRefBusfor, dbRefMirpurtypebil, dbrefBusNumber;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        availTV = root.findViewById(R.id.availabilityTV);

        availcardView = root.findViewById(R.id.availabilitycardView);
        busforTV = root.findViewById(R.id.availableforTV);
        deptTV = root.findViewById(R.id.deptimeTV);

        mirpurtTV = root.findViewById(R.id.mirpurtypeTV);
        dhanmonditTV = root.findViewById(R.id.dhanmonditypeTV);
        uttaratTV = root.findViewById(R.id.uttaratypeTV);
        naratTV = root.findViewById(R.id.naratypeTV);

        mirpurnTV = root.findViewById(R.id.mirpurnumberTV);
        dhanmondinTV = root.findViewById(R.id.dhanmondinumberTV);
        uttaranTV = root.findViewById(R.id.uttaranumberTV);
        naranTV = root.findViewById(R.id.naranumberTV);


        dbRefAbil = FirebaseDatabase.getInstance().getReference("Availability");
        dbRefAbil.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                if (value.equals("1")) {
                    availTV.setText("Available");
                    availcardView.setCardBackgroundColor(ContextCompat.getColor(root.getContext(), R.color.green_300));
                } else {
                    availTV.setText("Not Available");
                    availcardView.setCardBackgroundColor(ContextCompat.getColor(root.getContext(), R.color.red_500));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        dbRefDep = FirebaseDatabase.getInstance().getReference("Departure");
        dbRefDep.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                deptTV.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        dbRefBusfor = FirebaseDatabase.getInstance().getReference("BusFor");
        dbRefBusfor.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                busforTV.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        dbRefMirpurtypebil = FirebaseDatabase.getInstance().getReference("MirpurType");
        dbRefMirpurtypebil.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                mirpurtTV.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        dbRefMirpurtypebil = FirebaseDatabase.getInstance().getReference("DhanmondiType");
        dbRefMirpurtypebil.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                dhanmonditTV.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        dbRefMirpurtypebil = FirebaseDatabase.getInstance().getReference("UttaraType");
        dbRefMirpurtypebil.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                uttaratTV.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        dbRefMirpurtypebil = FirebaseDatabase.getInstance().getReference("NarayanganjType");
        dbRefMirpurtypebil.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                naratTV.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        dbrefBusNumber = FirebaseDatabase.getInstance().getReference("MirpurBusNumber");
        dbrefBusNumber.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                mirpurnTV.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        dbrefBusNumber = FirebaseDatabase.getInstance().getReference("DhanmondiBusNumber");
        dbrefBusNumber.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                dhanmondinTV.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        dbrefBusNumber = FirebaseDatabase.getInstance().getReference("UttaraBusNumber");
        dbrefBusNumber.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                uttaranTV.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        dbrefBusNumber = FirebaseDatabase.getInstance().getReference("NaraingonjBusNumber");
        dbrefBusNumber.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                naranTV.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return root;
    }
}