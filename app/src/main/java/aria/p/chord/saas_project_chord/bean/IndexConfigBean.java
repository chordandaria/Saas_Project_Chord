package aria.p.chord.saas_project_chord.bean;

import com.google.gson.annotations.SerializedName;

import java.util.LinkedList;

public class IndexConfigBean {
    @SerializedName("sliders")private LinkedList<SlidersBean> sliders;
    @SerializedName("sections")private LinkedList<SectionsBean> sections;

    public LinkedList<SlidersBean> getSliders() {
        if (sliders==null)
        {
            sliders=new LinkedList<SlidersBean>();
        }
        return sliders;
    }

    public void setSliders(LinkedList<SlidersBean> sliders) {
        this.sliders = sliders;
    }

    public LinkedList<SectionsBean> getSections() {
        if (sections==null)
        {
            sections=new LinkedList<SectionsBean>();
        }
        return sections;
    }

    public void setSections(LinkedList<SectionsBean> sections) {
        this.sections = sections;
    }
}
