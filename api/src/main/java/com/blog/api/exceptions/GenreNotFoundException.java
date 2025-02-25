package com.blog.api.exceptions;

public class GenreNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 2;
    public GenreNotFoundException(String message) {
        super(message);
    }
}
