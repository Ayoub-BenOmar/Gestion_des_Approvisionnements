package com.tricol.service;

import com.tricol.model.Tricol;
import com.tricol.repository.TricolDao;

import java.util.List;

public class TricolService {
    private TricolDao tricolDao;

    public void setTricolDao(TricolDao tricolDao) {
        this.tricolDao = tricolDao;
    }

    public List<Tricol> getAll() {
        return tricolDao.findAll();
    }

    public Tricol getById(Integer id) {
        return tricolDao.findById(id);
    }

    public void save(Tricol tricol) {
        tricolDao.save(tricol);
    }

    public void update(Integer id, Tricol tricol) {
        tricolDao.update(id, tricol);
    }

    public void delete(Integer id) {
        tricolDao.delete(id);
    }
}