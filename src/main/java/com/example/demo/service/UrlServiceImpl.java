package com.example.demo.service;

import com.example.demo.dao.URLDAO;
import com.example.demo.entity.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UrlServiceImpl implements UrlService {
    @Autowired
   private URLDAO urldao;
    @Transactional
    @Override
    public List<Url> getAllURL() {
        return urldao.getAllURL();
    }
    @Override
    @Transactional
    public void saveUrl(Url url) {
        urldao.saveUrl(url);
    }

    @Override
    @Transactional
    public Url getUrl(int id) {
        return urldao.getUrl(id);
    }

    @Override
    @Transactional
    public void deleteUrl(int id) {
        urldao.deleteUrl(id);
    }
}
