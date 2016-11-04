package org.aktin.report;

import org.aktin.report.GeneratedReport;

/**
 * Generated report within persitent storage
 * @author R.W.Majeed
 *
 */
public interface ArchivedReport extends GeneratedReport {
	/**
	 * Get the id of the generated report within the archive.
	 * @return unique id
	 */
	int getId();
}
