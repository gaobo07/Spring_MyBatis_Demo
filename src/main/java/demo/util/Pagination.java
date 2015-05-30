package demo.util;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2015/5/30.
 */
public class Pagination<M extends Serializable> {

    private List<M> list;
    private String selectId;

    private int totalRows;
    private int totalPages;
    private int currentPage;
    private int pageSize;

    public Pagination(List<M> list, String selectId, int totalRows, int totalPages, int currentPage, int pageSize) {
        this.list = list;
        this.selectId = selectId;
        this.totalRows = totalRows;
        this.totalPages = totalPages;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public List<M> getList() {

        return list;
    }

    public void setList(List<M> list) {
        this.list = list;
    }

    public String getSelectId() {
        return selectId;
    }

    public void setSelectId(String selectId) {
        this.selectId = selectId;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
