Common API for the AKTIN data warehouse
---------------------------------------

Generate XSD files:
```
"$JAVA_HOME"/bin/schemagen -d target -cp target/classes org.aktin.exchange.Query
```

At node: required configuration for certificate
-----------------
my.name
my.email
my.oid
my.organisation
my.state
my.country

Broker/pool identifies node by its oid

At node: Register new broker
---------------------------
Only once: Add+trust certification-authority (ca) certificate manually, multiple trusted CAs are possible

GET /broker/ca.cert (outside of TLS area) or other way to retrieve cert chain from ssl connection: http://stackoverflow.com/questions/6755180/java-ssl-connect-add-server-cert-to-keystore-programatically )
if ca.cert not trusted, abort with message "Broker not trusted (add CA name)"
if no private key, generate private key
if no response from CA in keystore, 
	display certification request to submit to CA
	display textfield to paste response
	abort
connect with keystore to broker
GET /broker/welcome
Show welcome message
goto query exchange

Query exchange
--------------
Outbound connections during fixed times or on-demand
IF unsubmitted queries pending
Node connects to Pool
Node submits query results
Node closes connections to Pool
ENDIF

Node connects to Broker (HTTP keep-alive, gzip-compression)
Node submits node status
IF first time
Node requests open queries
ELSE
Node requests queries (modified since last-contact)
END IF
Node stores queries
Node submits status for all queries (modified since last contact)
Node closes connection to Broker
Node sets last-contact to timestamp when the broker-connection was established.

Message Feature
--------
Broker may store messages (broadcasts), which can be
fetched by the nodes.


```
<request>
	<id>unique request id</id>
	<date-reference>2016-04-11</date-reference>
	<published>
	<query>
		<id>unique query id</id>
		<description>
		
		</description>
		<principal>
			<name></name>
			<organisation></organisation>
			<location></location>
			<email></email>
			<phone></phone>
			<url></url>
		</principal>

		<schedule type="single|repeating|benchmark">
			<duration>-P1Y</duration>
			<interval>P1Y</interval>
		</schedule>

		<concepts>
			<concept id="CEDIS30:ABC1" type="raw"/>
			<concept id="geschlecht" type="aggregate">
				<count group-by="fact.value">
			</concept>
			<concept id="XXX1" type="aggregate">
				<!-- by arrival time -->
				<count group-by="substr(8,10,fact.start)">
				<max/>
				<min/>
			</concept>
		</concepts>
		<definition xsi:type="sql">
			
		</definition>
	</query>
	<signature from="broker" algorithm="SHA256withRSA">...</signature>
	<signature from="me" algorithm="SHA256withRSA">...</signature>
	<broker>
		<last-modified>max timestamp der nachfolgenden</last-modified>
		<!-- timestamp the query was published by the broker -->
		<published>2015-12-01T18:30:14</published>
		<!-- later, the query can be either canceled or closed -->
		<closed>2015-12-02T18:30:00</closed>
		<canceled>2015-12-02T18:30:14</canceled>
	</broker>
</query>

<nodeStatus>
	<module artifact="dwh-api" version="0.1-SNAPSHOT"/>
	
</nodeStatus>
```
