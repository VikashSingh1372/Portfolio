package com.portfolio.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.portfolio.config.ImageService;
import com.portfolio.models.Project;
import com.portfolio.models.Skill;
import com.portfolio.models.profile;
import com.portfolio.repositories.ProfileRepo;
import com.portfolio.repositories.ProjectRepo;
import com.portfolio.repositories.SkillRepo;



@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	ProjectRepo pRepo;
	
	@Autowired
	ProfileRepo profileRepo;
	
	@Autowired
	SkillRepo skillRepo;
	
	@Autowired
	ImageService iservice;
	
	@Value("${project.image}")
	private String path;
	
	@GetMapping("/home")
	public String home(Model model) {
	    model.addAttribute("project", new Project()); 	
	    model.addAttribute("profile", new profile());
	    model.addAttribute("skill", new Skill());
		return "admin";	
	}
	//add project page
	
	@PostMapping("/project")
	public String addProject(@RequestParam("image") MultipartFile file,  @ModelAttribute(value = "project") Project project, Model model
			) throws IOException {
		String fileName = this.iservice.uploadImage(path, file);
		project.setPimage(fileName);
		this.pRepo.save(project);
		return "redirect:/admin/home";
		
	}
	//all project
	@GetMapping("/projects")
	public String projects(Model model) {
		model.addAttribute("project", this.pRepo.findAll());
		return "projects";	
	}
	
	//add profile
	@PostMapping("/profile")
	public String addProfile(@RequestParam("image") MultipartFile file,  @ModelAttribute(value = "profile") profile profile, Model model
			) throws IOException {
		String fileName = this.iservice.uploadImage(path, file);
		profile.setPimage(fileName);

		this.profileRepo.save(profile);
		return "redirect:/admin/home";
		
	}
	//add skill
	@PostMapping("/skill")
	public String addskill(@RequestParam("image") MultipartFile file,  @ModelAttribute(value = "skill") Skill skill, Model model
			) throws IOException {
		String fileName = this.iservice.uploadImage(path, file);

		skill.setPimage(fileName);
		
		this.skillRepo.save(skill);
		return "redirect:/admin/home";
		
	}
	
	@GetMapping("/skill")
	public String skill(Model model) {
		model.addAttribute("skill", this.skillRepo.findAll());
		return "Adminskill";	
	}
	
	
	
	
	

}
