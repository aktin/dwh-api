package org.aktin.report;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

class BasicReportInfo implements ReportInfo{
	private Report report;
	private Instant start;
	private Instant end;
	private Map<String, String> prefs;

	public BasicReportInfo(Report report, Instant startTime, Instant endTime){
		this.report = report;
		this.start = startTime;
		this.end = endTime;
		this.prefs = new HashMap<>();
	}
	@Override
	public Instant getStartTimestamp() { return start; }

	@Override
	public Instant getEndTimestamp() { return end; }

	@Override
	public String getTemplateId() { return report.getId(); }

	@Override
	public String getTemplateVersion() { return report.getVersion(); }

	@Override
	public Map<String, String> getPreferences() {
		return prefs;
	}

}
