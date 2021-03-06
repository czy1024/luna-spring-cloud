package com.luna.account.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * (Account)实体类
 *
 * @author luna
 * @since 2021-02-05 13:53:04
 */
@ApiModel("实体类")
public class Account implements Serializable {
    private static final long serialVersionUID = 164140558893644657L;
    @ApiModelProperty("id")
    private Long              id;
    @ApiModelProperty("userId")
    private Long              userId;
    /**
     * 总额度
     */
    @ApiModelProperty("总额度")
    private Double            total;
    /**
     * 已用额度
     */
    @ApiModelProperty("已用额度")
    private Double            used;
    /**
     * 剩余额度
     */
    @ApiModelProperty("剩余额度")
    private Double            residue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getUsed() {
        return used;
    }

    public void setUsed(Double used) {
        this.used = used;
    }

    public Double getResidue() {
        return residue;
    }

    public void setResidue(Double residue) {
        this.residue = residue;
    }

}
