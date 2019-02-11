package aria.p.chord.request_forms_module.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class FormInfoDataBean {
    @SerializedName("id") private int id;
    @SerializedName("company_id") private int company_id;
    @SerializedName("title") private String title;
    @SerializedName("cover") private String cover;
    @SerializedName("start_time") private String start_time;
    @SerializedName("end_time") private String end_time;
    @SerializedName("description") private String description;
    @SerializedName("controls") private ArrayList<FormControlsBean> controls;
    @SerializedName("is_published")private int is_published;
    @SerializedName("created_at")private String created_at;
    @SerializedName("updated_at")private String updated_at;
    @SerializedName("hot")private String hot;
    @SerializedName("form_values_count")private int form_values_count;
    @SerializedName("expire")private int expire;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<FormControlsBean> getControls() {
        return controls;
    }

    public void setControls(ArrayList<FormControlsBean> controls) {
        this.controls = controls;
    }

    public int getIs_published() {
        return is_published;
    }

    public void setIs_published(int is_published) {
        this.is_published = is_published;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getHot() {
        return hot;
    }

    public void setHot(String hot) {
        this.hot = hot;
    }

    public int getForm_values_count() {
        return form_values_count;
    }

    public void setForm_values_count(int form_values_count) {
        this.form_values_count = form_values_count;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }
}
