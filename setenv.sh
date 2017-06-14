#! /bin/sh

export CATALINA_OPTS="$CATALINA_OPTS -Denv=$ENV -D$ENV.blinkmob.dbUrl=$DBURL -D$ENV.blinkmob.dbUser=$DBUSER -D$ENV.blinkmob.dbPassword=$DBPASSWORD"