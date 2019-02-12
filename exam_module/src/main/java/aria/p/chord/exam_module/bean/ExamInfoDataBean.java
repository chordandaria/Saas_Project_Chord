package aria.p.chord.exam_module.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ExamInfoDataBean {
    @SerializedName("id")private int id;
    @SerializedName("description")private String description;
    @SerializedName("finish_tip")private String finish_tip;
    @SerializedName("time_limit")private int time_limit;
    @SerializedName("repeatable")private boolean repeatable;
    @SerializedName("expire")private int expire;
    @SerializedName("questions")private ArrayList<QuestionBean> questions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFinish_tip() {
        return finish_tip;
    }

    public void setFinish_tip(String finish_tip) {
        this.finish_tip = finish_tip;
    }

    public int getTime_limit() {
        return time_limit;
    }

    public void setTime_limit(int time_limit) {
        this.time_limit = time_limit;
    }

    public boolean isRepeatable() {
        return repeatable;
    }

    public void setRepeatable(boolean repeatable) {
        this.repeatable = repeatable;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public ArrayList<QuestionBean> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<QuestionBean> questions) {
        this.questions = questions;
    }
}
