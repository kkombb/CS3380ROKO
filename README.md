# CS3380ROKO

PROJECT AUTHORS: Roland Oruche and Kirtis Orendorff

DESCRIPTION: This Java program keeps track of
  the cars in inventory and the car sales 
  history of a car dealership. It does this 
  by connecting to MySQL running on an AWS
  server and sending querys through the JDBC
  library.
  
  FILES PROVIDED: On this Git repository you
  will find our project in the FinalProject folder.
  Files provided include the NetBeans project file, 
  all the necessary classes, and a executable build 
  of the project (located at FinalProject/dist/FinalProject.jar).
  
TABLE DEFINITIONS:

    inventory:
      vin varchar(255) PRIMARY KEY
      car varchar(255)
      model varchar(255)
      year int
      miles int
     
     sales:
      vin varchar(255) PRIMARY KEY
      car varchar(255)
      model varchar(255)
      price int
      name varchar(255)

ERD: Provided in the repository (FinalProject3380.sdr)
      Link to ERD: https://cloud.smartdraw.com/editor.aspx?templateId=2f3b7c28-0285-4534-8ec7-669613516600#depoId=1JSqhc7-IcMz6sR3ADE5UigiZ1dIGr9sn&credID=45802

CRUD EXPLANATION: The program does all of the
  query calls in the MySQLConnect.java file. The
  functions within this class send querys to 
  MySQL while it is connected and interprted the 
  return data for display on our JavaFX TableView.
  
  The following functions in the class 
  MySQLConnect.java fufill the criteria for CRUD:
  
    newRow(int table): CREATE
      This function takes data retrieved by the 
      front end text fields and creates a new
      row in MySQL from the data.
    showTable(int table): READ
      This function populates the JavaFX table
      on startup from the data stored in the 
      tables in MySQL. 
    updateRow(int table, int index): UDPATE
      This function updates the row at the 
      selected index from the TableView and 
      sends that update to MySQL.
    deleteFromTable(int table, int index): DELETE
      This function deletes from MySQL the item
      at the selected index and table sent to it.

VIDEO DEMO LINK:
