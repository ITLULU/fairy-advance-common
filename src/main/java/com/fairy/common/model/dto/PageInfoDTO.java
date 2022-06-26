package com.fairy.common.model.dto;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**分页工具类
 * @author hll
 * @version 1.0
 * @date 2022/6/26 17:49
 */
public class PageInfoDTO<T> {
    /**
     * 总记录数
     */
    private Integer totalCount;
    /**
     * 每页记录数
     */
    private Integer pageSize;
    /**
     * 总页数
     */
    private Integer totalPage;
    /**
     * 开始页数默认从1
     */
    private Integer startPage;
    /**
     * 列表数据
     */
    private List<T> list;

    /**
     * 分页
     *
     * @param list      列表数据
     * @param pageSize  每页记录数
     * @param startPage 当前页数
     */
    public PageInfoDTO(List<T> list, Integer pageSize, Integer startPage) {
        this.list = list;
        this.totalCount = list.size();
        this.pageSize = pageSize;
        this.startPage = startPage;
        this.totalPage = (int) Math.ceil((double) totalCount / pageSize);
    }


    /**
     * 分页
     */
    public PageInfoDTO(IPage<T> page) {
        this.list = page.getRecords();
        this.totalCount = (int) page.getTotal();
        this.pageSize = (int) page.getSize();
        this.startPage = (int) page.getCurrent();
        this.totalPage = (int) page.getPages();
    }


    public PageInfoDTO(PageInfo<T> pageInfo) {
        this.list = pageInfo.getList();
        this.totalCount = (int) pageInfo.getTotal();
        this.pageSize = pageInfo.getPageSize();
        this.startPage = pageInfo.getPageNum();
        this.totalPage = pageInfo.getPages();
    }

    public PageInfoDTO(List<T> list) {
        PageInfo<T> page = new PageInfo<T>(list);
        this.list = page.getList();
        this.totalCount = (int) page.getTotal();
        this.pageSize = (int) page.getPageSize();
        this.startPage = (int) page.getPageNum();
        this.totalPage = (int) page.getPages();
    }


    public PageInfoDTO(Page page, List<T> dogInfoList) {
        this.list = dogInfoList;
        if (page != null) {
            this.totalCount = (int) page.getTotal();
            this.pageSize = page.getPageSize();
            this.startPage = (int) page.getPageNum();
            this.totalPage = (int) page.getPages();
        } else {
            this.totalCount = dogInfoList.size();
            this.pageSize = dogInfoList.size();
            this.startPage = 1;
            this.totalPage = dogInfoList.size() > 0 ? 1 : 0;
        }

    }
}
