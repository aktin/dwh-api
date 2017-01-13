package org.aktin.report;

import java.io.IOException;

import org.aktin.report.GeneratedReport;

/**
 * Persistent storage for generated reports.
 *
 * @author R.W.Majeed
 *
 */
public interface ReportArchive{
	void setReportFailure(int id, String description, Throwable cause) throws IOException;
	ArchivedReport setReportResult(int id, GeneratedReport report) throws IOException;
	
	/**
	 * Add a report to the archive. Returns unique id. The report may not have been generated yet.
	 * @param report report info to create
	 * @param userId user id
	 * @return report id within the archive
	 * @throws IOException if the report could not be added
	 */
	ArchivedReport addReport(ReportInfo report, String userId) throws IOException;

	/**
	 * Retrieve a report by it's id
	 * @param id id of the generated report
	 * @return report data
	 */
	ArchivedReport get(int id);

	/** 
	 * Calculate the total number of available generated reports.
	 * @return number of reports
	 */
	int size();

	/** Remove the specified report from the list of accessible reports. The
	 * report should be moved to a write only archive and is no longer accessible
	 * via getReports.
	 * @param reportId report id to delete
	 */
	void deleteReport(int reportId) throws IOException;

	Iterable<? extends ArchivedReport> reports();
}
