# Introduction: 
This java application to checkout counter for an online retail store that scan products and
generates an itemized bill..

The bill should also total the cost of all the products and the applicable sales tax for each product.
The total cost and total sales tax should be printed.
Sales tax varies based on the type of products.
 Category A products carry a levy 10%.
 Category B products carry a levy 20%.
 Category C products carry no levy.

Bill details the products, quantity, total cost,sales tax and the total value of the bill.Data for 5 Products and 1 bill are added during startup to browse.

# REST endpoints

*  GET /bills - fetches all bill data
*  GET /bills/{id} - fetches bill of a particular id
*  POST /bills - creates a bill Id. Client has to use this bill Id while adding and removing products
*  PUT /bills/{id} - Updates bill data. Client can add or remove products to bill sending a JSON request.
*  DELETE /bills/{id} - Delete bill from the system.

 These REST end points are secured using basic authentication mechanism. Code uses in-memory repository with 'admin' as single user.

# About Implementation

This application has been using SpringBoot as it provides a wide variety of features that aid development and maintenance. Some features that were utilized were: Spring Security, Spring Data/JPA and starters.

This program and instructions have been tested on following versions on Windows laptop.
*  Apache Maven 3.5.0 
*  Java version: 1.8.0_131
*  git version 2.9.0.windows.1



# How to run the application locally?

Pre-requisites to run application are Java, Maven and Git. 
*  Installation instructions for Maven are available at https://maven.apache.org/install.html
*  Java can be installed from http://www.oracle.com/technetwork/java/javase/downloads/index.html
*  Latest Git version can be installed from https://git-scm.com/downloads

Steps to build and run locally:
* Open commandline
* Create a new directory called "smartshopcartapp" 
* Clone repository using following command=>   git clone https://github.com/shailendra1910/smartshoppingcartproblem.git .
* Build the executable jar using maven=> mvn package  
* Go to target folder => cd target
* Run following command to start the server on port 8080=> java -jar SmartShoppingCart-0.0.1-SNAPSHOT.jar 
* Optionally, one can configure port using commandline parameter => --server.port=9090 
* Access and invoke APIs using url => http://localhost:8080/swagger-ui.html
* Application will ask for authentication credentials during invocation of API's. Use 'admin' as user id and password.

This application uses H2 database and does not persist data on application restarts. 

