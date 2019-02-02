package aria.p.chord.group_event_module.beans;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class OptionDataBean {
    @SerializedName("title")private String title;
    @SerializedName("type")private String type;
    @SerializedName("extra")private String extra;
    @SerializedName("required")private boolean required;
    @SerializedName("options")private ArrayList<String> options;
    @SerializedName("otherOption")private boolean otherOption;
    @SerializedName("more")private String more;
    @SerializedName("start_time")private String start_time;
    @SerializedName("end_time")private String end_time;
    @SerializedName("start_date")private String start_date;
    @SerializedName("end_date")private String end_date;
    @SerializedName("dateWay")private String dateWay;
    private ArrayList<String> value=new ArrayList<String>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public boolean isOtherOption() {
        return otherOption;
    }

    public void setOtherOption(boolean otherOption) {
        this.otherOption = otherOption;
    }

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getDateWay() {
        return dateWay;
    }

    public void setDateWay(String dateWay) {
        this.dateWay = dateWay;
    }

    public ArrayList<String> getValue() {
        return value;
    }

    public void setValue(ArrayList<String> value) {
        this.value = value;
    }
}
