package xyz.jncode.mvp_alter_rest;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.jncode.mvp_alter_rest.Adapter.CustomAdapter;
import xyz.jncode.mvp_alter_rest.Contract.GlobalContract;
import xyz.jncode.mvp_alter_rest.Model.PhotosDetailResponse;
import xyz.jncode.mvp_alter_rest.Presenter.MainPresenter;
import xyz.jncode.mvp_alter_rest.Retrofit.GetDataService;
import xyz.jncode.mvp_alter_rest.Retrofit.RetrofitClientInstance;

public class MainActivity extends AppCompatActivity implements GlobalContract.MainActivityContract {

    ProgressDialog progressDialog;

    RecyclerView rvPhotos;

    CustomAdapter adapter;


    MainPresenter mainPresenter=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        rvPhotos = findViewById(R.id.recyclewview_photos_id);

        progressDialog = new ProgressDialog(this);

        mainPresenter = new MainPresenter(MainActivity.this);

        mainPresenter.consumePhotos();
    }

    @Override
    public void showProcess(boolean boolCondition) {


            progressDialog.setTitle("Warning");
            progressDialog.setMessage("Processing the api ...");

            if(boolCondition){

                    progressDialog.show();

            }
            else if(!boolCondition){

                   progressDialog.dismiss();
            }

    }

    @Override
    public void populatePhotos(List<PhotosDetailResponse> generatedList) {

                adapter = new CustomAdapter(MainActivity.this, generatedList);

                Log.d("trace_data_index0", generatedList.get(0).title);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL, false);

                rvPhotos.setLayoutManager(layoutManager);
                rvPhotos.setAdapter(adapter);



    }

    @Override
    public void generateToast(String message) {

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }
}
