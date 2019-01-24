package aria.p.chord.saas_project_chord.bean;

import com.google.gson.annotations.SerializedName;

public class IndexBean {
    @SerializedName("status")private int status;
    @SerializedName("success")private boolean success;
    @SerializedName(value = "data",alternate = "error")private IndexDataBean data;

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

    public IndexDataBean getData() {
        return data;
    }

    public void setData(IndexDataBean data) {
        this.data = data;
    }
}
