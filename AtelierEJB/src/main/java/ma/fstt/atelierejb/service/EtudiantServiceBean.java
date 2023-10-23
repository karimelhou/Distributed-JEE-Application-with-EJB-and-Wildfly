package ma.fstt.atelierejb.service;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import ma.fstt.atelierejb.Entity.Etudiant;

@Stateless
public class EtudiantServiceBean implements EtudiantServiceRemote {

    @PersistenceContext(unitName = "Etudiant")
    private EntityManager entityManager;

    @Override
    public Etudiant createEtudiant(Etudiant etudiant) {
        entityManager.persist(etudiant);
        return etudiant;
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {
        return entityManager.merge(etudiant);
    }

    @Override
    public void deleteEtudiant(Long etudiantId) {
        Etudiant etudiant = entityManager.find(Etudiant.class, etudiantId);
        if (etudiant != null) {
            entityManager.remove(etudiant);
        }
    }

    @Override
    public Etudiant getEtudiantById(Long etudiantId) {
        return entityManager.find(Etudiant.class, etudiantId);
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        try {
            return entityManager.createQuery("SELECT e FROM Etudiant e", Etudiant.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

