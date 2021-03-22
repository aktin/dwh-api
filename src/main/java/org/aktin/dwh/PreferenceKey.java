package org.aktin.dwh;

import org.aktin.dwh.optinout.PatientReference;

/**
 * Preferences keys for the data warehouse
 * 
 * @author R.W.Majeed
 *
 */
public enum PreferenceKey {
	commonName("local.cn"),
	organisationName("local.o"),
	organisationUnit("local.ou"),
	locality("local.l"),
	state("local.s"),
	country("local.c"),
	email("local.email"),
	/** Timezone. e.g. Europe/Berlin */
	timeZoneId("local.tz"),
	/** Language tag IETF BCP 47. e.g. de-DE or en-US */
	languageTag("local.language"),
	/** URL to reach this server from other computers within the same network. e.g. {@code http://srv1.subnet.local/} **/
	serverUrl("local.server.url"),
	i2b2Project("i2b2.project"),
	/** URL to the i2b2 PM service. Used for authentication and user management */
	i2b2ServicePM("i2b2.service.pm"),
	i2b2ServiceDomain("i2b2.service.domain"),
	// import.cda.debug.dir, import.cda.debug.level, i2b2.db.tz
	
	/** JNDI data source name which is also used by the i2b2 CRC cell */
	i2b2DatasourceCRC("i2b2.datasource.crc"),
	/** Timezone used in the i2b2 database. Usually not needed because the system timezone is used. */
	//i2b2DatabaseTimezone("i2b2.db.tz"),
	rScriptBinary("rscript.binary"),
	/** Location where generated reports are stored */
	reportDataPath("report.data.path"),
	/** Location to use for temporary files during report generation */
	reportTempPath("report.temp.path"),
	/** Boolean preference option to keep temporary files generated and used 
	 * during report compilation. These files are located in a sub-directory per 
	 * report in report.temp.path and are usually deleted upon report completion.*/
	reportDebugKeepTempFiles("report.debug.keeptempfiles"),
	/** Reports which are no longer needed in the database will be moved to the archive path. This is a write-only operation. */
	reportArchivePath("report.archive.path"),
	/** Location where query data will be stored locally */
	brokerDataPath("broker.data.path"),
	/** Queries which are no longer wanted in the database will be moved to the archive path. This is a write-only operation. */
	brokerArchivePath("broker.archive.path"),
	/** Space separated list of brokers to fetch queries from */
	brokerEndpointURI("broker.uris"),
	/** Space separated list of brokers to fetch queries from */
	brokerEndpointKeys("broker.keys"),
	/** Space separated list of brokers to fetch queries from */
	brokerIntervals("broker.intervals"),
	/** Interaction overrides for requests. Defaults to user. Can also be auto-reject, auto-allow. */
	brokerInteraction("broker.request.interaction"),
	/** Signature algorithm to sign repeating query request. The signatures
	 * are used by accept rules to make sure a repeating query is not modified
	 * since e.g. an accept rule was created.
	 */
	brokerSignatureAlgorithm("broker.signature.algorithm"),
	/** JNDI datasource name for non-i2b2 tables */
	datasource("db.datasource"),
	/** JNDI email session name to use for outbound messages */
	emailSession("email.session"),

	/** Location where uploaded data files (like p21) are stored */
	importDataPath("import.data.path"),
	/** Location where scripts to process uploaded data files are stored */
	importScriptPath("import.script.path"),
	/** Interval in milliseconds to check hang up of script execution */
	importScriptCheckInterval("import.script.check.interval"),

	/** URL to the wildfly management HTTP endpoint. Used to display log files, etc. */
	wildflyManagementURL("wildfly.management.url"),
	/** Wildfly management user. See {@link #wildflyManagementURL} */
	wildflyManagementUser("wildfly.management.user"),
	/** Wildfly management password. See {@link #wildflyManagementURL} */
	wildflyManagementPassword("wildfly.management.password"),	
	
	/** Type of the patient identification for the study manager. Allowed values: Patient, Visit, Encounter, Billing. See {@link PatientReference} */
	studyIdReference("study.id.reference"),
	/** Root numbers of the different reference types. Can be empty. */
	cdaPatientRootPreset("cda.patient.root.preset"),
	cdaEncounterRootPreset("cda.encounter.root.preset"),
	cdaBillingRootPreset("cda.billing.root.preset"),
	/** Label for the extension textfield of the study manager gui based on the reference type. */
	studyIdPatientLabel("study.id.patient.label"),
	studyIdEncounterLabel("study.id.encounter.label"),
	studyIdBillingLabel("study.id.billing.label"),
	/** Character for separating root and extension in case a root id has to be set manually and is not set in the preferences. */
	studyIdSeparator("study.id.separator"),
	/** Directory path where received CDA documents will be stored for debugging purposes. Must point to an existing directory. */
	importCdaDebugDir("import.cda.debug.dir"),
	/** Filter which documents will be stored for debugging. Possible values are {@code none}, {@code error}, {@code warning}, {@code info} or {@code all}.
	 * Only one value can be specified and the latter codes always include the previous levels. A value of {@code info} means, that the CDA is only stored if the OperationOutcome has at least one message of severity {@code informational} (or higher).
	 * If a directory is defined via {@link #importCdaDebugDir}, then the default level is {@code all}. If no directory is defined, the default level is {@code none}.
	 */
	importCdaDebugLevel("import.cda.debug.level"),
	/** Filter which messages are displayed in the OperationOutcome resources. 
	 * Uses the same values as in {@link #importCdaDebugLevel} with the only difference 
	 * that {@code info} and {@code all} produce the same effect (since OperationOutcome
	 * must always be returned). */
	importCdaFhirOutcomeLevel("import.cda.fhir.outcome.level"),
	
	pseudonymAlgorithm("pseudonym.algorithm"),
	pseudonymSalt("pseudonym.salt"),
	
	
	
	;

	private String key;
	private PreferenceKey(String key){
		this.key = key;
	}
	public String key(){
		return key;
	}
	
	/*
	local.name (W) local name for this site/clinic, 
	local.contact.name (W)
	local.contact.email (W)

	i2b2.project (R) i2b2 project id "Demo"
	i2b2.crc.ds (R) i2b2 jndi datasource "java:/QueryToolDemoDS"
	i2b2.lastimport (R) timestamp of last import


	query.notification.email (W) list of email addresses to receive notifications for queries
	query.result.dir (R)
	exchange.lastcontact (R) timestamp of last contact to broker via direct connection or received email timestamp
	exchange.method (W) https|email
	exchange.https.interval (W) interval in hours between polling connections to broker
	exchange.https.broker (W) server name of the AKTIN broker
	exchange.https.pool (W) server name of AKTIN pool
	exchange.inbox.address (W) email address to receive queries
	exchange.inbox.interval (W) interval in hours between checking for new emails
	exchange.inbox.server (W) server configuration to check for query emails
	exchange.inbox.port (W)
	exchange.inbox.protocol (W) [imap|pop3]
	exchange.inbox.user (W)
	exchange.inbox.password (WO) */
}
