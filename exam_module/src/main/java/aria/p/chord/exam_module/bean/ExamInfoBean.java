package aria.p.chord.exam_module.bean;

import com.google.gson.annotations.SerializedName;

public class ExamInfoBean {
    @SerializedName("status")private int status;
    @SerializedName("success")private boolean success;
    @SerializedName("data")private ExamInfoDataBean data;

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

    public ExamInfoDataBean getData() {
        return data;
    }

    public void setData(ExamInfoDataBean data) {
        this.data = data;
    }
}
