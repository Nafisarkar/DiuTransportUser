package com.example.testing.ui.Routes;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testing.BusTimeTable;
import com.example.testing.MyAdapter;
import com.example.testing.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RoutesFragment extends Fragment {

    RecyclerView recyclerView;
    DatabaseReference reference;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(com.example.testing.R.layout.fragment_routes, container, false);

        recyclerView = root.findViewById(R.id.routeList);
        reference = FirebaseDatabase.getInstance().getReference("BusTimeTable/");

        List<BusTimeTable> busTimeTableList = new ArrayList<BusTimeTable>();

        BusTimeTable bus1 = new BusTimeTable("21", "Surjamukhi", "1:00 AM", "Mirpur");
        BusTimeTable bus2 = new BusTimeTable("3", "Dolphin", "4:00 AM", "Uttara");
        BusTimeTable bus3 = new BusTimeTable("6", "Surjamukhi", "3:00 AM", "Dhanmondi");
        BusTimeTable bus4 = new BusTimeTable("12", "Dolphin", "7:00 AM", "Naraingonj");

        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        MyAdapter adapter = new MyAdapter(root.getContext(), busTimeTableList);
        recyclerView.setAdapter(adapter);

        reference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                busTimeTableList.clear();
                if (snapshot.exists()) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        for (DataSnapshot dataSnap : dataSnapshot.getChildren()){
                            BusTimeTable busTimeTable1 = dataSnap.getValue(BusTimeTable.class);
                            busTimeTableList.add(busTimeTable1);
                            Log.d("TAG", "onDataChange: " + busTimeTable1.getBusNumber());
                        }
                    }
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return root;
    }

}