package com.tricol.controller;

import com.tricol.model.Tricol;
import com.tricol.service.TricolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tricols")
public class TricolController {


    @Autowired
    private TricolService TricolService;

    public TricolController(TricolService TricolService) {
        this.TricolService = TricolService;
    }

    @PostMapping
    public String createFournisseur(@RequestBody Tricol fournisseur) {
        TricolService.save(fournisseur);
        return "Fournisseur ajouté avec succès" + fournisseur;
    }

    @GetMapping
    public List<Tricol> getAllFournisseur() {
        return TricolService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tricol> getFournisseurById(@PathVariable("id") int id) {
        Optional<Tricol> fournisseur = TricolService.findById(id);
        return fournisseur.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public String deleteFournisseurById(@PathVariable int id) {
        Optional<Tricol> fournisseur = TricolService.findById(id);
        if (fournisseur.isPresent()) {
            TricolService.delete(fournisseur.get());
            return "Fournisseur supprimé avec succès";
        } else {
            return "Fournisseur non trouvé";
        }
    }

    @PutMapping("/{id}")
    public String updateFournisseur(@PathVariable int id, @RequestBody Tricol fournisseur) {
        Optional<Tricol> existingOpt = TricolService.findById(id);
        if (existingOpt.isPresent()) {
            Tricol existing = existingOpt.get();
            existing.setIce(fournisseur.getIce());
            existing.setContact(fournisseur.getContact());
            existing.setSociete(fournisseur.getSociete());
            existing.setAdresse(fournisseur.getAdresse());
            existing.setTelephone(fournisseur.getTelephone());
            existing.setEmail(fournisseur.getEmail());
            existing.setVille(fournisseur.getVille());

            TricolService.update(existing);
            return "Fournisseur mis à jour avec succès";
        } else {
            return "Fournisseur non trouvé";
        }
    }

    @GetMapping("/nom")
    public ResponseEntity<List<Tricol>> getFournisseurByNom(@RequestParam("nom") String nom) {
        List<Tricol> fournisseurs = TricolService.findByName(nom);
        return ResponseEntity.ok(fournisseurs);
    }

    @GetMapping("/email")
    public Tricol getFournisseurByEmail(@RequestParam("email") String email) {
        return TricolService.findByEmail(email);
    }

}