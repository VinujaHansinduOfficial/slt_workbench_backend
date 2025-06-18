package com.example.backend.Repo;

import com.example.backend.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(nativeQuery = true, value =
            "SELECT e1.employee_number, e1.employeename, e1.supervisor_name " +
                    "FROM workflow_db.employee e1 " +
                    "WHERE LOWER(e1.employeename) = LOWER(:name) " +
                    "AND LOWER(e1.supervisor_name) <> 'board of directors' " +
                    "AND LOWER(e1.employeename) <> 'board of directors' " +

                    "UNION ALL " +

                    "SELECT e2.employee_number, e2.employeename, e2.supervisor_name " +
                    "FROM workflow_db.employee e1 " +
                    "JOIN workflow_db.employee e2 ON LOWER(e1.supervisor_name) = LOWER(e2.employeename) " +
                    "WHERE LOWER(e1.employeename) = LOWER(:name) " +
                    "AND LOWER(e1.supervisor_name) <> 'board of directors' " +
                    "AND LOWER(e2.supervisor_name) <> 'board of directors' " +
                    "AND LOWER(e2.employeename) <> 'board of directors' " +

                    "UNION ALL " +

                    "SELECT e3.employee_number, e3.employeename, e3.supervisor_name " +
                    "FROM workflow_db.employee e1 " +
                    "JOIN workflow_db.employee e2 ON LOWER(e1.supervisor_name) = LOWER(e2.employeename) " +
                    "JOIN workflow_db.employee e3 ON LOWER(e2.supervisor_name) = LOWER(e3.employeename) " +
                    "WHERE LOWER(e1.employeename) = LOWER(:name) " +
                    "AND LOWER(e1.supervisor_name) <> 'board of directors' " +
                    "AND LOWER(e2.supervisor_name) <> 'board of directors' " +
                    "AND LOWER(e3.supervisor_name) <> 'board of directors' " +
                    "AND LOWER(e3.employeename) <> 'board of directors' " +

                    "UNION ALL " +

                    "SELECT e4.employee_number, e4.employeename, e4.supervisor_name " +
                    "FROM workflow_db.employee e1 " +
                    "JOIN workflow_db.employee e2 ON LOWER(e1.supervisor_name) = LOWER(e2.employeename) " +
                    "JOIN workflow_db.employee e3 ON LOWER(e2.supervisor_name) = LOWER(e3.employeename) " +
                    "JOIN workflow_db.employee e4 ON LOWER(e3.supervisor_name) = LOWER(e4.employeename) " +
                    "WHERE LOWER(e1.employeename) = LOWER(:name) " +
                    "AND LOWER(e1.supervisor_name) <> 'board of directors' " +
                    "AND LOWER(e2.supervisor_name) <> 'board of directors' " +
                    "AND LOWER(e3.supervisor_name) <> 'board of directors' " +
                    "AND LOWER(e4.supervisor_name) <> 'board of directors' " +
                    "AND LOWER(e4.employeename) <> 'board of directors' " +

                    "UNION ALL " +

                    "SELECT e5.employee_number, e5.employeename, e5.supervisor_name " +
                    "FROM workflow_db.employee e1 " +
                    "JOIN workflow_db.employee e2 ON LOWER(e1.supervisor_name) = LOWER(e2.employeename) " +
                    "JOIN workflow_db.employee e3 ON LOWER(e2.supervisor_name) = LOWER(e3.employeename) " +
                    "JOIN workflow_db.employee e4 ON LOWER(e3.supervisor_name) = LOWER(e4.employeename) " +
                    "JOIN workflow_db.employee e5 ON LOWER(e4.supervisor_name) = LOWER(e5.employeename) " +
                    "WHERE LOWER(e1.employeename) = LOWER(:name) " +
                    "AND LOWER(e1.supervisor_name) <> 'board of directors' " +
                    "AND LOWER(e2.supervisor_name) <> 'board of directors' " +
                    "AND LOWER(e3.supervisor_name) <> 'board of directors' " +
                    "AND LOWER(e4.supervisor_name) <> 'board of directors' " +
                    "AND LOWER(e5.supervisor_name) <> 'board of directors' " +
                    "AND LOWER(e5.employeename) <> 'board of directors'"
    )
    List<Map<String, Object>> findSupervisorHierarchy(@Param("name") String name);
}
