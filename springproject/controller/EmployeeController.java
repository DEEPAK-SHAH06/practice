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
import com.bway.springproject.model.Employee;
import com.bway.springproject.service.DepartmentService;
import com.bway.springproject.service.EmployeeService;
import com.bway.springproject.utils.DepartmentExcelView;
import com.bway.springproject.utils.DepartmentPdfView;
import com.bway.springproject.utils.EmployeeExcelView;
import com.bway.springproject.utils.EmployeePdfView;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private DepartmentService deptService;
	
	@GetMapping("/add")
	public String getEmployee(Model model,HttpSession session) {
		if(session.getAttribute("activeuser")==null) {
			return "LoginForm";
		}
		model.addAttribute("dlist",deptService.getAllDepts());
		return "EmployeeForm";
	}
	
	@PostMapping("/add")
	public String postEmployee(@ModelAttribute Employee emp) {
		empService.addEmp(emp);
		return "redirect:add";
	}
	
	@GetMapping("/list")
	public String getAll(Model model,HttpSession session) {
		if(session.getAttribute("activeuser")==null) {
			return "LoginForm";
		}
		model.addAttribute("elist",empService.getAllEmps());
		return "EmployeeListForm";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		empService.deleteEmp(id);
		return "redirect:list";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam("id") long id,Model model ) {
		model.addAttribute("dlist",deptService.getAllDepts());
		model.addAttribute("empModel",empService.getEmployeeById(id));
		return "EmployeeEditForm";
	}
	
	
	
	@PostMapping("/update")
	public String update(@ModelAttribute Employee emp) {
		
		empService.updateEmp(emp);
		return "redirect:list";
	}
	
	@GetMapping("/view")
	public String view(Model model,@RequestParam("id") long id) {
		
		model.addAttribute("dlist",deptService.getAllDepts());
		model.addAttribute("empModel",empService.getEmployeeById(id));
		return "EmployeeView";
	}
	
	@GetMapping("/excel")
	public ModelAndView excel() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("elist",empService.getAllEmps());
		mv.setView(new EmployeeExcelView());
		return mv;
	}
	
	@GetMapping("/pdf")
	public ModelAndView pdf() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("elist",empService.getAllEmps());
		mv.setView(new EmployeePdfView());
		return mv;
	}
}
