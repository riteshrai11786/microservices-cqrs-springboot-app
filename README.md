# Microservices CQRS Design Pattern
Microservices design pattern the CQRS implementation


CQRS means Command and Query Responsibility Segregation, the pattern which separates the read and write operations for a data store. Implementing CQRS in our application can maximize its performance, scalability, and security. The flexibility created by migrating to CQRS allows a system to better evolve over time and prevents update commands from causing merge conflicts at the domain level.

CQRS is one of the important pattern when querying between microservices. We can use CQRS design pattern in order to avoid complex queries to get rid of inefficient joins. CQRS stands for Command and Query Responsibility Segregation. Basically this pattern separates read and update operations for a database.

#SpringBoot implementation

The springboot application contains the command and query packages which deals with the command and queries by aggregates and projections respectivelly. Also, there is a Event sourcing applied using the Axon framework.
