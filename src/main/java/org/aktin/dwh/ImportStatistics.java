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

	public long getStartTime();
	public Long getLastImportTime();
	public Long getLastFailureTime();

	public int getValidationErrorCount();
	public int getImportErrorCount();
	public int getImportOkCount();

	/**
	 * Get a limited number of last errors. The number of errors
	 * is implementation dependent.
	 * @return list of exceptions
	 */
	public Iterable<String> getLastErrors();

	public void addError(boolean valid, String cause);
	public void addSuccess();
}
