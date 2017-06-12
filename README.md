# testTaxes

This is a Spring project that receives an order and returns a receipt after calculating the taxes and the total for that order. 

Tools/technologies needed: Maven, Tomcat 9, Mysql, liquibase

You must create a MySQL database with the name taxes. The script to run the database is in the file: createDatabase.txt.
I assumed the MyQL server is listening on the default port 3306. If not, you must also change the application.properties 
file to point to your port.

The database gets automatically populated at the time the application is loaded by the Tomcat server with the products necessary for creating the orders given as an example in the
requirement file (requirement.pdf). For pre-populating the products I used liquibase.

You can also add your own products using a POST request using any tool like Postman, SoapUI, Google Rest Console to:
http://localhost:8080/taxes/products. In the body of the request you can add the json string for a sample product found in the createProduct.json file. 

In order to run the application, copy the taxes.war file (from the target folder) to tomcat/webapps folder and then start the Tomcat server.
To create an order and get the receipt back send a POST request to: http://localhost:8080/taxes/orders.

To see the receipts created for each order you can access: http://localhost:8080/taxes/receipts.


