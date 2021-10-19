package com.corba.corbacorba.dto;

import java.io.Serializable;

public class ErrorDto implements Serializable {
    private Integer code;

    private String description;

    public ErrorDto(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
