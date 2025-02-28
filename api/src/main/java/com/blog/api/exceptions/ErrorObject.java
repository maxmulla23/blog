package com.blog.api.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class ErrorObject {
    private int statusCode;
    private String message;
    private Date timeStamp;

    public ErrorObject() {

    }
}
