package org.aktin.dwh;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;

import org.w3c.dom.Document;

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
	 * @param destinationDir directory where the data is stored
	 * @return completable future
	 * 
	 */
	public CompletableFuture<ExtractedData> extractData(Instant fromTimestamp, Instant endTimestamp, Source exportDescriptor, Path destinationDir);

	/**
	 * Extract a single patient encounter in XML form.
	 * @param encounterId encounter id to extract. The id will be matched against visit_mapping..
	 * @param rootElement qualified name of the XML root element which is expected for the returned document.
	 * @return completable future containing the XML document
	 * @throws IllegalArgumentException if the {@code rootElement} parameter is not understood.
	 * @throws FileNotFoundException if the encounter ID is not registered
	 */
	public CompletableFuture<Document> extractEncounterXML(String encounterId, QName rootElement) throws IllegalArgumentException, FileNotFoundException;
}