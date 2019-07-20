package xyz.jncode.mvp_alter_rest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import xyz.jncode.mvp_alter_rest.Contract.GlobalContract;
import xyz.jncode.mvp_alter_rest.Presenter.UploadPresenter;

public class UploadForm extends AppCompatActivity implements GlobalContract.UploadFormActivityContract {


    EditText edProductFK;
    Button btn;

    UploadPresenter uploadPresenter=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_form);
        uploadPresenter = new UploadPresenter(UploadForm.this);


        edProductFK = findViewById(R.id.product_fk);
        btn = findViewById(R.id.btn_done);



        uploadPresenter.postUploadToDb(1,1,1,"1994-08-23",100000.0);




    }

    @Override
    public void showNotification(String message) {


        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();

    }
}
