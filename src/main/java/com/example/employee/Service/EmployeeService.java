package com.example.employee.Service;

import com.example.employee.Model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public Integer save(Employee e);


    public List<Employee> gellAll();

    public void  deleteId(Integer id);

    public Optional<Employee> getById(Integer id);

    public void  updateEmp(Employee e);

}
