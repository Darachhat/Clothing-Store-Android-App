package mobileappdevelopmet.homework_3;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import mobileappdevelopmet.homework_3.model.Product;

public class ProductDetailsActivity extends AppCompatActivity {
    ImageView imgProduct;
    TextView name, price, rating, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        imgProduct = findViewById(R.id.imgProductDetail);
        name = findViewById(R.id.txtNameDetail);
        price = findViewById(R.id.txtPriceDetail);
        rating = findViewById(R.id.txtRatingDetail);
        description = findViewById(R.id.txtDescriptionDetail);

        Product product = (Product) getIntent().getSerializableExtra("product");

        if (product != null) {
            name.setText(product.getName());
            price.setText("$" + product.getPrice());
            rating.setText("Rating: " + product.getRating());
            description.setText(product.getDescription());
            Picasso.get().load(product.getImage()).into(imgProduct);
        }
    }
}
