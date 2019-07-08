package xyz.jncode.mvp_alter_rest.Contract;

import java.util.List;

import xyz.jncode.mvp_alter_rest.Model.PhotosDetailResponse;

public interface GlobalContract {

    interface PresenterContract{


                void consumePhotos();
                void showToast(String message);

    }

    interface MainActivityContract{

                void showProcess(boolean boolCondition);

                void populatePhotos(List<PhotosDetailResponse> generatedList);

                void generateToast(String message);


    }
}
