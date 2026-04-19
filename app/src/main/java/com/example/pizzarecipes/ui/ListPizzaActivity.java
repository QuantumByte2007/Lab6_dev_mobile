package com.example.pizzarecipes.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pizzarecipes.R;
import com.example.pizzarecipes.adapter.PizzaAdapter;
import com.example.pizzarecipes.classes.Produit;
import com.example.pizzarecipes.service.ProduitService;

public class ListPizzaActivity extends AppCompatActivity {
    private ProduitService ps;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pizza);

        ps = new ProduitService();
        listView = findViewById(R.id.list_view);

        // Données avec le bon format pour le constructeur (duree est un String)
        ps.create(new Produit("BARBECUED CHICKEN PIZZA", 3, R.drawable.pizza1, "35 min", "- 2 boneless skinless chicken breast halves (6 ounces each)\n- 1/4 teaspoon pepper\n- 1 cup barbecue sauce, divided\n- 1 tube (13.8 ounces) refrigerated pizza crust\n- 2 teaspoons olive oil\n-2 cups shredded Gouda cheese\n-1 small red onion, halved and thinly sliced\n-1/4 cup minced fresh cilantro", "So fast and so easy with refrigerated pizza crust, these saucy, smoky pizzas make quick fans with their hot-off-the-grill, rustic flavor.", "STEP 1:\n\n Sprinkle chicken with pepper; place on an oiled grill rack over medium heat."));
        ps.create(new Produit("BRUSCHETTA PIZZA", 5, R.drawable.pizza2, "35 min", "- 1/2 pound reduced-fat bulk pork sausage\n- 1 prebaked 12-inch pizza crust\n- 1 package (6 ounces) sliced turkey pepperoni", "You might need a knife and fork for this hearty pizza! Loaded with Italian flavor and plenty of fresh tomatoes.", "STEP 1:\n\n In a small skillet, cook sausage over medium heat until no longer pink; drain."));
        ps.create(new Produit("SPINACH PIZZA", 2, R.drawable.pizza3, "25 min", "- 1 package (6-1/2 ounces) pizza crust mix\n- 1/2 cup Alfredo sauce\n- 2 medium tomatoes", "This tasty pizza is so easy to prepare. My family, including my young daughter, loves it.", "STEP 1:\n\n Prepare pizza dough according to package directions."));
        ps.create(new Produit("DEEP-DISH SAUSAGE PIZZA", 8, R.drawable.pizza4, "45 min", "- 1 package (1/4 ounce) active dry yeast\n- 2/3 cup warm water (110° to 115°)", "My Grandma made the tastiest snacks for us when we stayed the night at her farm.", "STEP 1:\n\n In a mixing bowl, dissolve yeast in water. Add 1 cup flour, oil and seasonings."));
        ps.create(new Produit("HOMEMADE PIZZA", 4, R.drawable.pizza5, "50 min", "- 1 package (1/4 ounce) active dry yeast\n- 1 teaspoon sugar\n- 1-1/4 cups warm water", "This recipe is a hearty, zesty main dish with a crisp, golden crust.", "STEP 1:\n\n In large bowl, dissolve yeast and sugar in water; let stand for 5 minutes."));

        PizzaAdapter adapter = new PizzaAdapter(this, ps.findAll());
        listView.setAdapter(adapter);

        // Étape 11 : Redirection vers DetailsPizzaActivity au clic
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Produit p = ps.findAll().get(position);
            Intent intent = new Intent(ListPizzaActivity.this, DetailsPizzaActivity.class);
            intent.putExtra("pizza", p);
            startActivity(intent);
        });
    }
}
