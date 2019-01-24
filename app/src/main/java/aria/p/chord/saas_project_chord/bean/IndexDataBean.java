package aria.p.chord.saas_project_chord.bean;

import com.google.gson.annotations.SerializedName;

public class IndexDataBean {
    @SerializedName("config")private IndexConfigBean config;
    @SerializedName("code")private String code;
    @SerializedName("message")private String message;

    public IndexConfigBean getConfig() {
        return config;
    }

    public void setConfig(IndexConfigBean config) {
        this.config = config;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
