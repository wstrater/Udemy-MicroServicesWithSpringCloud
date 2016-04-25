#!/bin/bash

ALIAS=github
FILE=/tmp/github.com.crt

# Download certificate
echo -n | openssl s_client -connect github.com:443 | sed -ne '/-BEGIN CERTIFICATE-/,/-END CERTIFICATE-/p' > $FILE

# View certificate
less $FILE
openssl x509 -in $FILE -text | less

STORE="$JAVA_HOME/jre/lib/security/cacerts"

# Backup trust store
DATE=`date +%Y-%m-%d`
if ! [ -f "$STORE.$DATE" ]; then
  cp $STORE $STORE.$DATE
fi

# Import certificate into trust store
if [ -f "$STORE.$DATE" ]; then
  $JAVA_HOME/bin/keytool -import -trustcacerts -keystore $STORE -storepass changeit -noprompt -alias $ALIAS -file $FILE
fi

$JAVA_HOME/bin/keytool -list -v -keystore $STORE -storepass changeit -alias $ALIAS

ls -latr $STORE*
