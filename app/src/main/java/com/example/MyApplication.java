package com.example;

//import org.apache.commons.lang3.StringUtils;

public class MyApplication
{
    public static void main(String[] args) {
//        StringUtils.trim("foo");
        new PrintService().print(new MessageModel("foo"));
    }
}
