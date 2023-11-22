package com.example.testing.ui.slideshow;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testing.BusTimeTable;
import com.example.testing.MyAdapter;
import com.example.testing.R;
import com.example.testing.databinding.FragmentSlideshowBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SlideshowFragment extends Fragment {
    RecyclerView recyclerView;
    DatabaseReference reference;
    RadioGroup radioGroupd;
    private FragmentSlideshowBinding binding;
    Button ShowButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        radioGroupd = root.findViewById(R.id.radioGroup);
        recyclerView = root.findViewById(R.id.recyclerViewshow);

        ShowButton = root.findViewById(R.id.buttonShowBTN);
        reference = FirebaseDatabase.getInstance().getReference("BusTimeTable/");
        List<BusTimeTable> busTimeTableList = new ArrayList<BusTimeTable>();


        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        MyAdapter adapter = new MyAdapter(root.getContext(), busTimeTableList);
        recyclerView.setAdapter(adapter);

        String[] items = new String[]{"All", "7:00-10:00", "11:00-12:00", "1:00-3:00", "3:00-5:00", "5:00-7:00"};
        Spinner dropdown = root.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(root.getContext(), android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter1);

        reference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                busTimeTableList.clear();
                if (snapshot.exists()) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        for (DataSnapshot dataSnap : dataSnapshot.getChildren()) {
                            BusTimeTable busTimeTable1 = dataSnap.getValue(BusTimeTable.class);
                            if (busTimeTable1.getBusRoute().equals("Mirpur")) {
                                busTimeTableList.add(busTimeTable1);
                            }
                        }
                    }
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        radioGroupd.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = root.findViewById(checkedId);

                if (radioButton.getText().equals("Mirpur")) {
                    reference.addValueEventListener(new ValueEventListener() {
                        @SuppressLint("NotifyDataSetChanged")
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            busTimeTableList.clear();
                            if (snapshot.exists()) {
                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                    for (DataSnapshot dataSnap : dataSnapshot.getChildren()) {
                                        BusTimeTable busTimeTable1 = dataSnap.getValue(BusTimeTable.class);
                                        if (busTimeTable1.getBusRoute().equals("Mirpur")) {
                                            busTimeTableList.add(busTimeTable1);
                                        }
                                    }
                                }
                                adapter.notifyDataSetChanged();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                } else if (radioButton.getText().equals("Dhanmondi")) {
                    reference.addValueEventListener(new ValueEventListener() {
                        @SuppressLint("NotifyDataSetChanged")
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            busTimeTableList.clear();
                            if (snapshot.exists()) {
                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                    for (DataSnapshot dataSnap : dataSnapshot.getChildren()) {
                                        BusTimeTable busTimeTable1 = dataSnap.getValue(BusTimeTable.class);
                                        if (busTimeTable1.getBusRoute().equals("Dhanmondi")) {
                                            busTimeTableList.add(busTimeTable1);
                                        }
                                    }
                                }
                                adapter.notifyDataSetChanged();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                } else if (radioButton.getText().equals("Uttara")) {
                    reference.addValueEventListener(new ValueEventListener() {
                        @SuppressLint("NotifyDataSetChanged")
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            busTimeTableList.clear();
                            if (snapshot.exists()) {
                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                    for (DataSnapshot dataSnap : dataSnapshot.getChildren()) {
                                        BusTimeTable busTimeTable1 = dataSnap.getValue(BusTimeTable.class);
                                        if (busTimeTable1.getBusRoute().equals("Uttara")) {
                                            busTimeTableList.add(busTimeTable1);
                                        }
                                    }
                                }
                                adapter.notifyDataSetChanged();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                } else if (radioButton.getText().equals("Naraingonj")) {
                    reference.addValueEventListener(new ValueEventListener() {
                        @SuppressLint("NotifyDataSetChanged")
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            busTimeTableList.clear();
                            if (snapshot.exists()) {
                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                    for (DataSnapshot dataSnap : dataSnapshot.getChildren()) {
                                        BusTimeTable busTimeTable1 = dataSnap.getValue(BusTimeTable.class);
                                        if (busTimeTable1.getBusRoute().equals("Naraingonj")) {
                                            busTimeTableList.add(busTimeTable1);
                                        }
                                    }
                                }
                                adapter.notifyDataSetChanged();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                } else {
                    busTimeTableList.clear();
                    adapter.notifyDataSetChanged();
                }

            }
        });
        ShowButton.setOnClickListener(v -> {
            String text = dropdown.getSelectedItem().toString();
            if (text.equals("All")) {
                ValueEventListener valueEventListener = reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        busTimeTableList.clear();
                        if (snapshot.exists()) {
                            radioGroupd = root.findViewById(R.id.radioGroup);
                            int checkedId = radioGroupd.getCheckedRadioButtonId();
                            RadioButton radioButton = root.findViewById(checkedId);


                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                for (DataSnapshot dataSnap : dataSnapshot.getChildren()) {
                                    BusTimeTable busTimeTable1 = dataSnap.getValue(BusTimeTable.class);
                                    if(busTimeTable1.getBusRoute().equals(radioButton.getText().toString())){
                                        busTimeTableList.add(busTimeTable1);
                                    }
                                }
                            }
                            adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }else if(text.equals("7:00-10:00")){
                ValueEventListener valueEventListener = reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        radioGroupd = root.findViewById(R.id.radioGroup);
                        int checkedId = radioGroupd.getCheckedRadioButtonId();
                        RadioButton radioButton = root.findViewById(checkedId);

                        busTimeTableList.clear();
                        if (snapshot.exists()) {
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                for (DataSnapshot dataSnap : dataSnapshot.getChildren()) {
                                    BusTimeTable busTimeTable1 = dataSnap.getValue(BusTimeTable.class);
                                    if((busTimeTable1.getDepartureTime().equals("7:00 AM") || busTimeTable1.getDepartureTime().equals("8:00 AM") || busTimeTable1.getDepartureTime().equals("9:00 AM") || busTimeTable1.getDepartureTime().equals("10:00 AM"))&&busTimeTable1.getBusRoute().equals(radioButton.getText().toString())){
                                        busTimeTableList.add(busTimeTable1);
                                    }
                                }
                            }
                            adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }else if (text.equals("11:00-12:00")){
                ValueEventListener valueEventListener = reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        radioGroupd = root.findViewById(R.id.radioGroup);
                        int checkedId = radioGroupd.getCheckedRadioButtonId();
                        RadioButton radioButton = root.findViewById(checkedId);

                        busTimeTableList.clear();
                        if (snapshot.exists()) {
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                for (DataSnapshot dataSnap : dataSnapshot.getChildren()) {
                                    BusTimeTable busTimeTable1 = dataSnap.getValue(BusTimeTable.class);
                                    if((busTimeTable1.getDepartureTime().equals("11:00 AM") || busTimeTable1.getDepartureTime().equals("12:00 AM"))&&busTimeTable1.getBusRoute().equals(radioButton.getText().toString())){
                                        busTimeTableList.add(busTimeTable1);
                                    }
                                }
                            }
                            adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }else if(text.equals("1:00-3:00")){
                ValueEventListener valueEventListener = reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        radioGroupd = root.findViewById(R.id.radioGroup);
                        int checkedId = radioGroupd.getCheckedRadioButtonId();
                        RadioButton radioButton = root.findViewById(checkedId);

                        busTimeTableList.clear();
                        if (snapshot.exists()) {
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                for (DataSnapshot dataSnap : dataSnapshot.getChildren()) {
                                    BusTimeTable busTimeTable1 = dataSnap.getValue(BusTimeTable.class);
                                    if((busTimeTable1.getDepartureTime().equals("1:00 AM") || busTimeTable1.getDepartureTime().equals("2:00 AM") || busTimeTable1.getDepartureTime().equals("3:00 AM"))&&busTimeTable1.getBusRoute().equals(radioButton.getText().toString())){
                                        busTimeTableList.add(busTimeTable1);
                                    }
                                }
                            }
                            adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }else if(text.equals("3:00-5:00")){
                ValueEventListener valueEventListener = reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        radioGroupd = root.findViewById(R.id.radioGroup);
                        int checkedId = radioGroupd.getCheckedRadioButtonId();
                        RadioButton radioButton = root.findViewById(checkedId);

                        busTimeTableList.clear();
                        if (snapshot.exists()) {
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                for (DataSnapshot dataSnap : dataSnapshot.getChildren()) {
                                    BusTimeTable busTimeTable1 = dataSnap.getValue(BusTimeTable.class);
                                    if((busTimeTable1.getDepartureTime().equals("3:00 AM") || busTimeTable1.getDepartureTime().equals("4:00 AM") || busTimeTable1.getDepartureTime().equals("5:00 AM"))&&busTimeTable1.getBusRoute().equals(radioButton.getText().toString())){
                                        busTimeTableList.add(busTimeTable1);
                                    }
                                }
                            }
                            adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }else if(text.equals("5:00-7:00")){
                ValueEventListener valueEventListener = reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        radioGroupd = root.findViewById(R.id.radioGroup);
                        int checkedId = radioGroupd.getCheckedRadioButtonId();
                        RadioButton radioButton = root.findViewById(checkedId);

                        busTimeTableList.clear();
                        if (snapshot.exists()) {
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                for (DataSnapshot dataSnap : dataSnapshot.getChildren()) {
                                    BusTimeTable busTimeTable1 = dataSnap.getValue(BusTimeTable.class);
                                    if((busTimeTable1.getDepartureTime().equals("5:00 AM") || busTimeTable1.getDepartureTime().equals("6:00 AM") || busTimeTable1.getDepartureTime().equals("7:00 AM"))&&busTimeTable1.getBusRoute().equals(radioButton.getText().toString())){
                                        busTimeTableList.add(busTimeTable1);
                                    }
                                }
                            }
                            adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });


        return root;
    }

}