package com.example.demo.service;

import com.example.demo.entity.Url;

import java.util.List;

public interface UrlService {
     List<Url> getAllURL();

    void saveUrl(Url url);

    Url getUrl(int id);

    void deleteUrl(int id);
}
