package ma.fstt.atelierejbclient.Servlets;

import java.io.IOException;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.fstt.atelierejbclient.EtudiantServiceRemote;

@WebServlet("/deleteEtudiant")
public class DeleteEtudiantServlet extends HttpServlet {
    @EJB
    private EtudiantServiceRemote etudiantService;

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long etudiantId = Long.parseLong(request.getParameter("id"));
        etudiantService.deleteEtudiant(etudiantId);
        response.setContentType("text/html");
        response.getWriter().println("Etudiant with ID " + etudiantId + " has been deleted.");
    }
}

