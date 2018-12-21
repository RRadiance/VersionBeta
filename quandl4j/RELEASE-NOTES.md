Release Notes
=============
# 2.0.0
A fairly comprehensive overhaul. The primary aim was to allow the use of alternative types to hold tabular and metadata. A common user 
question has been around the choice of JSON or Table representation, and these are now abstracted in a way that allows you to choose 
types that best suit your application, and even add your own very easily. This version is fully source compatible with previous 
versions, although most existing session classes and interfaces have been deprecated. Updating existing code is very simple, 
see the [2.0.0 migration guide](README.md#200-migration-guide) for more information.  A special thanks to Ben McCann (@benmccann) for suggesting the initial idea,
reviewing and commenting on code, and to both him and Larry White (@lwhite1) for responding to little TableSaw issues so quickly.

# 1.5.0
Calls upgraded to use V3 of the REST API for both data and metadata.  No API changes.  Logback is removed as a normal dependency to 
allow users to choose their own implementation of SLF4J (which is the whole point of SLF4J!).  If you have any build issues try adding
logback to your own pom.xml.  Examples are moved to test packages and commons-cli dependency is now only a dependency for test scope.
Docs and contributors list updated.

# 1.4.2
This is a little tweak release to update the version of Jackson used by the 
library so it can be used with AWS.  Thanks to William Farrugia for the 
suggestion.

# 1.4.1
This is a bug fix release, @Olivier-92 reported a resource leak that affects
those using RESTEasy as a JAX-RS provider.  The request objects are now closed
as required.

# 1.4.0
POM references to external OpenGamma Maven repository have been removed and the JSON library referred to has been switched for
Jackson using the json.org datatype module.  This should require no code changes in users outside of perhaps a POM change if you've
referred to the OpenGamma POM in your POM.  This change was made because I receive regular reports that the OG repo is down and it
additionally has caused issues for SBT and Gradle users.  Now all dependencies come from Maven Central.  The issue was forced due to
information from George Hawkins (george-hawkins-aa) and a suggestion that the project switch to Jackson.  The intention is now that 
2.0 will move away from the json.org object model to the Jackson tree model, although the intention is to maintain a compatability API
in parallel so users don't need to change existing code.

# 1.3.0
SearchRequest now supports the v3 API databasecode argument and makes the query
parameter (previous `of()`) optional.  This means the `of()` static factory 
method is now deprecated in favor of a no-arg constructor. 
``` java 
SearchRequest.Builder.of(<query>).build();
```
becomes 
``` java
new SearchRequest.Builder().withQuery(<query>).build();
```
Docs and examples have been updated to reflect this contribution from 
Hamel Ajay Kothari (hkothari).  Many thanks for that!

# 1.2.0
Changed HTTPS URL because RESTEasy and Apache CXF can't handle redirect to https://www.quandl.com which is the address in the TLS certificate.  Disabled 
integration test from main build because test framework misbehaving.

# 1.1.0 
Add support for HTTPS migration, small change, but required test data regeneration.

# 1.0.0
Handles the deprecation of multisets from the Quandl REST API and provides for (configurable) automatic resilience to 
transient errors.
