package com.example.amazon.CategoryActivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.amazon.ModelClass;
import com.example.amazon.MyAdapter;
import com.example.amazon.R;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class ClothActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FirebaseFirestore database;

    ArrayList<ModelClass> list = new ArrayList<>();
    MyAdapter myAdapter = new MyAdapter(list,this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloth);

        recyclerView = findViewById(R.id.recylerCloth);
        database = FirebaseFirestore.getInstance();




        database.collection("Products")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        list.clear();
                        for (DocumentSnapshot snapshot : value.getDocuments()){

                            ModelClass modelClass = snapshot.toObject(ModelClass.class);
                            modelClass.setId(snapshot.getId());
                            list.add(modelClass);

                        }
                        myAdapter.notifyDataSetChanged();

                    }
                });


        recyclerView.setAdapter(myAdapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

        recyclerView.setLayoutManager(gridLayoutManager);






    }


    // calling on create option menu
    // layout to inflate our menu file.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // below line is to get our inflater
        MenuInflater inflater = getMenuInflater();

        // inside inflater we are inflating our menu file.
        inflater.inflate(R.menu.search_menu, menu);

        // below line is to get our menu item.
        MenuItem searchItem = menu.findItem(R.id.actionSearch);

        // getting search view of our item.
        SearchView searchView = (SearchView) searchItem.getActionView();

        // below line is to call set on query text listener method.
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // inside on query text change method we are
                // calling a method to filter our recycler view.
                filter(newText);
                return false;
            }
        });
        return true;
    }

    private void filter(String text) {
        // creating a new array list to filter our data.
        ArrayList<ModelClass> filteredlist = new ArrayList<ModelClass>();

        // running a for loop to compare elements.
        for (ModelClass item : list) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.getText().toLowerCase().contains(text.toLowerCase())) {
                // if the item is matched we are
                // adding it to our filtered list.
                filteredlist.add(item);
            }
        }
        if (filteredlist.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show();
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            myAdapter.filterList(filteredlist);
        }
    }


    }
