package in.nareshit.raghu.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nareshit.raghu.entity.Employee;
import in.nareshit.raghu.repo.EmployeeRepository;
import in.nareshit.raghu.service.IEmployeeService;
@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private EmployeeRepository repo;

	
	public Integer saveEmployee(Employee employee) {
		employee=repo.save(employee);
		return employee.getId();
	}
	
	public List<Employee> getAllEmployees() {
		List<Employee> list=repo.findAll();
		return list;
	}
	
	
	public void deleteEmployee(Integer id) {
		repo.deleteById(id);
		
	}
	
	public Employee getoneEmployee(Integer id) {
		Optional<Employee> opt=repo.findById(id);
		if(opt.isPresent()) {
			Employee e=opt.get();
			return e;
		}
		return null;
		
		
	}
	
	public void updateEmployee(Employee e) {
		repo.save(e);
	}
}
