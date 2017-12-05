# CS3380ROKO

Project by: Roland Oruche and Kirtis Orendorff

DESCRIPTION: This Java program keeps track of
  the cars in inventory and the car sales 
  history of a car dealership. It does this 
  by connecting to MySQL running on an AWS
  server and sending querys through the JDBC
  library.
  
TABLE DEFINITIONS:

ERD:

CRUD EXPLANATION: The program does all of the
  query calls in the MySQLConnect.java file. The
  functions within this class send querys to 
  MySQL while it is connected and interprted the 
  return data for display on our JavaFX TableView.
  
  The following functions in the class 
  MySQLConnect.java fufill the criteria for CRUD:
  
    newRow(int table): CREATE
    showTable(int table): READ
    updateRow(int table): UDPATE
    deleteFromTable(int table): DELETE

VIDEO DEMO LINK:
