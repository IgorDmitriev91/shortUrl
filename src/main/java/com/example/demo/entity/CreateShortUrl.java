package com.example.demo.entity;



import java.util.Random;

public class CreateShortUrl {
    public String shortURL() {
        //48-57//97-122
        String str = "";
        char [] charArray = new char[36];
        int digit = 48;
        int letter = 97;
        for (int i = 0; i <10 ; i++) {
            charArray[i] = (char) digit;
            digit++;
        }
        for (int i = 10; i <36 ; i++) {
            charArray[i] = (char) letter;
            letter++;
        }
        for (int i = 0; i <6 ; i++) {
            Random random = new Random();
            int x = random.nextInt(36);
            str = str+charArray[x];
        }
          return str;
        }

    }

