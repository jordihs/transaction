# transaction
Exercise solution

## Status of the solution

The implementation should cover the concerns expressed in the exercise enunciation. However, there is much to improve upon in the code: 
* More exception classes, and lots more handling of errors, are needed. 
* There should be profiles for both Spring and Maven, to ease the lifecycle across environments. 
* There is no Docker repository definition, one should be established. 
* There are no comments in the code. While it is mostly self explanatory (as it should), some would be desirable. 
* Unit testing is very limited, it should be greatly expanded. 
* There is no logging implementation, logs should be implemented and generated from the application. 
* Spring security must be configured with an identity provider. 
* Adding some kind of reload mechanism for the data source. My plan was to make a HEAD request to verify if the content was changed, and if the response is not 302, then reload the data. Ambitious for the allotted time I'm afraid. 

Most of these things are not here because I thought other aspects of the implementation were more in line with what the test implies as the knowledge areas to be probed. 

## Basic layout

This project is divided in several modules that are built by the POM file at the root folder:
* transaction-core: the module that contains the domain model and business logic. 
* transaction-rest: a REST primary adapter that is used to query the application.
* transaction_json_jpa: a secondary adapter which queries the json data file and stores it in a relational in-memory database. 
* transaction-application: this is the actual spring boot application, composed from the adapters. During build it generates a Docker image for its deployment. 

## Compiling and executing

First, run mvn compile on the root folder. The machine should have a Docker instance running and listening to port 2375. 

Once the build is finished, a docker image will be created in repository transaction-application, with the same version number as the transaction-application project. Run with the following command: 

docker run -p 8080:8080 --name TransactionService transaction-application:0.0.1-SNAPSHOT

Finally, you can test the API using the following URLs:

http://localhost:8080/merchants/1/transactions

(change the number for a different merchant ID)

http://localhost:8080/merchants/1/transactions/Success/200

(change the number for a different amount, and the status for different statuses). 