package ma.fstt.atelierejbclient.Servlets;

import java.io.IOException;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.fstt.atelierejbclient.Etudiant;
import ma.fstt.atelierejbclient.EtudiantServiceRemote;

@WebServlet("/updateEtudiant")
public class UpdateEtudiantServlet extends HttpServlet {
    @EJB
    private EtudiantServiceRemote etudiantService;

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long etudiantId = Long.parseLong(request.getParameter("id"));
        String newFirstName = request.getParameter("newFirstName");
        String newLastName = request.getParameter("newLastName");
        String newCne = request.getParameter("Cne");
        String newAddr = request.getParameter("Address");
        String newNiveau = request.getParameter("Niveau");
        Etudiant etudiant = etudiantService.getEtudiantById(etudiantId);

        if (etudiant != null) {
            etudiant.setPrenom(newFirstName);
            etudiant.setNom(newLastName);
            etudiant.setCne(newCne);
            etudiant.setAdresse(newAddr);
            etudiant.setNiveau(newNiveau);
            Etudiant updatedEtudiant = etudiantService.updateEtudiant(etudiant);
            response.setContentType("text/html");
            response.getWriter().println("Updated Etudiant: " + updatedEtudiant);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Etudiant not found");
        }
    }
}

