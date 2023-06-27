package ru.skypro.lessons.springboot.weblibrary2.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.skypro.lessons.springboot.weblibrary2.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrary2.dto.ReportDTO;
import ru.skypro.lessons.springboot.weblibrary2.pojo.Employee;
import ru.skypro.lessons.springboot.weblibrary2.pojo.Report;
import ru.skypro.lessons.springboot.weblibrary2.dto.ReportDTO;
import ru.skypro.lessons.springboot.weblibrary2.pojo.Report;


import java.util.List;
import java.util.Optional;

public interface ReportRepository extends JpaRepository<Report, Integer> {
    @Query("SELECT new ru.skypro.lessons.springboot.weblibrary2.dto.ReportDTO(p.id, count(e.id), max(e.salary), min(e.salary), avg(e.salary)) FROM Employee e left join Position p on p.id = e.position.id GROUP BY p.id")
    List<ReportDTO> createReport();

}
