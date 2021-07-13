package org.aktin.report;

import java.io.IOException;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;

import org.aktin.report.GeneratedReport;

/**
 * Generated report within persitent storage
 * @author R.W.Majeed
 *
 */
public interface ArchivedReport extends GeneratedReport {

	public enum Status{
		Waiting, Completed, InsufficientData, Timeout, Failed
	}
	/**
	 * Get the id of the generated report within the archive.
	 * @return unique id
	 */
	int getId();
	String getUserId();
	Instant getCreatedTimestamp();

	Status getStatus();

	/**
	 * Create the report result asynchronously
	 *
	 * @param manager report manager
	 * @return completable future
	 * @throws IOException immediate failure
	 */
	CompletableFuture<Void> createAsync(ReportManager manager) throws IOException;
}
