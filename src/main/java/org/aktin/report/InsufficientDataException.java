package org.aktin.report;

import java.io.FileNotFoundException;
import java.util.concurrent.CompletableFuture;

/**
 * Checked exception to indicate that the data is insufficient to
 * generate the desired report. I.e. there are no patients for the
 * selected time frame.
 * <p>
 * Usually, this exception is generated during the asynchronous report
 * generation (e.g. via {@link ReportManager#generateReport(ReportInfo, java.nio.file.Path)}
 * and retrieved via the returned {@link CompletableFuture}.
 * </p>
 * @author R.W.Majeed
 *
 */
public class InsufficientDataException extends FileNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
