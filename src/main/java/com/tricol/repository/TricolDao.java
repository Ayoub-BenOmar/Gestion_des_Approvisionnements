package com.tricol.repository;

import com.tricol.model.Tricol;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TricolDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Tricol> findAll() {
        return entityManager.createQuery("SELECT t FROM Tricol t", Tricol.class)
                .getResultList();
    }

    public Tricol findById(Integer id) {
        return entityManager.find(Tricol.class, id);
    }

    public void save(Tricol tricol) {
        entityManager.persist(tricol);
    }

    public void update(Integer id, Tricol tricol) {
        Tricol existing = entityManager.find(Tricol.class, id);
        if (existing != null) {
            existing.setSociete(tricol.getSociete());
            existing.setAdresse(tricol.getAdresse());
            existing.setContact(tricol.getContact());
            existing.setEmail(tricol.getEmail());
            existing.setTelephone(tricol.getTelephone());
            existing.setVille(tricol.getVille());
            existing.setICE(tricol.getICE());
            entityManager.merge(existing);
        }
    }

    public void delete(Integer id) {
        Tricol tricol = entityManager.find(Tricol.class, id);
        if (tricol != null) {
            entityManager.remove(tricol);
        }
    }
}