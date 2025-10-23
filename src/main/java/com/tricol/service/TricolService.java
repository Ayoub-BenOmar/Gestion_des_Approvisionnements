package com.tricol.service;

import com.tricol.model.Tricol;
import com.tricol.repository.TricolRepository;

import java.util.List;

public class TricolService {
    private TricolRepository tricolRepository;

    public void setTricolRepository(TricolRepository tricolRepository){
        this.tricolRepository = tricolRepository;
    }

    public Tricol save(Tricol tricol) {
        return tricolRepository.save(tricol);
    }

    public Tricol update(Integer id, Tricol tricol) {
        tricol.setId(id);
        return tricolRepository.save(tricol);
    }

    public Tricol getById(Integer id) {
        return tricolRepository.findById(id).orElse(null);
    }

    public List<Tricol> getAll() {
        return tricolRepository.findAll();
    }

    public void delete(Integer id) {
        tricolRepository.deleteById(id);
    }
}
