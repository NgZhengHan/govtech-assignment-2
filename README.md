# govtech-assignment-2
 
## Simplified tech stack  
Item | Description
------------ | -------------
Operating System | Windows 10 pro
Database| postgresql latest docker image on Docker Hub
Database platform| Docker 3.0.0
Database management tool| pgAdmin 4
Application server| Wildfly 21
IDE | Eclipse jee 2020 09
Language | Java 14
Tool to help with REST calls | Postman



## How to set up
  
### COTS folder on Google Drive
>https://drive.google.com/drive/folders/15yNNK_0nusUUHt0OLmhvoS1RnaM1xtQu?usp=sharing

Use the above link to google drive to find the installers for the COTS used in this project. Alternatively, if you choose to download it directly from the official websites, the links will be provided in the relevant sections.
  
### Download and install Docker
>https://hub.docker.com/editions/community/docker-ce-desktop-windows/

Download and install Docker from the official site (linked above) or from the Google Drive.
  
### Run a postgres container in Docker
Open Powershell, then run the command:

>`docker run --name govtech-assignment-postgres -p 5432:5432 -e POSTGRES_PASSWORD=govtech -d postgres`

This will download the latest official postgres image from Docker Hub, and run it as a container on port 5432. The password is set as `govtech`.
  
### Download and install pgAdmin
>https://www.pgadmin.org/download/pgadmin-4-windows/

Download and install pgAdmin either from the official site (linked above) or from the Google Drive.
  
### Install Java 14 and above
For this project, we are using `OpenJDK 15`
You can find the installer in the Google Drive, or from the official site 
>https://openjdk.java.net/  
  
Note that if you install Java using OpenJDK, then you will have to set your `JAVA_HOME` and `path` environment variables to point to your OpenJDK installation. Follow the instructions provided by this answer https://stackoverflow.com/questions/52511778/how-to-install-openjdk-11-on-windows
  
### Clone this project to your local machine
Clone this project into your local machine with the path `C:\Govtech\Git_Repositories`  
This is because the project is configured to run with wildfly in the path `C:\Govtech\Git_Repositories\govtech-assignment-2\wildfly-21.0.1.Final`  
  
### Connect to the postgres container using pgAdmin
1. After installing pgAdmin, run pgAdmin.  
2. Your browser should launch and bring you to the pgAdmin UI.  
3. On the left side, you should see something similar to a file structure. Right click on `Servers` -> `Create` -> `Server`  
4. A new window should appear. For the `Name` field, put in `govtech_postgres`  
5. Go to the `Connection` tab. For `Host name/address`, type in `localhost`  
6. For `Password`, type in `govtech`  
7. Leave the other fields unchanged  
8. Click `Save` at the bottom right  
  
### Create a database then use the provided backup to restore 
1. Right click on `Databases` -> `Create` -> `Databases...`  
2. A new window should appear  
3. In the `Database` field, type in `assignment_2_database`  
4. A new database should appear  
5. Right click on this newly created database `Restore`  
6. In the new window, for `Filename`, click on the 3 dots `...` at the end. This will open a file explorer  
7. Navigate to the database backup provided in this repository. If you used the same path as I did, it should be `C:\Govtech\Git_Repositories\govtech-assignment-2\database_backup\assignment_2_database_backup20201216_3.sql`. If you cannot find the file, make sure to change the `format` at the bottom right to `sql`  
8. Click on `Restore`  
9. After the database is restored, you should be able to find several tables. For example, the Table `family_members` should have some content  

### Import the project into Eclipse  
> https://www.eclipse.org/
1. Install Eclipse from the official site or from the Google Drive
2. Import the project into Eclipse  
  
  
### Create a Wildfly Server in Eclipse
1. Run Eclipse
2. Install the JBoss Tools from the Eclipse Marketplace 
3. Open the `Servers` tab and create a Wildfly 21 server if it does not exist. Point to the Wildfly 21 folder that you downloaded from this repository. Bind the project to this server. 
4. You should be able to run the project on this Wildfly server


### Install Postman
> https://www.postman.com/  
Install Postman from the official site, or from the Google Drive. After installing the Postman application, launch it. When prompted to sign in, use 

Email | Password
------------ | -------------
govtech.assignment@ngzhenghan.com | govtech!

This should load several prepared HTTP GET and POST requests. Go to `Collections` tab on the left to find them. Please wait for a while as they load in the background. Currently they do no have any UI indication that it is loading the saved data.  
