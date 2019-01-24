package aria.p.chord.saas_project_chord.bean;

import com.google.gson.annotations.SerializedName;

public class LoginBean {
    @SerializedName("status")private int status;
    @SerializedName("success")private boolean success;
    @SerializedName("data")private LoginDataBean data;

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

    public LoginDataBean getData() {
        return data;
    }

    public void setData(LoginDataBean data) {
        this.data = data;
    }
}
