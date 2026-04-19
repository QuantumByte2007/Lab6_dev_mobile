package com.example.pizzarecipes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pizzarecipes.R;
import com.example.pizzarecipes.classes.Produit;

import java.util.List;

public class PizzaAdapter extends BaseAdapter {

    private List<Produit> produits;
    private LayoutInflater inflater;

    public PizzaAdapter(Context context, List<Produit> produits) {
        this.produits = produits;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return produits.size();
    }

    @Override
    public Object getItem(int position) {
        return produits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return produits.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_pizza, parent, false);
        }

        ImageView imgPizza = convertView.findViewById(R.id.img_pizza);
        TextView txtNom = convertView.findViewById(R.id.txt_nom);
        TextView txtNbrIngredients = convertView.findViewById(R.id.txt_nbr_ingredients);
        TextView txtDuree = convertView.findViewById(R.id.txt_duree);

        Produit p = produits.get(position);

        imgPizza.setImageResource(p.getPhoto());
        txtNom.setText(p.getNom());
        txtNbrIngredients.setText("Nombre d'ingrédients : " + p.getNbrIngredients());
        txtDuree.setText("Durée : " + p.getDuree() + " min");

        return convertView;
    }
}
