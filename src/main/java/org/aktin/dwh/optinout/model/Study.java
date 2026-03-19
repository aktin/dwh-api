package org.aktin.dwh.optinout.model;

import java.time.Instant;

public interface Study {

	/**
	 * Unique id (e.g. acronym) for the study. The id should consist only of URL-safe characters
	 * @return study id
	 */
	String getId();
	String getTitle();
	String getDescription();

	Instant getCreatedTimestamp();

	/**
	 * when the study was closed. {@code null} if still open
	 */
	Instant getClosedTimestamp();

	/**
	 * Get the participation option for this study.
	 * @return participation option
	 */
	Participation getParticipation();

	/**
	 * Get the method of SIC generation
	 * @return sic generation enum
	 */
	SICGeneration getSicGeneration();

	/**
	 * Get the generator of automatic SIC generation.
	 * @return generator name or {@code null} if no generator is used
	 */
	String getSicGenerator();

	/**
	 * Get the state of the generator.
	 * @return generator state (e.g. last generated SIC (sequence))
	 */
	String getSicGeneratorState();
}
