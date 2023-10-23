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

@WebServlet("/getEtudiant")
public class GetEtudiantServlet extends HttpServlet {
    @EJB
    private EtudiantServiceRemote etudiantService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long etudiantId = Long.parseLong(request.getParameter("id"));
        Etudiant etudiant = etudiantService.getEtudiantById(etudiantId);
        response.setContentType("text/html");
        response.getWriter().println("Etudiant Info: " + etudiant);
    }
}

