package xyz.jncode.mvp_alter_rest.Presenter;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.jncode.mvp_alter_rest.Contract.GlobalContract;
import xyz.jncode.mvp_alter_rest.Model.PhotosDetailResponse;
import xyz.jncode.mvp_alter_rest.Retrofit.GetDataService;
import xyz.jncode.mvp_alter_rest.Retrofit.RetrofitClientInstance;

public class MainPresenter implements GlobalContract.PresenterContract {

    GlobalContract.MainActivityContract iMainView;

    public  MainPresenter(GlobalContract.MainActivityContract iMainView){

        this.iMainView = iMainView;

    }

    @Override
    public void consumePhotos() {

        iMainView.showProcess(true);

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<PhotosDetailResponse>> call = service.getAllPhotos();
        //Call<List<PhotosDetailResponse>> call = service.getAllPhotos();


        call.enqueue(new Callback<List<PhotosDetailResponse>>() {
            @Override
            public void onResponse(Call<List<PhotosDetailResponse>> call, Response<List<PhotosDetailResponse>> response) {

                if(response.isSuccessful()){

                    Log.d("trace_resp", String.valueOf(response.code()));

                    iMainView.generateToast("Response -->" + response.code());


                    List<PhotosDetailResponse> listRoot = response.body();



                    // Kasih data list ke tampilan
                    iMainView.populatePhotos(listRoot);

                    iMainView.showProcess(false);
                }

                else{

                    iMainView.showProcess(false);
                    Log.d("trace_resp", String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<PhotosDetailResponse>> call, Throwable t) {

                iMainView.showProcess(false);
                Log.d("trace_resp", t.getMessage());
            }
        });

    }

    @Override
    public void showToast(String message) {

    }
}
