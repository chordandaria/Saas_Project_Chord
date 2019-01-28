package aria.p.chord.saas_project_chord.bean;

import com.google.gson.annotations.SerializedName;

public class InfoDataBean {
    @SerializedName("id")private int id;
    @SerializedName("name")private String name;
    @SerializedName("username")private String username;
    @SerializedName("companyInfo")private UserCompanyBean companyInfo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserCompanyBean getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(UserCompanyBean companyInfo) {
        this.companyInfo = companyInfo;
    }
}
