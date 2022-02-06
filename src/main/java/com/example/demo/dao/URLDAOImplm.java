package com.example.demo.dao;

import com.example.demo.entity.Url;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository

public class URLDAOImplm implements URLDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Url> getAllURL() {
        Session session = entityManager.unwrap(Session.class);
        List<Url> allURL = session.createQuery("from Url", Url.class).getResultList();
        return allURL;
    }

    @Override
    public void saveUrl(Url url) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(url);
    }

    @Override
    public Url getUrl(int id) {
        Session session = entityManager.unwrap(Session.class);
        Url url = session.get(Url.class, id);
        return url;
    }

    @Override
    public void deleteUrl(int id) {
        Session session = entityManager.unwrap(Session.class);
        Url employee = session.get(Url.class, id);
        session.delete(employee);
    }
      }
