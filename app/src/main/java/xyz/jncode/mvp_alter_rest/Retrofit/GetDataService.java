package xyz.jncode.mvp_alter_rest.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

import xyz.jncode.mvp_alter_rest.Config.Link;
import xyz.jncode.mvp_alter_rest.Model.PhotosDetailResponse;

public interface GetDataService {

    @GET(Link.BASE_APIKEY)
    Call<List<PhotosDetailResponse>> getAllPhotos();
}
