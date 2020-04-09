package com.mybatis.annotation.model;

import com.mybatis.annotation.param.PageParam;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : zhayh
 * @date : 2020-4-6 20:21
 * @description : 分页封装数据
 */

@Data
public class Page<T> implements Serializable {
    private int currentPage = 0;
    private long totalPage;
    private long totalNumber;
    private List<T> datas;

    public static Page NULL = new Page(0, 0, 15, new ArrayList<>());

    public Page(int beginLine, long totalNumber, int pageSize, List<T> datas) {
        super();
        this.currentPage = beginLine / pageSize + 1;
        this.totalNumber = totalNumber;
        this.datas = datas;
        this.totalPage = totalNumber % pageSize == 0 ? totalNumber / pageSize : totalNumber / pageSize + 1;
    }

    public Page(PageParam pageParam, Long totalNumber, List<T> datas) {
        super();
        this.currentPage = pageParam.getCurrentPage();
        this.totalNumber = totalNumber;
        this.datas = datas;
        this.totalPage = totalNumber % pageParam.getPageSize() == 0 ?
                totalNumber / pageParam.getPageSize() :
                totalNumber / pageParam.getPageSize() + 1;
    }
}
