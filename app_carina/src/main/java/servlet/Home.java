package servlet;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.GestioneDB;

@WebServlet(name = "home", urlPatterns = { "/","/home" })
public class Home extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 GestioneDB gestioneDB = new GestioneDB(
				(EntityManagerFactory) getServletContext().getAttribute("emf"));
	 req.setAttribute("listaPersone", gestioneDB.mostraPersone());
	 req.getRequestDispatcher("login.jsp").forward(req, resp);
}
}
