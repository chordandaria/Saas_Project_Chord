package aria.p.chord.request_forms_module.bean;

import com.google.gson.annotations.SerializedName;

public class PaginationBean {
    @SerializedName("currentPage")private int currentPage;
    @SerializedName("totalPages")private int totalPages;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
