package org.aktin.report;

import java.io.IOException;
import java.nio.file.Path;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;

public interface ReportManager {

	Iterable<Report> reports();

	Report getReport(String id);

	/**
	 * Generate a report asynchronously.
	 *
	 * @param report report template
	 * @param fromTimestamp start timestamp
	 * @param endTimestamp end timestamp
	 * @param reportDestination destination for the generated report. Usually a file name.
	 * @return completable future receiving the report
	 * @throws IOException IO error
	 */
	@Deprecated
	CompletableFuture<? extends GeneratedReport> generateReport(Report report, Instant fromTimestamp, Instant endTimestamp,
			Path reportDestination) throws IOException;

	/**
	 * Generate a report asynchronously.
	 * 
	 * @param report report information
	 * @param reportDestination destination. Can be {@code null} to let the report manager create a temporary file/folder
	 * @return completable future
	 * @throws IOException IO Error
	 * @throws IllegalArgumentException if the reportInfo can not be used for report generation. e.g. a non-existing template id
	 */
	CompletableFuture<? extends GeneratedReport> generateReport(ReportInfo reportInfo, Path reportDestination) throws IOException, IllegalArgumentException;

}