package com.tricol.repository;

import com.tricol.model.Tricol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TricolRepository extends JpaRepository<Tricol, Integer> {


    public List<Tricol> findByContact(String nom);

    @Query("SELECT fr FROM Tricol fr WHERE fr.email ILIKE  %?1")
    public Tricol findByEmail(String email);
}