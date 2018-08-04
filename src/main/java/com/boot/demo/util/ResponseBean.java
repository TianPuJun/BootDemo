package com.boot.demo.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 统一返回值类
 *
 * @author cui
 * @create 2018-07-24 15:07
 **/
@ApiModel(value = "统一返回类")
public class ResponseBean<T> {
    @ApiModelProperty(value = "请求成功失败参数")

    private boolean flag;

    @ApiModelProperty(value = "请求返回数据" )
    private T res;

    @ApiModelProperty(value = "请求返回信息描述")
    private String msg;

    @ApiModelProperty(value = "根据条件查询到的总条数")
    private Integer total;

    @ApiModelProperty(value = "分页查询是每页条数")
    private Integer numberPerPage;

    @ApiModelProperty(value = "分页查询时查到的页数")
    private Integer paginalNumber;

    @ApiModelProperty(value = "操作成功条数")
    private Integer successNumber;

    @ApiModelProperty(value = "操作失败条数")
    private Integer errorNumber;

    @ApiModelProperty(value = "返回码")
    private Integer status;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public T getRes() {
        return res;
    }

    public void setRes(T res) {
        this.res = res;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getNumberPerPage() {
        return numberPerPage;
    }

    public void setNumberPerPage(Integer numberPerPage) {
        this.numberPerPage = numberPerPage;
    }

    public Integer getPaginalNumber() {
        return paginalNumber;
    }

    public void setPaginalNumber(Integer paginalNumber) {
        this.paginalNumber = paginalNumber;
    }

    public Integer getSuccessNumber() {
        return successNumber;
    }

    public void setSuccessNumber(Integer successNumber) {
        this.successNumber = successNumber;
    }

    public Integer getErrorNumber() {
        return errorNumber;
    }

    public void setErrorNumber(Integer errorNumber) {
        this.errorNumber = errorNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
