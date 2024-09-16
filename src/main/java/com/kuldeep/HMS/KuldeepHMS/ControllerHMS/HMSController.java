package com.kuldeep.HMS.KuldeepHMS.ControllerHMS;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kuldeep.HMS.KuldeepHMS.Model.Appointment;
import com.kuldeep.HMS.KuldeepHMS.Model.Contact;
import com.kuldeep.HMS.KuldeepHMS.Model.Login;

@Controller
public class HMSController {

	@Autowired
	SessionFactory sf;

	//to open login page
	@RequestMapping("/")
	public String login() {
		return "login";
	}

	//to check the username and password from database.
	@RequestMapping("/login")
	public String loginlogic(Login login, Model model) {
		Session ss = sf.openSession();
		Login dblogin = ss.get(Login.class, login.getPassword());
		String page = "login";
		String msg = null;

		if (dblogin != null) {
			if (login.getUsername().equals(dblogin.getUsername())) {
				page = "home";
			} else {
				msg = "Invalid Username";
			}

		} else {
			msg = "Invalid Password";

		}
		model.addAttribute("msg", msg);
		
		return page;
	}

	@RequestMapping("createpage")
	public String createpage() {
		return "createaccount";
	}

	// to save the create account data.
	@RequestMapping("createaccount")
	public String createaccount(Login login) {
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		ss.save(login);
		tx.commit();
		return "login";
	}
	
	//to home page.
	@RequestMapping("homepage")
	public String homepage() {
		return "home";
	}
	
	//to open about page.
	@RequestMapping("aboutpage")
	public String aboutpage() {
		return "about";
	}


	//Open Appointment Page 
	@RequestMapping("/appointmentpage")
	public String appointmentPage() {
		return "appointment";
	}
	
	//Save the Appointment Data In Data Base
	@RequestMapping("/appointment")
	public Appointment appointmentSave(Appointment appointment) {
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		ss.save(appointment);
		System.out.println(appointment);
		tx.commit();
		return appointment;
	}
	
	//to open contact page
	@RequestMapping("contactpage")
	public String contactpage() {
		return "contact";
	}
	
	//to save data the contact data .
	@RequestMapping("contact")
	public String contactsave(Contact contact) {
		Session ss=sf.openSession();
		Transaction tx=ss.beginTransaction();
		ss.save(contact);
		tx.commit();
		return "contact";
	}
	//Open pricing Page
		@RequestMapping("pricepage")
		public String pricePage() {
			return "price";
		}
		// To open service page.
	@RequestMapping("servicepage")
	public String servicepage() {
		return "service";
	}

	//TO Open Team page
		@RequestMapping("teampage")
		public String teamPage() {
			return "team";
		}


		// TO Open T&C page.
			@RequestMapping("t&cpage")
			public String termsAndConditions () {
				return "terms&conditions";
			}

		
	
}
