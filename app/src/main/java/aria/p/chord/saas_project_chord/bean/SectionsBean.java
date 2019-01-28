package aria.p.chord.saas_project_chord.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.LinkedList;

public class SectionsBean {
    @SerializedName("type")private String type;
    @SerializedName("title")private String title;
    @SerializedName("icons")private ArrayList<IconsBean> icons;
    @SerializedName("image")private String image;
    @SerializedName("link")private LinkBean link;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<IconsBean> getIcons() {
        return icons;
    }

    public void setIcons(ArrayList<IconsBean> icons) {
        this.icons = icons;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LinkBean getLink() {
        return link;
    }

    public void setLink(LinkBean link) {
        this.link = link;
    }
}
