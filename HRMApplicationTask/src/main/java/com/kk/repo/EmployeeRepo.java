package com.kk.repo;

import com.kk.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

    // Write Custom Methods here...

    /*  1. SignUp
        2. SignIn
        3. getDataById
        4. getAllData
        5. getDataByName
        6. getDataByContactNumber
        7. getDataByEmailId
        8. getDataByUsingAnyInput
        9. filterDataBySalary
        10. sortByName
        11. sortBySalary
        12. sortByAge
        13. sortByDOB
        14. updateData
        15. deleteById
        16. deleteAllData*/

    // here I used List bcoz in our database there might be multiple records for same names
    public List<Employee> findByEmpName(String empName);

    // here I provided Unique key so not used List
    public Employee findByEmpContactNumber(long empContactNumber);

    // here I provided Unique key so not used List
    public Employee findByEmpEmailId(String empEmailId);

   // public List<Employee> findByAnyInput(String empName,long empContactNumber,String empEmailId, int empAge,String empAddress);
}
