package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.Produit_implement;
import model.dao.iProduit;
import model.entite.Produit;

/**
 * Servlet implementation class Controler
 */
@WebServlet("/Controler")
public class Controler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	iProduit dao;
	public void init() {
		dao = new Produit_implement();
		
	}
    public Controler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String key,click,add,action;
		click = request.getParameter("click");
		key = request.getParameter("key");
		add = request.getParameter("add");
		action =request.getParameter("action");
		
		if(add != null) {
			String designation = request.getParameter("designation");
			String prix = request.getParameter("prix");
			String quant= request.getParameter("quant");
			int prixInt = Integer.parseInt(prix);
			int quantInt = Integer.parseInt(quant);
			if( (designation !=null) && (prix != null) && (quant != null) ) {
				Produit product = new Produit(designation,prixInt,quantInt);
				dao.InsertProduct(product);
			}
		}
		
		if((click != null) && (key != null)) {
			List<Produit> liste = dao.getAllProductesByKey(key);
			request.setAttribute("PRODUCTS", liste);
			request.getRequestDispatcher("View.jsp").forward(request, response);
			
		} else 
		{
		List<Produit> liste = dao.getAllProductes();
		request.setAttribute("PRODUCTS", liste);
		request.getRequestDispatcher("View.jsp").forward(request, response);
		}
		
		if(action.equals("Remove")) {
			int id = Integer.parseInt(request.getParameter("id"));
			dao.RemoveProduct(id);
			List<Produit> liste = dao.getAllProductes();
			request.setAttribute("PRODUCTS", liste);
			request.getRequestDispatcher("View.jsp").forward(request, response);
		}
       
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
