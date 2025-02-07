package com.example.employee.Serviceimpl;

import com.example.employee.Model.Employee;
import com.example.employee.Repository.EmployeeRepo;
import com.example.employee.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceimpl implements EmployeeService {

@Autowired
private EmployeeRepo repo;

    @Override
    public Integer save(Employee e) {
        repo.save(e);

        return e.getId() ;
    }

    @Override
    public List<Employee> gellAll() {
        return repo.findAll();
    }

    @Override
    public void deleteId(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public Optional<Employee> getById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public void updateEmp(Employee e) {
        repo.save(e);
    }
}
