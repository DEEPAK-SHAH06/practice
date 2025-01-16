package com.bway.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bway.springproject.model.Department;
import com.bway.springproject.service.DepartmentService;
import com.bway.springproject.utils.DepartmentExcelView;
import com.bway.springproject.utils.DepartmentPdfView;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService deptService;

	@GetMapping("/add")
	public String getDepartment(HttpSession session) {
		if(session.getAttribute("activeuser")==null) {
			return "LoginForm";
		}
		return "DepartmentForm";
	}
	
	@PostMapping("/add")
	public String postDepartment(@ModelAttribute Department dept) {
		deptService.addDept(dept);
		return "DepartmentForm";
	}
	
	@GetMapping("/list")
	public String getAll(Model model,HttpSession session) {
		if(session.getAttribute("activeuser")==null) {
			return "LoginForm";
		}
		model.addAttribute("dlist",deptService.getAllDepts());
		return "DepartmentListForm";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		deptService.deleteDept(id);
		return "redirect:list";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam("id") int id,Model model ) {
		model.addAttribute("dModel",deptService.getDeptById(id));
		return "DepartmentEditForm";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Department dept) {
		
		deptService.updateDept(dept);
		return "redirect:list";
	}
	
	@GetMapping("/excel")
	public ModelAndView excel() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("dlist",deptService.getAllDepts());
		mv.setView(new DepartmentExcelView());
		return mv;
	}
	
	@GetMapping("/pdf")
	public ModelAndView pdf() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("dlist",deptService.getAllDepts());
		mv.setView(new DepartmentPdfView());
		return mv;
	}
	
}
