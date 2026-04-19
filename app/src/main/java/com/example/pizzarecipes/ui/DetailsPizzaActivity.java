package com.example.pizzarecipes.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pizzarecipes.R;
import com.example.pizzarecipes.classes.Produit;

public class DetailsPizzaActivity extends AppCompatActivity {
    private ImageView imgDetails;
    private TextView txtNom, txtDesc, txtIngred, txtPrep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_pizza);

        imgDetails = findViewById(R.id.img_details);
        txtNom = findViewById(R.id.txt_nom_details);
        txtDesc = findViewById(R.id.txt_desc_details);
        txtIngred = findViewById(R.id.txt_ingred_details);
        txtPrep = findViewById(R.id.txt_prep_details);

        Produit p = (Produit) getIntent().getSerializableExtra("pizza");

        if (p != null) {
            imgDetails.setImageResource(p.getPhoto());
            txtNom.setText(p.getNom());
            txtDesc.setText(p.getDescription());
            txtIngred.setText(p.getDetailsIngred());
            txtPrep.setText(p.getPreparation());
        }
    }
}
