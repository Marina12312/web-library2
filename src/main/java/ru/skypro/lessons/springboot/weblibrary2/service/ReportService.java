package ru.skypro.lessons.springboot.weblibrary2.service;

import ru.skypro.lessons.springboot.weblibrary2.pojo.Report;

import java.io.File;
import java.io.IOException;

public interface ReportService {
    Integer createReport() throws IOException;

    void upload(File file) throws IOException, ClassNotFoundException;

    Report getReportById(int id);

}
