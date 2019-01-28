package aria.p.chord.saas_project_chord.bean;

import com.google.gson.annotations.SerializedName;

public class InfoBean {
    @SerializedName("status")private int status;
    @SerializedName("success")private boolean success;
    @SerializedName("data")private InfoDataBean data;

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

    public InfoDataBean getData() {
        return data;
    }

    public void setData(InfoDataBean data) {
        this.data = data;
    }
}
