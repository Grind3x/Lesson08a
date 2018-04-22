package com.gmail.grind3x;

public class OutOfStudentIndexException extends Exception {

    @Override
    public String getMessage() {
        return "Going beyond the com.gmail.grind3x.Student Array";
    }

}
