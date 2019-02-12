package aria.p.chord.exam_module.bean;

import com.google.gson.annotations.SerializedName;

public class ExamListDataBean {
    @SerializedName("id")private int id;
    @SerializedName("company_id")private int company_id;
    @SerializedName("title")private String title;
    @SerializedName("cover")private String cover;
    @SerializedName("finish_tip")private String finish_tip;
    @SerializedName("start_time")private String start_time;
    @SerializedName("end_time")private String end_time;
    @SerializedName("is_published")private int is_published;
    @SerializedName("exam_values_count")private int exam_values_count;
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

    public String getFinish_tip() {
        return finish_tip;
    }

    public void setFinish_tip(String finish_tip) {
        this.finish_tip = finish_tip;
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

    public int getIs_published() {
        return is_published;
    }

    public void setIs_published(int is_published) {
        this.is_published = is_published;
    }

    public int getExam_values_count() {
        return exam_values_count;
    }

    public void setExam_values_count(int exam_values_count) {
        this.exam_values_count = exam_values_count;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }
}
