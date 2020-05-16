package com.adpth.bottomsheet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Modal> listModal;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listModal = new ArrayList<>();
        listModal.add(new Modal("Picture 01","4.31MB",R.drawable.picture_01));
        listModal.add(new Modal("picture 02","5.73MB",R.drawable.picture_02));
        listModal.add(new Modal("Picture 03","4.95MB",R.drawable.picture_03));
        listModal.add(new Modal("Picture 04","5.03MB",R.drawable.picture_04));
        listModal.add(new Modal("Picture 05","2.33MB",R.drawable.picture_05));
        listModal.add(new Modal("Picture 06","2.75MB",R.drawable.picture_06));
        listModal.add(new Modal("Picture 07","3.45MB",R.drawable.picture_07));
        listModal.add(new Modal("Picture 08","4.32MB",R.drawable.picture_08));


        recyclerView = findViewById(R.id.RecyclerView);
        MDAdapter mAdapter = new MDAdapter(this,listModal);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(mAdapter);

    }

}
