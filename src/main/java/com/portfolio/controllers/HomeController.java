package com.portfolio.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.portfolio.models.Details;
import com.portfolio.models.Project;
import com.portfolio.models.User;
import com.portfolio.repositories.AboutRepo;
import com.portfolio.repositories.ProfileRepo;
import com.portfolio.repositories.ProjectRepo;
import com.portfolio.repositories.SkillRepo;
import com.portfolio.repositories.detailRepo;

import jakarta.websocket.server.PathParam;

@Controller
public class HomeController {
	
	@Autowired
	private ProjectRepo pRepo;
	
	@Autowired
	private AboutRepo aRepo;
	
	@Autowired
	private ProfileRepo profileRepo;
	
	@Autowired
	private SkillRepo skillRepo;
	
	@Autowired
	 private detailRepo drepo;
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("profile", this.profileRepo.findAll());
		model.addAttribute("skill", this.skillRepo.findAll());


		return "home";
		
	}
	@GetMapping("/myProject")
	public String projects(Model model) {
		
		
		model.addAttribute("project", this.pRepo.findAll());
		return "project";	
	}
	
	
	@GetMapping("/myprojects/{id}")
	public String projectsById(Model model   ,@PathVariable int id) {
		Project project = this.pRepo.findById(id).get();
		System.out.print("the prdct are"+ project.getName());

		model.addAttribute("ps", project);
		
		Set<Details> det = drepo.findDetailByproject(project.getId());
		
		model.addAttribute("det", det);
		
		
		return "projects";	
	}
	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("about", this.aRepo.findAll());
		model.addAttribute("profile", this.profileRepo.findAll());
		return "about";	
	}
	@GetMapping("/skill")
	public String skill(Model model) {
		model.addAttribute("skill", this.skillRepo.findAll());
		return "skill";	
	}
	@GetMapping("/login")
	public String login() {
		return "login";
		
	}
	
	
	
	
	

}
