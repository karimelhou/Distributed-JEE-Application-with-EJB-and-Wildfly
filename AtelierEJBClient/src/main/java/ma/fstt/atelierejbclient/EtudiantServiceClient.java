package ma.fstt.atelierejbclient;

import jakarta.ejb.EJB;
import ma.fstt.atelierejbclient.Etudiant;

import java.util.List;

public class EtudiantServiceClient {

    @EJB
    private EtudiantServiceRemote etudiantService;

    public Etudiant createEtudiant(Etudiant etudiant) {
        return etudiantService.createEtudiant(etudiant);
    }

    public Etudiant updateEtudiant(Etudiant etudiant) {
        return etudiantService.updateEtudiant(etudiant);
    }

    public void deleteEtudiant(Long etudiantId) {
        etudiantService.deleteEtudiant(etudiantId);
    }

    public Etudiant getEtudiantById(Long etudiantId) {
        return etudiantService.getEtudiantById(etudiantId);
    }

    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }
}
