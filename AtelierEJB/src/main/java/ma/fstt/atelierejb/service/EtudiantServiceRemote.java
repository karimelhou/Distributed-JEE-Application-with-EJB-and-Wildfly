package ma.fstt.atelierejb.service;

import java.util.List;

import jakarta.ejb.Remote;
import ma.fstt.atelierejb.Entity.Etudiant;

@Remote
public interface EtudiantServiceRemote {
    Etudiant createEtudiant(Etudiant etudiant);
    Etudiant updateEtudiant(Etudiant etudiant);
    void deleteEtudiant(Long etudiantId);
    Etudiant getEtudiantById(Long etudiantId);
    List<Etudiant> getAllEtudiants();
}
