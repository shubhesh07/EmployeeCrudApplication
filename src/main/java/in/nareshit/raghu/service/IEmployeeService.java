package in.nareshit.raghu.service;


import java.util.List;

import org.springframework.stereotype.Service;

import in.nareshit.raghu.entity.Employee;
@Service
public interface IEmployeeService {
	List<Employee> getAllEmployees();
	Integer saveEmployee (Employee employee) ;
	void deleteEmployee(Integer id);
	Employee getoneEmployee(Integer id);
	void updateEmployee(Employee e);
	}
