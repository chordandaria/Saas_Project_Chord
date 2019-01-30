package aria.p.chord.group_event_module.beans;

import com.google.gson.annotations.SerializedName;

public class EventExtraBean {
    @SerializedName("title")private String title;
    @SerializedName("value")private String value;

    public EventExtraBean(String title, String value) {
        this.title = title;
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
