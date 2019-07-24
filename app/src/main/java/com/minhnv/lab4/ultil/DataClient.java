package com.minhnv.lab4.ultil;




import com.minhnv.lab4.model.Categoryy;
import com.minhnv.lab4.model2.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface DataClient {


   // type:list_item
    //cat_type:video↵↵1
    //page:1
    //limit:20
   @GET("wp-json/wp/v2/categories")
   Call<List<Categoryy>> getCategory(@Query("page") String page,
                                     @Query("per_page") String per_page

   );

   @GET("wp-json/wp/v2/posts")
   Call<List<Post>> getPost(@Query("category") String category,
                                   @Query("per_page") String per_page,
                                   @Query("paging") String paging
   );

}
