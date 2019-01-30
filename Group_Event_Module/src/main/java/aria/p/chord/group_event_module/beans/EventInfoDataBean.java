package aria.p.chord.group_event_module.beans;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.LinkedList;

public class EventInfoDataBean {
    @SerializedName("id")private int id;
    @SerializedName("title")private String title;
    @SerializedName("cover")private String cover;
    @SerializedName("start_time")private String start_time;
    @SerializedName("end_time")private String end_time;
    @SerializedName("extra") private ArrayList<EventExtraBean> extra;
    @SerializedName("is_published")private int is_published;
    @SerializedName("company_id")private int company_id;
    @SerializedName("reserve_values_count")private int reserve_values_count;
    @SerializedName("limit")private int limit;
    @SerializedName("expire")private int expire;
    @SerializedName("sign_status")private int sign_status;
    @SerializedName("is_reserve")private int is_reserve;
    @SerializedName("admin")private int admin;
    @SerializedName("cost")private int cost;
    @SerializedName("score")private String score;
    @SerializedName("description")private String description;
    @SerializedName("options")private ArrayList<OptionDataBean> options;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ArrayList<EventExtraBean> getExtra() {
        return extra;
    }

    public void setExtra(ArrayList<EventExtraBean> extra) {
        this.extra = extra;
    }

    public int getIs_published() {
        return is_published;
    }

    public void setIs_published(int is_published) {
        this.is_published = is_published;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public int getReserve_values_count() {
        return reserve_values_count;
    }

    public void setReserve_values_count(int reserve_values_count) {
        this.reserve_values_count = reserve_values_count;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public int getSign_status() {
        return sign_status;
    }

    public void setSign_status(int sign_status) {
        this.sign_status = sign_status;
    }

    public int getIs_reserve() {
        return is_reserve;
    }

    public void setIs_reserve(int is_reserve) {
        this.is_reserve = is_reserve;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<OptionDataBean> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<OptionDataBean> options) {
        this.options = options;
    }
}
