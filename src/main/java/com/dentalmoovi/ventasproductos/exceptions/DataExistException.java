package com.dentalmoovi.ventasproductos.exceptions;

public class DataExistException extends RuntimeException{
    public DataExistException(String message){
        super(message);
    }
}
