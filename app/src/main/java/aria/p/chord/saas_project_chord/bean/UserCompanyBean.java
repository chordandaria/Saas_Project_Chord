package aria.p.chord.saas_project_chord.bean;

import com.google.gson.annotations.SerializedName;

public class UserCompanyBean {
    @SerializedName("id")private int id;
    @SerializedName("user_id")private int user_id;
    @SerializedName("name")private String name;
    @SerializedName("email")private String email;
    @SerializedName("phone")private String phone;
    @SerializedName("score")private String score;
    @SerializedName("badge")private String badge;
    @SerializedName("birthday")private String birthday;
    @SerializedName("sex")private String sex;
    @SerializedName("department_string")private String department_string;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDepartment_string() {
        return department_string;
    }

    public void setDepartment_string(String department_string) {
        this.department_string = department_string;
    }
}
