package com.emperorws.hrmanagement.model;

import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/2/14 17:28
 * @Description: HttpResponse
 **/
public class RespPageBean {
    private Long total;
    private List<?> data;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
