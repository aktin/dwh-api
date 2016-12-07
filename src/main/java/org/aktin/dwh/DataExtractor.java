package org.aktin.dwh;

import java.io.IOException;
import java.nio.file.Path;
import java.sql.SQLException;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;

import javax.xml.transform.Source;

/**
 * Extract data from the data warehouse
 * 
 * @author R.W.Majeed
 *
 */
public interface DataExtractor {
	/**
	 * Extracts data to a directory. After return, the directory
	 * will contain the following files:
	 * <ul>
	 * 	<li>patients.txt</li>
	 *  <li>encounters.txt</li>
	 *  <li>[table_name].txt for each additional table
	 * </ul>
	 * <p>
	 * In case of a checked exception, it is guaranteed that no files and 
	 * directories are created.
	 * <p>
	 * @param fromTimestamp start timestamp for the data to extract
	 * @param endTimestamp end timestamp for the data to extract
	 * @param exportDescriptor descriptor what data to extract
	 * @return File names of the created files
	 * 
	 * @throws IOException error writing files
	 * @throws SQLException error while extracting data
	 */
	public CompletableFuture<ExtractedData> extractData(Instant fromTimestamp, Instant endTimestamp, Source exportDescriptor, Path destinationDir);

}
