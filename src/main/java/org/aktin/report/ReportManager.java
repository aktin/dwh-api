package org.aktin.report;

import java.io.IOException;
import java.nio.file.Path;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;

public interface ReportManager {

	Iterable<Report> reports();

	Report getReport(String id);

	CompletableFuture<? extends GeneratedReport> generateReport(Report report, Instant fromTimestamp, Instant endTimestamp,
			Path reportDestination) throws IOException;

}