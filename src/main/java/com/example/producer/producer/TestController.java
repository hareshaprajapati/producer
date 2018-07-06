package com.example.producer.producer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "getDataFallBack")
	public Employee firstPage() {
		System.out.println("Inside FirstPage()");
		Employee emp = new Employee();
		emp.setName("emp1");
		emp.setDesignation("manager");
		emp.setEmpId("1");
		emp.setSalary(3000);
		if(emp.getName().equalsIgnoreCase("emp1"))
			throw new RuntimeException();
		return emp;
	}
	public Employee getDataFallBack(){
		System.out.println("Inside getDataFallBack()");
		Employee emp = new Employee();
		emp.setName("fall back emp1");
		emp.setDesignation("fall back manager");
		emp.setEmpId("fall back 1");
		emp.setSalary(9000);

		return emp;
	}

}