package com.example.amazon;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.amazon.CategoryActivities.BeautyProductActivity;
import com.example.amazon.CategoryActivities.BooksActivity;
import com.example.amazon.CategoryActivities.ClothActivity;
import com.example.amazon.CategoryActivities.ElectronicsActivity;
import com.example.amazon.CategoryActivities.FurnitureActivity;
import com.example.amazon.CategoryActivities.GroceriesActivity;
import com.example.amazon.CategoryActivities.PharamacyActivity;
import com.example.amazon.CategoryActivities.ToysActivity;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CardView cardViewcloth;
    CardView cardViewElectronics;
    CardView cardViewHome;
    CardView cardViewBeauty;
    CardView cardViewPharamacy;
    CardView cardViewGrocery;
    CardView cardViewToys;
    CardView cardViewBooks;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardViewcloth =findViewById(R.id.clothingCard);
        cardViewElectronics = findViewById(R.id.electronicsCard);
        cardViewHome = findViewById(R.id.homeCard);
        cardViewBeauty = findViewById(R.id.beautyCard);
        cardViewPharamacy = findViewById(R.id.pharmacyCard);
        cardViewGrocery = findViewById(R.id.groceryCard);
        cardViewToys = findViewById(R.id.toyCard);
        cardViewBooks = findViewById(R.id.booksCard);


        cardViewcloth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cloth = new Intent(MainActivity.this, ClothActivity.class);
                startActivity(cloth);
            }
        });


        cardViewElectronics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cloth = new Intent(MainActivity.this, ElectronicsActivity.class);
                startActivity(cloth);
            }
        });


        cardViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cloth = new Intent(MainActivity.this, FurnitureActivity.class);
                startActivity(cloth);
            }
        });



        cardViewBeauty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cloth = new Intent(MainActivity.this, BeautyProductActivity.class);
                startActivity(cloth);
            }
        });


        cardViewPharamacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cloth = new Intent(MainActivity.this, PharamacyActivity.class);
                startActivity(cloth);
            }
        });


        cardViewGrocery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cloth = new Intent(MainActivity.this, GroceriesActivity.class);
                startActivity(cloth);
            }
        });

        cardViewToys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cloth = new Intent(MainActivity.this, ToysActivity.class);
                startActivity(cloth);
            }
        });

        cardViewBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cloth = new Intent(MainActivity.this, BooksActivity.class);
                startActivity(cloth);
            }
        });





    }
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

                return false;
            }
        });
        return true;
    }




}







