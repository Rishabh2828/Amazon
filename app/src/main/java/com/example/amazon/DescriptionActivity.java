package com.example.amazon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DescriptionActivity extends AppCompatActivity {

    ImageView productimage;

    TextView productname;


    TextView price;
    TextView desc2;
    TextView desc3;
    TextView desc4;
    TextView desc5;

    Button buynow;

    FirebaseDatabase db;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        price =findViewById(R.id.textView2);
        desc2 =findViewById(R.id.textView3);
        desc3 =findViewById(R.id.textView4);
        desc4 =findViewById(R.id.textView5);
        desc5 =findViewById(R.id.textView6);
        buynow = findViewById(R.id.btn_buynow);


        productimage = findViewById(R.id.productimage);

        productname=findViewById(R.id.productname);


        Bundle extras = getIntent().getExtras();

        // Get the image resource ID and name from the extras data
        String imageResourceId = extras.getString("image_resource_id");
        String name = extras.getString("name");
        String desc_1 = extras.getString("desc1");
        String desc_2 = extras.getString("desc2");
        String desc_3 = extras.getString("desc3");
        String desc_4 = extras.getString("desc4");
        String price_of_product = extras.getString("price");


        Glide.with(this).load(imageResourceId).into(productimage);




        productname.setText(price_of_product);
        price.setText(name);
        desc2.setText(desc_1);
        desc3.setText(desc_2);
        desc4.setText(desc_3);
        desc5.setText(desc_4);


        buynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();

            }
        });




    }



    @SuppressLint("SetTextI18n")
    private void showDialog() {
        // Inflate the dialog layout
        View dialogLayout = LayoutInflater.from(this).inflate(R.layout.dialog_box, null);

        // Find the input fields and button in the layout

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) CardView buynow = dialogLayout.findViewById(R.id.card_buynow);


        TextView address = dialogLayout.findViewById(R.id.address);
        TextView mobilenumber = dialogLayout.findViewById(R.id.mobilenumber);
        TextView quantity = dialogLayout.findViewById(R.id.quanity);
        TextView text_paynow = dialogLayout.findViewById(R.id.text_paynow);













        // Create the dialog box
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogLayout);
        builder.setCancelable(true);





        // Set the "Save" button's click listener to open the new activity
        buynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String address_string = address.getText().toString();
                String mobilenumber_string = mobilenumber.getText().toString();
                String quantity_string = quantity.getText().toString();








               if(address_string.isEmpty() || mobilenumber_string.isEmpty() || quantity_string.isEmpty()){

                   Toast.makeText(DescriptionActivity.this, "Fill The Details", Toast.LENGTH_SHORT).show();
               }
               else {

                   OrderClass orderClass = new OrderClass(address_string, mobilenumber_string, quantity_string);
                   db = FirebaseDatabase.getInstance();
                   reference = db.getReference("Orders");
                   reference.child(mobilenumber_string).setValue(orderClass).addOnCompleteListener(new OnCompleteListener<Void>() {
                       @Override
                       public void onComplete(@NonNull Task<Void> task) {
                           Intent intent = new Intent(DescriptionActivity.this, MainActivity.class);
                           Toast.makeText(DescriptionActivity.this, "Order Placed", Toast.LENGTH_LONG).show();
                           startActivity(intent);
                           finish();

                       }

                   });


               }




            }
        });

        // Show the dialog box
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}