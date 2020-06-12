package servlet;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelli.Persona;
import utility.GestioneDB;

@WebServlet(name = "login", urlPatterns = { "/login" })

public class CreaUtente extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			GestioneDB gestioneDB = new GestioneDB((EntityManagerFactory) getServletContext().getAttribute("emf"));
			Persona p = new Persona();
			p.setNome(req.getParameter("nome"));
			p.setCognome(req.getParameter("cognome"));
			p.setNumero(Long.parseLong(req.getParameter("numero")));
			gestioneDB.aggiungiUtente(p);
			req.setAttribute("listaPersone", gestioneDB.mostraPersone());
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		
	}
}
