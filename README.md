# EJB sample

## Glassfish setup

We should use full profile to use EJB

```
# web profile
wget http://download.java.net/glassfish/4.1.2/release/glassfish-4.1.2-web.zip
# full profile
wget http://download.java.net/glassfish/4.1.2/release/glassfish-4.1.2.zip
```

unzip & start domain (default domain name is "domain1")

```
unzip glassfish-4.1.2-web.zip

glassfish4/bin/asadmin start-database
glassfish4/bin/asadmin start-domain

# admin console
start http://localhost:4848/
```

## compile & deploy EJB sample

```
gradle deploy
# from the second
gradle redeploy
```

## run the EJB client

```
gradle run
```

## view server log

Client output is written in the server log.

less PATH_TO_GLASSFISH/domains/domain1/logs/server.log

## Stop the Glassfish

```
asadmin stop-domain
```
