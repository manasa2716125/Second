package com.jwt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jwt.model.Login;
import com.jwt.model.Employee;
import com.jwt.service.EmployeeService;

@Controller
public class EmployeeController {

	private static final Logger logger = Logger
			.getLogger(EmployeeController.class);

	public EmployeeController() {
		System.out.println("EmployeeController()");
	}

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/")
	public ModelAndView listEmployee(ModelAndView model) throws IOException {
		List<Employee> listEmployee = employeeService.getAllEmployees();
		model.addObject("listEmployee", listEmployee);
		model.setViewName("home");
		return model;
	}

	@RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Employee employee = new Employee();
		model.addObject("employee", employee);
		model.setViewName("EmployeeForm");
		return model;
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@Valid @ModelAttribute @Validated Employee employee,BindingResult result, Model model) {
		
		
			
		if (employee.getId() == 0) { 
			if (result.hasErrors()) {
				return new ModelAndView("EmployeeForm");
			}
			 model.addAttribute("name", employee.getName());
		      model.addAttribute("age", employee.getAge());
		      //model.addAttribute("id", employee.getId());
		      
		      model.addAttribute("password", employee.getPassword());
		      model.addAttribute("email", employee.getEmail());
		      model.addAttribute("dateOfBirth", employee.getDateOfBirth());
		      
		      
		      
			employeeService.addEmployee(employee);
		} else {
			employeeService.updateEmployee(employee);
		}
		return new ModelAndView("redirect:/");
	}
	
	
	
	
	
	
	@RequestMapping(value = "/newlogin", method = RequestMethod.GET)
	public ModelAndView loginContact(ModelAndView model) {
		Login login = new Login();
		model.addObject("login", login);
		model.setViewName("LoginForm");
		return model;
	}
	
	@RequestMapping(value = "/loginEmployee", method = RequestMethod.POST)
	
	public ModelAndView loginEmployee(@Valid @ModelAttribute @Validated Employee employee,BindingResult result, Model model) 
	
	{
		
		System.out.println("Welcome.........");
		if (employee.getId() == 0 ) { 
			if(result.hasErrors())
			{
			model.addAttribute("name",employee.getName());
			model.addAttribute("password",employee.getPassword());
			}
			System.out.println("Login Succesfull");
			return new ModelAndView("log");
			
			
			
			
		} else {
			
			System.out.println("Login UnSuccesfull");
		}
		return new ModelAndView("redirect:/");
	}
	
	
	
	
	

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		employeeService.deleteEmployee(employeeId);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		Employee employee = employeeService.getEmployee(employeeId);
		ModelAndView model = new ModelAndView("EmployeeForm");
		model.addObject("employee", employee);

		return model;
	}

}