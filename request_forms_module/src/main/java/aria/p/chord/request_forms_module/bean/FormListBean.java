package aria.p.chord.request_forms_module.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class FormListBean {
    @SerializedName("status")private int status;
    @SerializedName("success")private boolean success;
    @SerializedName("data")private ArrayList<FormListDataBean> data;
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

    public ArrayList<FormListDataBean> getData() {
        return data;
    }

    public void setData(ArrayList<FormListDataBean> data) {
        this.data = data;
    }

    public PaginationBean getPagination() {
        return pagination;
    }

    public void setPagination(PaginationBean pagination) {
        this.pagination = pagination;
    }
}
