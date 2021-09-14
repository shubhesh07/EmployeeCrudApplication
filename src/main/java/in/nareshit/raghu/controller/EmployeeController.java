package in.nareshit.raghu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.nareshit.raghu.entity.Employee;
import in.nareshit.raghu.service.IEmployeeService;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService service; //HAS-A
	
	@GetMapping("/register")
	public String showRegister() {
		return "EmployeeRegister";
	}
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute Employee employee, Model model) {
		Integer id=service.saveEmployee(employee);
		String message = "Employee '"+id+"' Created";
		model.addAttribute("message" ,message);
		return "EmployeeRegister";
		
	}
	@GetMapping("/all")
	public String viewAllEmployees(Model model) {
	List<Employee> list = service.getAllEmployees();
	model.addAttribute("list", list);
	return "EmployeeData";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam Integer id, Model model) {
		service.deleteEmployee(id);
		String message = "Employee '"+id+"' Deleted";
		model.addAttribute("message" ,message);
		
		List<Employee> list = service.getAllEmployees();
		model.addAttribute("list", list);
		return "EmployeeData";
	}
	
	@GetMapping("/edit")
	public String showEmployeeEdit(@RequestParam Integer id, Model model) {
		Employee employee=service.getoneEmployee(id);
		model.addAttribute("employee",employee);
		return "EmployeeEdit";
	}
	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute Employee employee) {
		service.updateEmployee(employee);
		return "redirect:all";
	}
	
}
