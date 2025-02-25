package com.blog.api.exceptions;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ErrorObject {
    private int statusCode;
    private String message;
    private Date timeStamp;

    public ErrorObject() {

    }
}
