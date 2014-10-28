#Install

## From Github to Eclipse

1. Open gitbash
2. Change directory to a directory you want the project to be located in
3. git clone https://github.com/RobinGulbrandsen/MyFirstDatabaseConnection.git
4. Open Eclipse
5. Right Click the Project Explorer view
6. Import 
7. Import...
8. Existing Java Project into Workspace, Next
9. Click Browse
10. Navigate to the location of the project where you downloaded
9. Finish

## Get the program running

1. Right click the project and select Properties (Alt + Enter)
2. Select Java Build Path
3. Select the tab "Libraries"
4. Click the button Add External Jar...
5. In the project, open the "lib" folder and select the file "mysql-connector-java-5.1.18-bin"
6. Run the program as you use to

## MySQL server

1. Start your local database server
2. Create a database called "test"
3. Create a table called "person"
4. the person table needs two collumns, "username" and "password"
5. insert test data in the table

### .. Or run the script

CREATE TABLE person (
	username varchar(20),
	password varchar(20)
);

INSERT INTO person VALUES('Joker', '1234');
INSERT INTO person VALUES('Catwoman', '1234');

#INFO

The application follows a simple MVP pattern for CRUD at a database.

Happy hacking!