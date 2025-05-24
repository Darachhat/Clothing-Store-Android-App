package mobileappdevelopmet.homework_3.api;

import java.util.List;

import mobileappdevelopmet.homework_3.model.Product;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductApi {
    @GET("images/products.json")
    Call<List<Product>> getProducts();
}
