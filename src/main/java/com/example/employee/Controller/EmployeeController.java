package com.example.employee.Controller;

import com.example.employee.Model.Employee;
import com.example.employee.Serviceimpl.EmployeeServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeServiceimpl serviceimpl;

    @PostMapping("/saveon")
    public ResponseEntity<String> saveEmp(@RequestBody Employee emp){

        ResponseEntity<String> rs = null;
        try {

            Integer id=serviceimpl.save(emp);
            String body="your data saved with id  :" + id ;
            rs = new ResponseEntity<String>(body, HttpStatus.OK);

        }
        catch (Exception s){
            rs = new ResponseEntity<String>("unable to save data ", HttpStatus.INTERNAL_SERVER_ERROR);

            s.printStackTrace();
        }
        return rs;
    }
    @GetMapping("/emp")
    public ResponseEntity<?> getAllEmp(){
        ResponseEntity<?> rs= null;
        try {
            List<Employee> list = serviceimpl.gellAll();
            rs = new ResponseEntity<List<Employee>>( list,HttpStatus.OK);
        }
        catch(Exception e) {
            rs = new ResponseEntity<String>("unable to get data", HttpStatus.INTERNAL_SERVER_ERROR );
            e.printStackTrace();
        }
        return rs;
    }

    @DeleteMapping("/emp/{id}")
    public ResponseEntity<String> deleteByID(@PathVariable("id") Integer id) {
        ResponseEntity<String> rs = null;
        try {
            serviceimpl.deleteId(id);
            String body =" one data is deleted";
            rs = new ResponseEntity<String>(body,HttpStatus.OK);
        }
        catch (Exception e) {
            rs = new ResponseEntity<String>("Unable to delete data" ,HttpStatus.INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
        return rs;
    }

    @GetMapping("/emp/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        ResponseEntity<?> rs= null;
        try {
            Optional<Employee> e = serviceimpl.getById(id);
            if (e.isPresent()) {
                return new ResponseEntity<Employee>(e.get(), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<String>("Employee not found", HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e) {
            rs = new ResponseEntity<String>("unable to get data", HttpStatus.INTERNAL_SERVER_ERROR );
            e.printStackTrace();
        }
        return rs;
    }

    @PutMapping("/employee")
    public ResponseEntity<String> updateEmp( @RequestBody Employee emp ) {
        ResponseEntity<String> rs = null;
        try {
            serviceimpl.updateEmp(emp);
            String body ="your data successfully updated";
            rs = new ResponseEntity<String>(body ,HttpStatus.OK);
        }
        catch (Exception e) {
            rs = new ResponseEntity<String>("Employeee not Updated " , HttpStatus.INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
        return rs;
    }

}
