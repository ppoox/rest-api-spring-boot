package com.ppoox.api.sys.util;

import com.ppoox.api.sys.base.BaseObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Paging extends BaseObject {

    /**
     *
     */
    private static final long serialVersionUID = -7035269505630945424L;

    private Integer pageNum;

    private Integer rowsPerPage;

    private String sort;

    public Integer getRowsPerPage() {
        if (this.rowsPerPage == null)
            this.rowsPerPage = 10;
        return this.rowsPerPage;
    }

    public Integer getPageNum() {
        if (this.pageNum == null)
            this.pageNum = 1;
        return this.pageNum;
    }

    public Integer getStart() {
        return (this.getPageNum() - 1) * this.getRowsPerPage();
    }
}
