package xyz.jncode.mvp_alter_rest.Model;

import com.google.gson.annotations.SerializedName;

public class Sources {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;


}
