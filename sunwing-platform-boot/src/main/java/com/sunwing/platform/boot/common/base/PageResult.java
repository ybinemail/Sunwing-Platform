package com.sunwing.platform.boot.common.base;

import com.sunwing.platform.boot.common.enums.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("通用分页响应类")
public class PageResult<T> {

    @ApiModelProperty(value = "是否成功", required = true)
    private boolean success;

    @ApiModelProperty(value = "响应代码", required = true)
    private int code;

    @ApiModelProperty(value = "提示信息", required = true)
    private String msg;

    @ApiModelProperty(value ="总数量", required = true)
    private long count;

    @ApiModelProperty(value ="分页数据")
    private List<T> data;


    public PageResult(long total, List<T> data){
        this.count = total;
        this.data = data;
        this.code = ResultCodeEnum.SUCCESS.code;
        this.msg = ResultCodeEnum.SUCCESS.msg;
    }


}
