package xyz.jncode.mvp_alter_rest.Model;

import com.google.gson.annotations.SerializedName;

public class PhotosDetailResponse {

    /*
    *
    *   {
            "albumId": 1,
            "id": 1,
            "title": "accusamus beatae ad facilis cum similique qui sunt",
            "url": "https://via.placeholder.com/600/92c952",
            "thumbnailUrl": "https://via.placeholder.com/150/92c952"
        }
    *
    *
    * */
    @SerializedName("albumId")
    public int albumId;

    @SerializedName("id")
    public int id;


    @SerializedName("title")
    public String title;

    @SerializedName("url")
    public String url;

    @SerializedName("thumbnailUrl")
    public String thumbnailUrl;



}
