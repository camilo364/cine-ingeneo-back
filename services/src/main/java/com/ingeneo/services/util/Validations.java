package com.ingeneo.services.util;

public final class Validations {

    private Validations(){}

    public static boolean isNotANumber(String str) {
        if (str == null){
            return true;
        }
        for (char c : str.toCharArray()){
            if (c < '0' || c > '9'){
                return true;
            }
        }
        return false;
    }
}
