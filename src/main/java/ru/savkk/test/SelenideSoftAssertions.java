package ru.savkk.test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class SelenideSoftAssertions {

    private List<Exception> errorsList = new ArrayList<>();

    public void runMethod(Method method) {
        try {
            method();
        } catch (Exception e){
            errorsList.add(e);
        }
            
    }

    public void addError(Exception err) {
        errorsList.add(err);
    }

    public void clearErrorList() {
        errorsList.clear();
    }

    public List<Exception> getErrors() {
       return errorsList;
    }

}
