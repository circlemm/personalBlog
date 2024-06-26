package com.dkt.blogboot.req;

import javax.validation.constraints.NotBlank;


public class CategoryInsertReq {
    private Integer id;

    @NotBlank(message = "分类名不能为空")
    private String category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}