package org.aktin.dwh;

/**
 * CDA import statistics
 *
 * @author R.W.Majeed
 *
 */
public interface ImportSummary {

	/**
	 * Reset the statistics and start timestamp.
	 */
	public void reset();

	public long getStartTime();
	public Long getLastWriteTime();
	public Long getLastRejectTime();

	public int getImportedCount();
	public int getUpdatedCount();
	/**
	 * Get the number of documents rejected due to validation errors
	 * @return validation error cound
	 */
	public int getInvalidCount();
	/**
	 * Get the number of documents which failed during the import (should not happen)
	 * @return failure count
	 */
	public int getFailedCount();

	/**
	 * Get a limited number of last errors. The number of errors
	 * is implementation dependent.
	 * @return list of exceptions
	 */
	public Iterable<String> getLastErrors();

	/**
	 * Count a rejected document.
	 * @param templateId template id for the rejected document, or {@code null} if not known
	 * @param valid whether the document passed the validation step
	 * @param cause cause for the rejection. e.g. error message
	 */
	public void addRejected(String templateId, boolean valid, String cause);
	public void addCreated(String templateId);
	public void addUpdated(String templateId);
}
