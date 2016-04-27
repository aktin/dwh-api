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
			<concept id="CEDIS30:XXX" type="raw"/>
			<concept id="XXX1" type="aggregate">
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
		<rejected></rejected>
		<comment></comment>
		<last-execution>
			<completed>XXXtimestamp</completed>
			<failed></failed>
			
		</last-execution>
		<last-contact>
		<result-submitted>XXX timestamp</result-submitted>
	</request-status>


<query-result id-ref="">
</query-result>
```