package com.recuriment.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public class PageUtils {

    /**
     *  大数据 假分页 未来优化
     */
    public static void setTotalWithNoPagination(Page page) {
        if(page.getRecords() != null && page.getRecords().size() > 0) {
            if(page.getRecords().size() >= page.getSize()) {
                page.setTotal(99999);
            } else {
                page.setTotal(page.getCurrent() * page.getSize() + page.getRecords().size());
            }
        }
    }
}
