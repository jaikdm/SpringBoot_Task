package com.kk.dao;

import com.kk.model.Employee;
import com.kk.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EmployeeDaoImpl {

    @Autowired
    EmployeeRepo employeeRepoImpl;


    public Employee signUp(Employee employee) {
        return employeeRepoImpl.save(employee);
    }

    public List<Employee> getAllData() {
        return employeeRepoImpl.findAll();
    }

    public boolean signIn(String empEmailId, String empPassword){
        boolean status = false;

        for (Employee employee: getAllData()){
            if (employee.getEmpEmailId().equals(empEmailId) && employee.getEmpPassword().equals(empPassword)){
                status = true;
            }
        }
        return status;

    }

    public Optional<Employee> getDataById(int empId) {
        return employeeRepoImpl.findById(empId);
    }

    public List<Employee> getDataByName(String empName){
        //  return employeeRepoImpl.findAll().stream().filter(emp->emp.getEmpName().equals(empName)).collect(Collectors.toList());

        return employeeRepoImpl.findByEmpName(empName);
    }

    public Employee getDataByContactNumber(long empContactNumber){
      //  return employeeRepoImpl.findAll().stream().filter(emp->emp.getEmpContactNumber()==empContactNumber).collect(Collectors.toList());

        return employeeRepoImpl.findByEmpContactNumber(empContactNumber);
    }

    public Employee getDataByEmailId(String empEmailId){
        //  return employeeRepoImpl.findAll().stream().filter(emp->emp.getEmpEmailId().equals(empEmailId)).collect(Collectors.toList());

        return employeeRepoImpl.findByEmpEmailId(empEmailId);
    }

    // Code for getDataByUsingAnyInput

    /*public List<Employee> getDataByAnyInput(String empName,long empContactNumber,String empEmailId, int empAge,String empAddress){

        return employeeRepoImpl.findByAnyInput(empName,empContactNumber,empEmailId,empAge,empAddress);
    }*/

    public List<Employee> filterDataBySalary(double empSalary) {
        return getAllData().stream().filter(emp->emp.getEmpSalary()>=empSalary).collect(Collectors.toList());
    }

    public List<Employee> sortByName() {
        return getAllData().stream().sorted((e1,e2)->e1.getEmpName().toLowerCase().compareTo(e2.getEmpName().toLowerCase())).collect(Collectors.toList());
    }

    public List<Employee> sortBySalary() {
        return getAllData().stream().sorted(Comparator.comparingDouble(Employee::getEmpSalary)).collect(Collectors.toList());
    }

    public List<Employee> sortByAge() {
        return getAllData().stream().sorted(Comparator.comparingLong(Employee::getEmpAge)).collect(Collectors.toList());
    }

    public List<Employee> sortByDOB() {
        return getAllData().stream().sorted((e1, e2)->e1.getEmpDOB().compareTo(e2.getEmpDOB())).collect(Collectors.toList());
    }


    public Employee updateData(Employee employee) {
        return employeeRepoImpl.save(employee);
    }

    public void deleteDataById(int empId) {
        employeeRepoImpl.deleteById(empId);
    }

    public void deleteAllData(){
        employeeRepoImpl.deleteAll();
    }

}
