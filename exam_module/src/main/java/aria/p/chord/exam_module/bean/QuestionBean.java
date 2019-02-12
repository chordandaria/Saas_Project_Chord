package aria.p.chord.exam_module.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class QuestionBean {
    @SerializedName("title")private String title;
    @SerializedName("options")private ArrayList<OptionBean> options;
    @SerializedName("type")private String type;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<OptionBean> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<OptionBean> options) {
        this.options = options;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
