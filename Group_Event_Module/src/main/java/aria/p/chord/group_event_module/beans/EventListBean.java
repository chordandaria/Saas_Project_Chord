package aria.p.chord.group_event_module.beans;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.LinkedList;

public class EventListBean {
    @SerializedName("status")private int status;
    @SerializedName("success")private boolean success;
    @SerializedName("data")private ArrayList<EventListDataBean> data;
    @SerializedName("pagination")private PaginationBean pagination;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ArrayList<EventListDataBean> getData() {
        return data;
    }

    public void setData(ArrayList<EventListDataBean> data) {
        this.data = data;
    }

    public PaginationBean getPagination() {
        return pagination;
    }

    public void setPagination(PaginationBean pagination) {
        this.pagination = pagination;
    }
}
