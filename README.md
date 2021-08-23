# PaymentApi Project
A working example of spring boot resource server and authorization server together, uses oauth2 for authorization. To start with, jdk has to be 1.8, mysql server can be switched inside the pom, the mysql config inside is mysql8 too., if using mysql5.7 kindly comment out mysql-driver version and its fine.
Set up the database configuration as it is in application.yml and run as a java application

Resources
1. Spring Boot 1.5.8.RELEASE
2. Java 8
3. MySql 8
4./oauth/token  as token url
5.basic auth credential username = dayo-client
6 basic auth header password =  dayo-secret
7 Body request for  username = Adedayo
8 Body request for password = password
9 Body request for grant_type = password
10 Insert encrypted password using bcyrpt into user if on application startup it does not populate.
11.We use ledger to create account 
12 And transaction controller for transaction processsing
13 Also user controller is used in creating and managing them
14 Email controller is used in sending emails
15 1028856CC is used for commission acoount
16. Tester should setup his/her gmail account in application.properties accordingly to send mails

