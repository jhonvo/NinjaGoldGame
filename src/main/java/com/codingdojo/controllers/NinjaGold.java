package com.codingdojo.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
//import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaGold {

//	private ArrayList<String> actions = new ArrayList<String>();
	
	@RequestMapping(value="/gold", method=RequestMethod.GET)
	public String gold(Model model, HttpSession session) {
		if (session.getAttribute("gold")== null) {
			session.setAttribute("gold", 0);
		}
		if (session.getAttribute("actions")==null) {
			ArrayList<String> actions = new ArrayList<String>();

			session.setAttribute("actions", actions);
		}
		
		model.addAttribute("gold", session.getAttribute("gold"));
		model.addAttribute("actions", session.getAttribute("actions"));
		return "gold.jsp";
	}
	
	@RequestMapping(value="/process", method=RequestMethod.POST)
	public String form(HttpSession session, @RequestParam (value="space") String space) {
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE,' the' dd 'of' MMMM, YYYY");
		Date date = new Date();
		String sDate= sdf.format(date);
		if (space.equals("farm")) {
			int luck = ThreadLocalRandom.current().nextInt(10,21);
//			String actionText = "<p class='text-success'>You entered a farm and earned "+luck+" gold. ("+ sDate + ") </p>";
			String actionText = String.format("You entered a farm and earned %d gold. (%s)", luck,sDate);
			int newGold = (int) session.getAttribute("gold") + luck;
			session.setAttribute("gold", newGold);
			
			ArrayList <String> currentActions = (ArrayList<String>) session.getAttribute("actions");
			currentActions.add(actionText);
			session.setAttribute("actions", currentActions);
		}
		if (space.equals("cave")) {
			int luck = ThreadLocalRandom.current().nextInt(5,11);
			String actionText = String.format("You entered a cave and earned %d gold. (%s)", luck,sDate);
			int newGold = (int) session.getAttribute("gold") + luck;
			session.setAttribute("gold", newGold);
			
			ArrayList <String> currentActions = (ArrayList<String>) session.getAttribute("actions");
			currentActions.add(actionText);
			session.setAttribute("actions", currentActions);
		}
		if (space.equals("house")) {
			int luck = ThreadLocalRandom.current().nextInt(2,6);
			String actionText = String.format("You entered a house and earned %d gold. (%s)", luck,sDate);
			int newGold = (int) session.getAttribute("gold") + luck;
			session.setAttribute("gold", newGold);
			
			ArrayList <String> currentActions = (ArrayList<String>) session.getAttribute("actions");
			currentActions.add(actionText);
			session.setAttribute("actions", currentActions);
		}
		if (space.equals("casino")) {
			int luck = ThreadLocalRandom.current().nextInt(0,51);
			int casino = ThreadLocalRandom.current().nextInt(0,2);
			if (casino == 0) {
				String actionText = String.format("You entered a casino and earned %d gold. (%s)", luck,sDate);
				int newGold = (int) session.getAttribute("gold") + luck;
				session.setAttribute("gold", newGold);
				
				ArrayList <String> currentActions = (ArrayList<String>) session.getAttribute("actions");
				currentActions.add(actionText);
				session.setAttribute("actions", currentActions);
			}
			else {
				String actionText = String.format("You entered a casino and lost %d gold. Ouch! (%s)", luck,sDate);
				int newGold = (int) session.getAttribute("gold") - luck;
				session.setAttribute("gold", newGold);
				
				ArrayList <String> currentActions = (ArrayList<String>) session.getAttribute("actions");
				currentActions.add(actionText);
				session.setAttribute("actions", currentActions);
			}
		}
		
		return "redirect:/gold";	
	}
	
	@RequestMapping(value="/clear", method=RequestMethod.GET)
	public String clear( HttpSession session) {
		session.removeAttribute("gold");
		session.removeAttribute("actions");
		return "redirect:/gold";
	}
	
//	@RequestMapping(value="/cave", method=RequestMethod.GET)
//	public String cave() {
//		int luck = ThreadLocalRandom.current().nextInt(5,11);
//		SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd YYYY, hh:mm a");
//		actions.add(String.format("<p class='text-success'>You entered a cave and earned %d gold. (%s)</p>", luck,sdf));
//		gold += luck;
//		return "redirect:/gold";
//	}
//	
//	@RequestMapping(value="/house", method=RequestMethod.GET)
//	public String house() {
//		int luck = ThreadLocalRandom.current().nextInt(2,6);
//		SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd YYYY, hh:mm a");
//		actions.add(String.format("<p class='text-success'>You entered a house and earned %d gold. (%s)</p>", luck,sdf));
//		gold += luck;
//		return "redirect:/gold";
//	}
//	
//	@RequestMapping(value="/casino", method=RequestMethod.GET)
//	public String Casino() {
//		int luck = ThreadLocalRandom.current().nextInt(0,51);
//		int casino = ThreadLocalRandom.current().nextInt(0,2);
//		SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd YYYY, hh:mm a");
//		if (casino == 0) {
//			actions.add(String.format("<p class='text-success'>You entered a house and earned %d gold. (%s)</p>", luck,sdf));
//			gold += luck;
//		}
//		else{
//			actions.add(String.format("<p class='text-danger'>You entered a house and lost %d gold. (%s)</p>", luck,sdf));
//			gold -= luck;
//		}
//		return "redirect:/gold";
//	}
	
	
	
	

}
