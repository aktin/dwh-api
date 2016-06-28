Common API for the AKTIN data warehouse
---------------------------------------

Generate XSD files:
```
"$JAVA_HOME"/bin/schemagen -d target -cp target/classes org.aktin.exchange.Query
```

Query exchange
--------------
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

	<request-status ref="123">
		<last-modified>max timestampt der nachfolgenden</last-modified>
		<received>XXXtimestamp</received>
		<confirmation method="single|double|automatic">xxx</confirmation>
		<!-- confirmation or rejection -->
		<rejected></rejected><!-- manually rejected -->
		<!-- may also automatically reject requests:
		 reject all because of vacation,
		 reject specific recurring query -->
		<reject-reason>La la la</reject-reason>
		<comment></comment>
		<last-execution>
			<completed>XXXtimestamp</completed>
		<failed></failed><!-- may fail due to technical reasons -->
			
		</last-execution>
		<last-contact>
		<result-submitted>XXX timestamp</result-submitted>
	</request-status>


<query-result request-ref="1">
	<timestamp>2015-12-02T18:30:14</timestamp>
	<execution-time>P10S</execution-time>
	<result xsi:type="aggragated-result">
		<value id="cedis-count">321</value>
		<breakdown id="gender">
			<value id="male">110</value>
			<value id="female">112</value>
		</breakdown>
	</result>
<!-- or -->
	<result xsi:type="export-result">
		<table id="patients">
			<headers>
				<header>id</header>
				<header>birthdate</header>
			</headers>
			<tr>
				<td>1</td>
				<td>2010-01-01</td>
			</tr>
		</table>
		<table id="visits">
			<headers>
				<header>patient-ref</header>
				<header>id</header>
				<header>start</header>
			</headers>
			<tr>
				<td>1</td>
				<td>1</td>
				<td>2016-05-08T09:32:00</td>
			</tr>
		</table>
		<table id="diagnoses">
			<headers>
				<header>patient-ref</header>
				<header>visit-ref</header>
				<header>start</header>
				<header>code</header>
			</headers>
			<tr>
				<td>1</td>
				<td>1</td>
				<td>2016-05-08T09:32:00</td>
				<td>R46.1</td>
			</tr>
			<tr>
				<td>1</td>
				<td>1</td>
				<td>2016-05-08T09:32:00</td>
				<td>W46.05</td>
			</tr>
		</table>
	</result>

</query-result>

<nodeStatus>
	<module artifact="dwh-api" version="0.1-SNAPSHOT"/>
	
</nodeStatus>
```
