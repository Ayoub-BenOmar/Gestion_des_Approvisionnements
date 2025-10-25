package com.tricol.service;

import com.tricol.model.Tricol;
import com.tricol.repository.TricolRepository;

import java.util.List;
import java.util.Optional;

public class TricolService {

    private final TricolRepository fournisseurRepository;

    public TricolService(TricolRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    public  void save(Tricol fournisseur) {
        fournisseurRepository.save(fournisseur);
    }

    public Optional<Tricol> findById(int id) {
        Optional<Tricol> fournisseur=fournisseurRepository.findById(id);;
        return fournisseur;
    }

    public List<Tricol> findAll() {
        return fournisseurRepository.findAll();
    }

    public void delete(Tricol fournisseur) {
        fournisseurRepository.delete(fournisseur);
    }

    public void update(Tricol fournisseur) {
        fournisseurRepository.save(fournisseur);
    }

    public List<Tricol> findByName(String name) {return fournisseurRepository.findByContact(name) ; };
    public Tricol findByEmail(String email) {return fournisseurRepository.findByEmail(email) ;};




}
