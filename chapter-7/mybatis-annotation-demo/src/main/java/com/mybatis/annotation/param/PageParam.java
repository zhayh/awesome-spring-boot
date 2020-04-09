package com.mybatis.annotation.param;

import lombok.Data;

/**
 * @author : zhayh
 * @date : 2020-4-6 20:19
 * @description : 分页的基础类
 */

@Data
public class PageParam {
    private Integer beginLine;
    private Integer pageSize = 3;
    private Integer currentPage = 0;
    public int getBeginLine() {
        return pageSize * currentPage;
    }
}
