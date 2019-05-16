package com.jwt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
//import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.jwt.model.Employee;
import com.jwt.model.Login;
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
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
		if (employee.getId() == 0) { // if employee id is 0 then creating the
			// employee other updating the employee
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
	
	public ModelAndView loginEmployee(@ModelAttribute Employee employee) 
	
	{
		System.out.println("Welcome.........");
		if (employee.getId() == 0) { // if employee id is 0 then creating the
			// employee other updating the employee
			//employeeService.addEmployee(employee);
			System.out.println("Login Succesfull");
			return new ModelAndView("log");
			
			//return new ModelAndView("redirect:/");
		} else {
			//employeeService.updateEmployee(employee);
			System.out.println("Login UnSuccesfull");
		}
		return new ModelAndView("redirect:/");
	}
	
	
	
	
	
	/* @RequestMapping(value ="/loginSuccess" ,method=RequestMethod.POST)
	public ModelAndView loginSuccess( @ModelAttribute("studentCredential") Login login,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return new ModelAndView("login");
		}

		ModelAndView modelAndView = new ModelAndView("welcome");
		Employee employee = getEmployeeService().validateStudentCredential(login.getName(), login.getPassword());
		if(employee!= null){
			modelAndView.addObject("Employee", employee);
			return modelAndView;
		}else{
			 modelAndView = new ModelAndView("notFound");
		}
		return modelAndView;
	}*/
	 
	 
	
	
	
	
	
	
	/*
	 * @RequestMapping(value ="/loginSuccess" ,method=RequestMethod.POST) public
	 * ModelAndView loginSuccess(@Valid @ModelAttribute("studentCredential") Login
	 * studentCredential,BindingResult bindingResult){
	 * if(bindingResult.hasErrors()){ return new ModelAndView("login"); }
	 * 
	 * ModelAndView modelAndView = new ModelAndView("welcome"); Employee employee =
	 * employeeService().validateStudentCredential(login.getName(),
	 * studentCredential.getPassword()); if(employeeId!= null){
	 * modelAndView.addObject("student", employee); return modelAndView; }else{
	 * modelAndView = new ModelAndView("notFound"); } return modelAndView; }
	 * 
	 */
	
	
	
	
	

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