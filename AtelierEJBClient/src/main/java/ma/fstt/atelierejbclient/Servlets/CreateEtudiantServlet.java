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

@WebServlet("/createEtudiant")
public class CreateEtudiantServlet extends HttpServlet {
    @EJB
    private EtudiantServiceRemote etudiantService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String cne = request.getParameter("Cne");
        String Address = request.getParameter("Address");
        String Niveau = request.getParameter("Niveau");


        Etudiant newEtudiant = new Etudiant(0L,firstName, lastName, cne, Address, Niveau);
        Etudiant createdEtudiant = etudiantService.createEtudiant(newEtudiant);
        response.setContentType("text/html");
        response.getWriter().println("Created Etudiant: " + createdEtudiant);
    }
}
