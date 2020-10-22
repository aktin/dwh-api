Common API for the AKTIN data warehouse
---------------------------------------


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

