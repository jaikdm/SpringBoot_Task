package com.kk.controller;

import com.kk.exception.DataNotFoundException;
import com.kk.model.Employee;
import com.kk.service.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/kk")
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody Employee employee) {
        log.info("############ Trying to SignUp for Employee " + employee.getEmpName());
        employeeServiceImpl.signUp(employee);
        return ResponseEntity.ok("Employee SignUp Done Successfully");
    }
    // ----------------------------------------------------------------------------------------

    /*@PostMapping("/savedata")
    public ResponseEntity<String> saveData(@PathVariable List<Employee> employeeList) {
        log.info("$$$$$$$$$$$$$ Employee list Of Data Size: "+ employeeList.size());
        employeeServiceImpl.getAllData();
        return ResponseEntity.ok("All Data Saved Successfully");
    }*/

    // ----------------------------------------------------------------------------------------

    @GetMapping("/getalldata")
    public ResponseEntity<List<Employee>> getAllData(){
        return ResponseEntity.ok(employeeServiceImpl.getAllData());
    }

    // ----------------------------------------------------------------------------------------

    @GetMapping("signin/{empEmailId}/{empPassword}")
    public ResponseEntity<Boolean> signIn(@PathVariable String empEmailId, @PathVariable String empPassword) {
        return ResponseEntity.ok(employeeServiceImpl.signIn(empEmailId,empPassword));
    }

    // ----------------------------------------------------------------------------------------

    @GetMapping("/getdatabyid/{empId}")
    public ResponseEntity<Optional<Employee>> getDataById(@PathVariable int empId){
        return ResponseEntity.ok(employeeServiceImpl.getDataById(empId));
    }

    // ----------------------------------------------------------------------------------------

    @GetMapping("/getdatabyname/{empName}")
    public ResponseEntity<List<Employee>> getDataByName(@PathVariable String empName) {
        return ResponseEntity.ok(employeeServiceImpl.getDataByName(empName));
    }

    // ----------------------------------------------------------------------------------------

    @GetMapping("/getdatabycontactnumber/{empContactNumber}")
    public ResponseEntity<Employee> getDataByContactNumber(@PathVariable long empContactNumber){
        return ResponseEntity.ok(employeeServiceImpl.getDataByContactNumber(empContactNumber));
    }

    // ----------------------------------------------------------------------------------------

    @GetMapping("/getdatabyemailid/{empEmailId}")
    public ResponseEntity<Employee> getDataByEmailId(@PathVariable String empEmailId){
        return ResponseEntity.ok(employeeServiceImpl.getDataByEmailId(empEmailId));
    }

    // ----------------------------------------------------------------------------------------

    /*@GetMapping("/getdatabyanyinput/{empName,empContactNumber,empEmailId,empAge,empAddress}")
    public ResponseEntity<List<Employee>> getDataByAnyInput(@PathVariable String empName, @PathVariable long empContactNumber, @PathVariable String empEmailId, @PathVariable int empAge, @PathVariable String empAddress){
        return ResponseEntity.ok(employeeServiceImpl.getDataByAnyInput(empName,empContactNumber,empEmailId,empAge,empAddress));
    }*/

    // ----------------------------------------------------------------------------------------

    @GetMapping("/filterdatabysalary/{empSalary}")
    public ResponseEntity<List<Employee>> filterDataBySalary(@PathVariable double empSalary) {
        return ResponseEntity.ok(employeeServiceImpl.filterDataBySalary(empSalary));
    }

    // ----------------------------------------------------------------------------------------

    @GetMapping("/sortbyname")
    public ResponseEntity<List<Employee>> sortByName() {
        return ResponseEntity.ok(employeeServiceImpl.sortByName());
    }

    // ----------------------------------------------------------------------------------------

    @GetMapping("/sortbysalary")
    public ResponseEntity<List<Employee>> sortBySalary(){
        return ResponseEntity.ok(employeeServiceImpl.sortBySalary());
    }

    // ----------------------------------------------------------------------------------------

    @GetMapping("/sortbyage")
    public ResponseEntity<List<Employee>> sortByAge(){
        return ResponseEntity.ok(employeeServiceImpl.sortByName());
    }

    // ----------------------------------------------------------------------------------------

    @GetMapping("/sortbydob")
    public ResponseEntity<List<Employee>> sortByDOB(){
        return ResponseEntity.ok(employeeServiceImpl.sortByDOB());
    }

    // ----------------------------------------------------------------------------------------

    @PutMapping("/updatedata/{empId}")
    public ResponseEntity<Employee> updateData(@PathVariable int empId, @RequestBody Employee employee) throws DataNotFoundException {
        // Exception code

        Employee employee1 = employeeServiceImpl.getDataById(empId).orElseThrow(()-> new DataNotFoundException("Customer ID Does Not Exist..."));

        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpAge(employee.getEmpAge());
        employee1.setEmpContactNumber(employee.getEmpContactNumber());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpEmailId(employee.getEmpEmailId());
        employee1.setEmpPassword(employee.getEmpPassword());

        return ResponseEntity.ok(employeeServiceImpl.updateData(employee1));
    }

    // ----------------------------------------------------------------------------------------

    @DeleteMapping("/deletedatabyid/{empId}")
    public ResponseEntity<String> deleteDataById(@PathVariable int empId){
        employeeServiceImpl.deleteDataById(empId);
        return ResponseEntity.ok("Data Deleted Successfully");
    }

    // ----------------------------------------------------------------------------------------

    @DeleteMapping("/deletealldata")
    public ResponseEntity<String> deleteAllData(){
        employeeServiceImpl.deleteAllData();
        return ResponseEntity.ok("All Data Deleted Successfully");
    }
}
