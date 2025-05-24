package mobileappdevelopmet.homework_3.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import mobileappdevelopmet.homework_3.ProductDetailsActivity;
import mobileappdevelopmet.homework_3.R;
import mobileappdevelopmet.homework_3.model.Product;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    Context context;
    List<Product> productList;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView imgProduct;
        TextView name, price;

        public ProductViewHolder(View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.imgProduct);
            name = itemView.findViewById(R.id.txtName);


            itemView.setOnClickListener(v -> {
                Product product = productList.get(getAdapterPosition());
                Intent intent = new Intent(context, ProductDetailsActivity.class);
                intent.putExtra("product", product);
                context.startActivity(intent);
            });
        }
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Product p = productList.get(position);
        holder.name.setText("$" + p.getPrice());
        Picasso.get().load(p.getImage()).into(holder.imgProduct);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
