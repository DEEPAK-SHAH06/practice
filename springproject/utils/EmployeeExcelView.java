package com.bway.springproject.utils;

import java.util.List;
import java.util.Map;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.bway.springproject.model.Department;
import com.bway.springproject.model.Employee;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmployeeExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(
			Map<String, Object> model, 
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) 
					throws Exception {

		//1. define your own excel file name
		response.addHeader("Content-Disposition", "attachment;filename=employee.xls");
		
		//2. read data given by Controller
		@SuppressWarnings("unchecked")
		List<Employee> list = (List<Employee>) model.get("elist");
		
		//3. create one sheet
		Sheet sheet = workbook.createSheet("Employee");
		
		//4. create row#0 as header
		setHead(sheet);
		
		//5. create row#1 onwards from List<T> 
		setBody(sheet,list);
	}

	private void setHead(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("FULL NAME");
		row.createCell(2).setCellValue("LAST NAME");
		row.createCell(3).setCellValue("GENDER");
		row.createCell(5).setCellValue("PHONE");
//		row.createCell(6).setCellValue("DOB");
		row.createCell(7).setCellValue("EMAIL");
		row.createCell(8).setCellValue("SALARY");
		row.createCell(9).setCellValue("COMPANY NAME");
		row.createCell(10).setCellValue("POST");
		
	}
	
	private void setBody(Sheet sheet, List<Employee> list) {
		int rowNum = 1;
		for(Employee spec : list) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(spec.getId());
			row.createCell(1).setCellValue(spec.getFname());
			row.createCell(2).setCellValue(spec.getLname());
			row.createCell(3).setCellValue(spec.getGender());
			row.createCell(5).setCellValue(spec.getPhone());
//			row.createCell(6).setCellValue(spec.getDob());
			row.createCell(7).setCellValue(spec.getEmail());
			row.createCell(8).setCellValue(spec.getSalary());
			row.createCell(9).setCellValue(spec.getCompanyName());
			row.createCell(10).setCellValue(spec.getPost());
		}
	}

}
