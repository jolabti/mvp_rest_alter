package xyz.jncode.mvp_alter_rest.Presenter;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.jncode.mvp_alter_rest.Contract.GlobalContract;
import xyz.jncode.mvp_alter_rest.Model.PhotosDetailResponse;
import xyz.jncode.mvp_alter_rest.Model.UploadResponse;
import xyz.jncode.mvp_alter_rest.Retrofit.GetDataService;
import xyz.jncode.mvp_alter_rest.Retrofit.RetrofitClientInstance;

public class UploadPresenter implements GlobalContract.UploadPresenterContract {

    GlobalContract.UploadFormActivityContract iUploadView;

    public  UploadPresenter(GlobalContract.UploadFormActivityContract iUploadView){

        this.iUploadView = iUploadView;

    }


    @Override
    public void postUploadToDb(int product, int user, int qty, String date, Double amount) {

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

        Call<UploadResponse> call = service.retrotiftPostCourse(product,user,qty,date,amount);

        call.enqueue(new Callback<UploadResponse>() {
            @Override
            public void onResponse(Call<UploadResponse> call, Response<UploadResponse> response) {

                     UploadResponse uploadRes = response.body();

                     Log.d("trace_rsp", String.valueOf(response.code()));
                     Log.d("trace_rsp_m", response.message());

                     if(response.isSuccessful()){



                         iUploadView.showNotification(uploadRes.message);


                     }
                     else{

                         iUploadView.showNotification(uploadRes.message);

                     }

            }

            @Override
            public void onFailure(Call<UploadResponse> call, Throwable t) {

                    Log.d("trace_fail", t.getMessage());
            }
        });


    }
}
