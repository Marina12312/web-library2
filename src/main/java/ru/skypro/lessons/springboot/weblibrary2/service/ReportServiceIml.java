package ru.skypro.lessons.springboot.weblibrary2.service;

import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibrary2.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrary2.pojo.Report;
import ru.skypro.lessons.springboot.weblibrary2.repository.EmployeeRepository;
import ru.skypro.lessons.springboot.weblibrary2.repository.ReportRepository;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;
    private final EmployeeRepository employeeRepository;
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    public ReportServiceImpl(ReportRepository reportRepository, EmployeeRepository employeeRepository, EmployeeService employeeService, EmployeeMapper employeeMapper) {
        this.reportRepository = reportRepository;
        this.employeeRepository = employeeRepository;
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public Integer createReport() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("Report.json");
        Report report = new Report();

        String json = objectMapper.writeValueAsString(reportRepository.createReport());
        Files.writeString(Paths.get(file.getName()), json);

        report.setFile(file.getPath());
        reportRepository.save(report);
        report.setFile(report.getId() + file.getPath());
        return report.getId();


    }


    @Override
    public void upload(File file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<EmployeeDTO> employeeDTOS = objectMapper.readValue(file, new TypeReference<>() {
        };
        employeeService.addEmployee(employeeDTOS);

    }

    @Override
    public Report getReportById(int id) {
        return reportRepository.findById(id)
                .orElseThrow();
    }

    private static String readTextFromFile(String fileName) {
        Path path = Paths.get(fileName);
        try {
            return Files.lines(path)
                    .collect(Collectors.joining());
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "";
        }
    }

    private static void writeTextToFile(String text, String fileName) {
        Path path = Paths.get(fileName);
        try {
            Files.write(path, text.getBytes(StandardCharsets.UTF_8));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}