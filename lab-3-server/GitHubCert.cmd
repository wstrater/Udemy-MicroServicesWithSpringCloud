Set CertFile=github.com.cer
Echo %CertFile%

Set FileDate=%Date:~10,4%-%Date:~4,2%-%Date:~7,2%
Echo %FileDate%

Set CACerts=%JAVA_HOME%\jre\lib\security\cacerts
Set CACerts=%JAVA_HOME%\lib\security\cacerts
Echo %CACerts%

Rem Backup trust store
If Not Exist "%CACerts%.%FileDate%" Copy "%CACerts%" "%CACerts%.%FileDate%"

Rem Import certificate into trust store
If Exist "%CACerts%.%FileDate%" "%JAVA_HOME%\bin\keytool" -import -trustcacerts -keystore "%CACerts%" -storepass changeit -noprompt -alias github -file "%CertFile%"

"%JAVA_HOME%\bin\keytool" -list -v -keystore "%CACerts%" -storepass changeit -alias github

Dir "%CACerts%*"
