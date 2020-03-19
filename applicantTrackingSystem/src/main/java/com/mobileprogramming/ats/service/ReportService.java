package com.mobileprogramming.ats.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.mobileprogramming.ats.dao.CandidateRepository;
import com.mobileprogramming.ats.model.Candidate;
import com.mobileprogramming.ats.model.ReportBean;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/*
 * @Service public class ReportService {
 * 
 * @Autowired private CandidateRepository candidateRepository;
 * 
 * 
 * public String exportReport(String reportFormat) throws FileNotFoundException,
 * JRException { String path="D:\\Upload_CV\\Report";
 * System.out.println("data getting"); List<Candidate>
 * candidatedetails=candidateRepository.finObjects(); for (Candidate reportBean
 * : candidatedetails) { System.out.println(reportBean.getName()); }
 * 
 * 
 * System.out.println("data get");
 * 
 * //Load file and compile it File file=ResourceUtils.
 * getFile("C:\\Users\\Java Developer\\git\\jitesh\\applicantTrackingSystem\\src\\main\\resources\\candidate.jrxml"
 * ); JasperReport
 * jasperReport=JasperCompileManager.compileReport(file.getAbsolutePath());
 * System.out.println("file compile");
 * 
 * 
 * JRBeanCollectionDataSource dataSource= new
 * JRBeanCollectionDataSource((Collection<?>) candidatedetails);
 * System.out.println("datasource get"); Map<String, Object> parameters= new
 * HashMap<>(); parameters.put("createdBy", "MobileProgramming.com");
 * System.out.println("param added"); JasperPrint jasperPrint=
 * JasperFillManager.fillReport(jasperReport, parameters, dataSource);
 * System.out.println("printed"); if(reportFormat.equalsIgnoreCase("html")) {
 * JasperExportManager.exportReportToHtmlFile(jasperPrint,path+"\\report.html");
 * } if(reportFormat.equalsIgnoreCase("pdf")) {
 * JasperExportManager.exportReportToPdfFile(jasperPrint,path+"\\reportpdf.pdf")
 * ; }
 * 
 * return "report generated in path:"+path; }
 * 
 * 
 * }
 */