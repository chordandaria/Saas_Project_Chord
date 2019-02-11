package aria.p.chord.request_forms_module.bean;

import com.google.gson.annotations.SerializedName;

public class FormInfoBean {
    @SerializedName("status")private int status;
    @SerializedName("success")private boolean success;
    @SerializedName("data")private FormInfoDataBean data;

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

    public FormInfoDataBean getData() {
        return data;
    }

    public void setData(FormInfoDataBean data) {
        this.data = data;
    }
}
