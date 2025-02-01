package controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Department;
import repository.DepartmentRepository;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	
	 
	private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartmentRepository departmentrepository;
	
	
	
	public Department adddepartment(@RequestBody Department department)
	{
		Department dept1 = departmentrepository.adddepartment(department);
		return dept1;
	}
	@GetMapping
	public List<?> getall()
	{
		logger.info("Department find");
		return departmentrepository.findAll();
	}
	
	
	@GetMapping("/{departmentid}")
	public Department getbyid(@PathVariable Long id)
	{
		logger.info("department find by id", id);
		return departmentrepository.findById(id);
	}
}
