package net.lecigne.proxibanquesi.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.lecigne.proxibanquesi.model.Client;
import net.lecigne.proxibanquesi.model.Conseiller;
import net.lecigne.proxibanquesi.service.ClientService;
import net.lecigne.proxibanquesi.service.ClientServiceImp;

/**
 * Servlet implementation class CreerClient
 */
@WebServlet("/CreerClient")
public class CreerClient extends HttpServlet {

	private ClientService clientService = new ClientServiceImp();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreerClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Conseiller conseiller = (Conseiller) session.getAttribute("conseillerSession");
		int idConseiller = conseiller.getId();
		
		request.setCharacterEncoding("UTF-8");

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String telephone = request.getParameter("telephone");

		Client client = new Client(nom, prenom, adresse, codePostal, ville, telephone);
		client.setIdConseiller(idConseiller);
		
		clientService.creerClient(client);

		request.setAttribute("client", client);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/results/creationclient.jsp");
		rd.forward(request, response);

	}

}
