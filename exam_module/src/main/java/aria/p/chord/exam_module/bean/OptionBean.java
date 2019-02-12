package aria.p.chord.exam_module.bean;

import com.google.gson.annotations.SerializedName;

public class OptionBean {
    @SerializedName("label")private String label;
    @SerializedName("checked")private boolean checked;
    private boolean selected=false;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
