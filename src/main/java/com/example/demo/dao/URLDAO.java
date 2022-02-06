package com.example.demo.dao;

import com.example.demo.entity.Url;

import java.util.List;

public interface URLDAO {
    public List<Url> getAllURL();

    void saveUrl(Url url);

    Url getUrl(int id);

    void deleteUrl(int id);
}

