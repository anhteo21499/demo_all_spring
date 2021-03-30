package com.example.v4.controllers;
import com.example.v4.models.Customer;
import com.example.v4.repositories.CustomerRepository;
import com.example.v4.services.excel.ExportConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class TestController {

    @Autowired
    private CustomerRepository customerRepository;


    @GetMapping("/users/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Customer> customers =customerRepository.findAll();

        ExportConfig excelExporter = new ExportConfig(customers);

        excelExporter.export(response);
    }

//    @PostMapping("/upload")
//    public List<Map<String, String>> upload(@RequestParam("file") MultipartFile file) throws Exception{
//        return readExcel.upload(file);
//    }

}
