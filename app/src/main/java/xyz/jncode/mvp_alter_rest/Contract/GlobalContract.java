package xyz.jncode.mvp_alter_rest.Contract;

import java.util.List;

import xyz.jncode.mvp_alter_rest.Model.PhotosDetailResponse;

public interface GlobalContract {


    // Buat Main Activity

    interface PresenterContract {


        void consumePhotos();

        void showToast(String message);

    }


    interface MainActivityContract {

        void showProcess(boolean boolCondition);

        void populatePhotos(List<PhotosDetailResponse> generatedList);

        void generateToast(String message);


    }

    //===========================================================================================================================


    // Buat upload form
    interface UploadPresenterContract {

        void postUploadToDb(int product, int user, int qty, String date, Double amount);

    }


    interface UploadFormActivityContract {


        void showNotification(String message);

    }

    //==================================================================================

}
