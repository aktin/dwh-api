package org.aktin.report;

import java.time.Instant;
import java.util.Map;

public interface ReportInfo {
	/**
	 * Start timestamp of the report interval
	 * @return timestamp
	 */
	Instant getStartTimestamp();
	/**
	 * End timestamp of the report interval
	 * @return timestamp
	 */
	Instant getEndTimestamp();
	/**
	 * Get the report template id. For the version, see {@link #getTemplateVersion()}.
	 * @return template id
	 */
	String getTemplateId();
	/**
	 * Get the version string for the report template indicated by {@link #getTemplateId()}
	 * @return version string
	 */
	String getTemplateVersion();
	/**
	 * Preferences used for the generation of the report. The preferences consist of
	 * key value pairs and include system preferences requested by the report template
	 * as well as configuration options which can be specified by the user (e.g. display
	 * configurations).
	 * @return preference map
	 */
	Map<String,String> getPreferences();

}
