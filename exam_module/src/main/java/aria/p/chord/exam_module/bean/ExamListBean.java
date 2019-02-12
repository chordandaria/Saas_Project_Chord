package aria.p.chord.exam_module.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ExamListBean {
    @SerializedName("status")private int status;
    @SerializedName("success")private boolean success;
    @SerializedName("data")private ArrayList<ExamListDataBean> data;
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

    public ArrayList<ExamListDataBean> getData() {
        return data;
    }

    public void setData(ArrayList<ExamListDataBean> data) {
        this.data = data;
    }

    public PaginationBean getPagination() {
        return pagination;
    }

    public void setPagination(PaginationBean pagination) {
        this.pagination = pagination;
    }
}
