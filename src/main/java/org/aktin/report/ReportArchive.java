package org.aktin.report;

import java.io.IOException;

import org.aktin.report.GeneratedReport;

/**
 * Persistent storage for generated reports.
 *
 * @author R.W.Majeed
 *
 */
public interface ReportArchive extends Iterable<ArchivedReport>{

	/**
	 * Add a generated report to the archive. Returns unique id string.
	 * @param generated report
	 * @return report id within the archive
	 * @throws IOException if the report could not be added
	 */
	ArchivedReport addReport(GeneratedReport report) throws IOException;

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
	void deleteReport(String reportId) throws IOException;
}
