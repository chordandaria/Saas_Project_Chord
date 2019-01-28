package aria.p.chord.saas_project_chord.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.LinkedList;

public class IndexConfigBean {
    @SerializedName("sliders")private ArrayList<SlidersBean> sliders;
    @SerializedName("sections")private ArrayList<SectionsBean> sections;

    public ArrayList<SlidersBean> getSliders() {
        return sliders;
    }

    public void setSliders(ArrayList<SlidersBean> sliders) {
        this.sliders = sliders;
    }

    public ArrayList<SectionsBean> getSections() {
        return sections;
    }

    public void setSections(ArrayList<SectionsBean> sections) {
        this.sections = sections;
    }
}
