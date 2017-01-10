package org.aktin.report;

import java.time.Instant;

import org.aktin.report.GeneratedReport;

/**
 * Generated report within persitent storage
 * @author R.W.Majeed
 *
 */
public interface ArchivedReport extends GeneratedReport {

	public enum Status{
		Waiting, Completed, Failed
	}
	/**
	 * Get the id of the generated report within the archive.
	 * @return unique id
	 */
	int getId();
	String getUserId();
	Instant getCreatedTimestamp();

	Status getStatus();
}
