package xyz.jncode.mvp_alter_rest.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

import retrofit2.http.POST;
import xyz.jncode.mvp_alter_rest.Config.Link;
import xyz.jncode.mvp_alter_rest.Model.PhotosDetailResponse;
import xyz.jncode.mvp_alter_rest.Model.UploadResponse;

public interface GetDataService {

    @GET(Link.BASE_APIKEY)
    Call<List<PhotosDetailResponse>> getAllPhotos();





    @GET("todos")
    Call<List<PhotosDetailResponse>> getAllTodos();


    @POST("addcourse")
    @FormUrlEncoded
    Call<UploadResponse> retrotiftPostCourse(

                    @Field("trx_product_fk") int product,
                    @Field("trx_user_fk") int user,
                    @Field("trx_qty") int qty,
                    @Field("trx_date") String date,
                    @Field("trx_amount") double amount
            );


} // last curly bracket


