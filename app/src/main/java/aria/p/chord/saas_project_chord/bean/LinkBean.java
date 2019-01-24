package aria.p.chord.saas_project_chord.bean;

import com.google.gson.annotations.SerializedName;

class LinkBean {
    @SerializedName("type")private String type;
    @SerializedName("image")private String image;
    @SerializedName("title")private String title;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
