# Inventory Management System

This is a web-based inventory management system with functionalities for both **Admin** and **User** roles. It allows **Admins** to add, update, and delete products, while **Users** can only search for available products. The backend is powered by **Java** with **JSP**, and the database uses **MySQL**.

## Features
- **Admin Functionalities**:
  - Add new products.
  - Update existing products.
  - Delete products from the inventory.
- **User Functionalities**:
  - Search for products in the inventory.
  
## Tech Stack
- **Backend**: Java, JSP
- **Frontend**: JSP, HTML, CSS
- **Database**: MySQL
- **Server**: Apache Tomcat 8
- **IDE**: Eclipse
- **Database Management**: SQLyog

## Prerequisites

1. **Install Java (JDK 8 or higher)**  
   - Download from [Oracle](https://www.oracle.com/java/technologies/javase-downloads.html) or install using a package manager.

2. **Install Apache Tomcat 8**  
   - Download and install Apache Tomcat from [here](https://tomcat.apache.org/download-80.cgi).
   - Set up Tomcat in Eclipse:
     - Go to **Eclipse > Window > Preferences > Server > Runtime Environments**.
     - Click **Add** and select **Apache Tomcat v8.0**.
     - Choose the installation directory where you installed Tomcat.

3. **Install MySQL**  
   - Install MySQL using your preferred method (download from [here](https://dev.mysql.com/downloads/mysql/)).
   - Alternatively, you can use SQLyog for managing MySQL databases, which provides an easy-to-use interface.

4. **Install SQLyog**  
   - Download and install SQLyog from [here](https://webyog.com/product/sqlyog).

5. **Install Eclipse IDE**  
   - Download from [here](https://www.eclipse.org/downloads/).
   - Make sure the **Eclipse IDE for Java EE Developers** is installed as it provides the necessary tools for working with web applications.

## Setup Instructions

- Import this project in Eclipse.
- Go to Servers tab at the bottom of Eclipse or on top on Run tab, choose Run as and then Run On Server.
- Right-click and choose New > Server.
- Select Apache Tomcat v8.0 and point it to your Tomcat installation directory.
- Configure MySQL Database Connection, update the database connection details (username, password) in the Java servlet files where the connection to the MySQL database is made. For example, in SignUp.java, Search.java, etc., use your MySQL credentials.
- Create **ceredentials** table (id, username, password, type) and **product** table (id, name, quantity, unit_price).
- In ceredentials table, add a record manually with type = admin so that user could act as admin (all others should be given as type = user on signup). 
- Download MySQL Connector/Driver
- Add the .jar file to your project by copying it into the WEB-INF/lib directory.
- Right-click the .jar file in Eclipse and select Build Path > Add to Build Path.
- After setting up Tomcat and the database, deploy the project, Right-click the project in Eclipse, select Run As > Run on Server. Choose Tomcat v8.0 Server and start the server.
- Open Browser and go to: [https://localhost:8080/index.html](https://localhost:8080/index.html)
- or use your setup port for Apache.
