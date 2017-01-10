package org.aktin.report;

import java.nio.file.Path;
import java.time.Instant;

public interface GeneratedReport extends ReportInfo{
	/**
	 * Media Type (MIME) for the report data.
	 * @return media type
	 */
	String getMediaType();
	/**
	 * Physical location of the report data. For the media type, see {@link #getMediaType()}.
	 * @return path location of the report data.
	 */
	Path getLocation();
	/**
	 * Timestamp when the report was generated
	 * @return timestamp
	 */
	Instant getDataTimestamp();
}
