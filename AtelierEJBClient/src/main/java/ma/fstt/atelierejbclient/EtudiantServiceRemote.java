package ma.fstt.atelierejbclient;

import jakarta.ejb.Remote;
import java.util.List;

@Remote
public interface EtudiantServiceRemote {
    Etudiant createEtudiant(Etudiant etudiant);
    Etudiant updateEtudiant(Etudiant etudiant);
    void deleteEtudiant(Long etudiantId);
    Etudiant getEtudiantById(Long etudiantId);
    List<Etudiant> getAllEtudiants();
}
