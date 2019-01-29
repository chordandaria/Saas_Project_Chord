package aria.p.chord.group_event_module.beans;

import com.google.gson.annotations.SerializedName;

public class EventListDataBean {
    @SerializedName("id")private int id;
    @SerializedName("title")private String title;
    @SerializedName("cover")private String cover;
    @SerializedName("start_time")private String start_time;
    @SerializedName("end_time")private String end_time;
    @SerializedName("is_published")private int is_published;
    @SerializedName("company_id")private int company_id;
    @SerializedName("reserve_values_count")private int reserve_values_count;
    @SerializedName("limit")private int limit;
    @SerializedName("expire")private int expire;

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
}
