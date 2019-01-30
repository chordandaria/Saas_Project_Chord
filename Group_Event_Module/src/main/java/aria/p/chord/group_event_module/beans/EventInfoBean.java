package aria.p.chord.group_event_module.beans;

import com.google.gson.annotations.SerializedName;

public class EventInfoBean {
    @SerializedName("status")private int status;
    @SerializedName("success")private boolean success;
    @SerializedName("data")private EventInfoDataBean data;

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

    public EventInfoDataBean getData() {
        return data;
    }

    public void setData(EventInfoDataBean data) {
        this.data = data;
    }
}
