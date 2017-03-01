package org.aktin.dwh;

/**
 * CDA import statistics
 *
 * @author R.W.Majeed
 *
 */
public interface ImportStatistics {

	/**
	 * Reset the statistics and start timestamp.
	 */
	public void reset();

	public long getStartupTime();
	public Long getLastImportTime();
	public Long getLastFailureTime();

	public int getValidationErrorCount();
	public int getImportErrorCount();
	public int getImportOkCount();

	public Throwable getLastError();

	public void addError(boolean valid, Throwable cause);
	public void addSuccess();
}
