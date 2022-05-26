package com.amranetec.ebank.exceptions;

public class BankAccountNotFoundException extends Exception{

    public BankAccountNotFoundException(String message){
        super(message);
    }
}
