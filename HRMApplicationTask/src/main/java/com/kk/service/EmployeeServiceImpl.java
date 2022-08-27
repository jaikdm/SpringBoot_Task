package com.kk.service;

import com.kk.dao.EmployeeDaoImpl;
import com.kk.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl {

    @Autowired
    EmployeeDaoImpl employeeDaoImpl;

    public Employee signUp(Employee employee) {
        return employeeDaoImpl.signUp(employee);
    }

    public List<Employee> getAllData() {
        return employeeDaoImpl.getAllData();
    }

    public boolean signIn(String empEmailId, String empPassword){
        return employeeDaoImpl.signIn(empEmailId,empPassword);

    }

    public Optional<Employee> getDataById(int empId) {
        return employeeDaoImpl.getDataById(empId);
    }

    public List<Employee> getDataByName(String empName){
        //  return employeeRepoImpl.findAll().stream().filter(emp->emp.getEmpName().equals(empName)).collect(Collectors.toList());

        return employeeDaoImpl.getDataByName(empName);
    }

    public Employee getDataByContactNumber(long empContactNumber){
        //  return employeeRepoImpl.findAll().stream().filter(emp->emp.getEmpContactNumber()==empContactNumber).collect(Collectors.toList());

        return employeeDaoImpl.getDataByContactNumber(empContactNumber);
    }

    public Employee getDataByEmailId(String empEmailId){
        //  return employeeRepoImpl.findAll().stream().filter(emp->emp.getEmpEmailId().equals(empEmailId)).collect(Collectors.toList());

        return employeeDaoImpl.getDataByEmailId(empEmailId);
    }

    // Code for getDataByUsingAnyInput

   /* public List<Employee> getDataByAnyInput(String empName,long empContactNumber,String empEmailId, int empAge,String empAddress){

        return employeeDaoImpl.getDataByAnyInput(empName,empContactNumber,empEmailId,empAge,empAddress);
    }*/

    public List<Employee> filterDataBySalary(double empSalary) {
       // return getAllData().stream().filter(emp->emp.getEmpSalary()>=empSalary).collect(Collectors.toList());
        return employeeDaoImpl.filterDataBySalary(empSalary);
    }

    public List<Employee> sortByName() {
       // return getAllData().stream().sorted((e1,e2)->e1.getEmpName().toLowerCase().compareTo(e2.getEmpName().toLowerCase())).collect(Collectors.toList());
        return employeeDaoImpl.sortByName();
    }

    public List<Employee> sortBySalary() {
     //   return getAllData().stream().sorted(Comparator.comparingDouble(Employee::getEmpSalary)).collect(Collectors.toList());
        return employeeDaoImpl.sortBySalary();
    }

    public List<Employee> sortByAge() {
     //   return getAllData().stream().sorted(Comparator.comparingLong(Employee::getEmpAge)).collect(Collectors.toList());
        return employeeDaoImpl.sortByAge();
    }

    public List<Employee> sortByDOB() {
       // return getAllData().stream().sorted((e1, e2)->e1.getEmpDOB().compareTo(e2.getEmpDOB())).collect(Collectors.toList());
        return employeeDaoImpl.sortByDOB();
    }


    public Employee updateData(Employee employee) {
        return employeeDaoImpl.updateData(employee);
    }

    public void deleteDataById(int empId) {
        employeeDaoImpl.deleteDataById(empId);
    }

    public void deleteAllData(){
        employeeDaoImpl.deleteAllData();
    }

}
