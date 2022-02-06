package com.example.demo.entity;

public class UpgreatUrl  {
    public boolean startURL(String str){
        return str.startsWith("www.");
    }
    public boolean finishURL(String str) {
        return str.endsWith(".com") || str.endsWith(".ru") || str.endsWith(".org");
    }
}
