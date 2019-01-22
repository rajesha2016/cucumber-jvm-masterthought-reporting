package com.framework.libraries;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;

/**
 * @author r.moharana This class executed at the end of execution and generates
 *         report It merge individual report into sigle report and generate very
 *         good html report After execution go to target/cucumber-html-reports
 *         and open overview-feature.html file in browser
 */
public class AutomtationReportGeneration {

	@SuppressWarnings("unused")
	public static void main(String arg[]) {

		File reportOutputDirectory = new File("target");
		File generatedReport = new File("./target/cucumber-parallel/");
		File[] fileList = generatedReport.listFiles();
		List<String> jsonFiles = new ArrayList<>();
		if (fileList.length == 0) {
			System.out.println("No report generated");
		}
		for (File file : fileList) {
			jsonFiles.add(file.getPath());
		}

		String projectName = "Automation Test";

		Configuration configuration = new Configuration(reportOutputDirectory, projectName);

		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		Reportable result = reportBuilder.generateReports();

	}
}
