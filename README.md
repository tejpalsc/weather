# Weather Service Application

## Set-up Instructions
This is a single module maven project. It can be built using 'mvn package' in the /horoscpe directory(please make sure that JAVA_HOME points to a jre of version 1.7.x or higher), and deployed on a server. Alternatively it can be tested with the embedded jetty server using:
```sh
mvn jetty:run
```
and hitting the URL http://localhost:8080/weather (default port is 8080).

The project can be imported to eclipse 'as existing maven project' using m2e plugin.

An internet connection will be needed for maven dependencies, some of the JUnit tests and JS libraries.

## Design
A single page application, which loads the list of supported cities dynamically which is configurable.

The  back-end uses Yahoo weather API to fetch weather details for the selected city. The details are cached in memory in order to minimise expensive calls to the external API. The expiration time for cached data is configurable.

###Front-End:
The frontend consists of a static html file that uses JQuery Ajax to talk to the backend. The web page uses minimal styling, and javascript/css is embedded with html for easy comprehension. 

###Back-End:
The REST service is implemented using Spring MVC. The following 

The REST endpoint has fol. specification.
-Weather Details API
Type: GET
Path: api/details
Query Params: 
city - has to be one of the cities specified in configuration   
Response:
JSON representation of weather details.

-Location API
Type: GET
Path: api/cities
Response:
JSON represention of list of supported cities.
#### Caching

The result is cached using Google Guava LoadingCache. The refresh interval of the cached data is configurable. A zero value will force calls to external API on each request.
 
#### Configuration

-cities
A comma separated list of cities supported by the application (Sydney,Melbourne,Wollongong)
-refresh-interval
Expiration time for the cached entries
-weather-api-url
External API endpoint with string place-holder for the city name

##Tests
The application has unit test for controller and services. The offline tests use Mockitos for mock objects. 


