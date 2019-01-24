package aria.p.chord.saas_project_chord.bean;

import com.google.gson.annotations.SerializedName;

public class SlidersBean {
    @SerializedName("image")private String image;
    @SerializedName("title")private String title;
    @SerializedName("link")private LinkBean link;

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

    public LinkBean getLink() {
        return link;
    }

    public void setLink(LinkBean link) {
        this.link = link;
    }
}
