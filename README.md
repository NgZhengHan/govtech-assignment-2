# govtech-assignment-2
 
## Simplified tech stack  
Item | Description
------------ | -------------
Operating System | Windows 10 pro
Database| postgresql latest docker image on Docker Hub
Database platform| Docker 3.0.0
Database management tool| pgAdmin 4
ORM | Hibernate 5
Application server| Wildfly 21
IDE | Eclipse jee 2020 09
Language | Java 14
Tool to help with REST calls | Postman
Data format | JSON

## Declarations and Assumptions
Requirements 1 to 5 have been attempted. Due to time constraints with my current job, I have only been able to develop them on a very basic level and have not tested them rigorously. I would like to make some declarations and assumptions about the projects:  
  
1.  Future work/improvements  
Many of the features in this project can be improved. I will describe some of my ideas below:

2.  JSON format  
I made the assumption that this app server would be used with a client app that would handle interfacing with the REST end-points. Both the client and the server would transfer data in JSON format. Because of this assumption, data, such as family members' field values, is packed in JSON format. This can still be edited from the URL, but keep in mind that they have to be represented in JSON format. I have tried to keep the field names humand-readable to facilitate this manual change if needed. Alternatively you can use the saved requests on Postman (see below) to interact with the end-points. You can also use the online tool (https://onlinejsontools.com/url-encode-json) to convert human-readable json to url encoding. The user-experience for this can be improved with an application that helps format the data between JSON and a form that is easy for humans to interpret and use, for example a graphical user interface. 
  
3.  Using enum ordinals instead of Strings  
I try to store enums using their ordinals in an attempt to marginally improve efficiency and to future-proof the database. Ordinals and enums are automatically mapped when setting 1 or the other, therefore they can both be used seamlessly on the (imaginary) client and the server side. Only the database stores just the ordinals. Ordinals are cheaper to store and they are gauranteed to be unique. When using Strings, case sensitivity and typos increase the risk of errors. While not much use is made of the enums and ordinals so far in this project, I would like to offer some thinking behind this choice.     
  
4.  Create Household end-point  
This end-point would take in a Household that is serialized into JSON format and add it to the database. Right now it only stores an auto-generated primary key and the ordinal of the housing type. There is an assumption that every household is unqiue, even if their contents (except the auto-generated primary key) are the same. An improvement that can be made to this feature is to validate the contents of the would-be household. For example, if the address and unit numbers clash with another item that already exists, then we want to be able to identify if this is a duplicate, or make a distinction that there are multiple households living in the same unit (I note that the assignment document did indicate that the assumption is that these would be considered the same household). Further, this end-point can be improved to also take in family member id or family member details, and autmatically link them up. In the even when we want to create brand-new households, including family members, this end-point can be tweaked to facilitate this need.      
  
5.  End-point to create a family member  
This end-point will take in a JSON serialized object that describes the family member. For now, this does not automatically map the spousal relationships. An improvement to this can be to automatically map the spousal and household relationships. Additionally, this can be improved to create multiple family members if they come in as a batch.  
  
6.  Family member relationships  
Right now, there is only a spousal relationship. This relationship resides in a separate table which can be expanded to include other relationships such as father-son, brother-sister, next-of-kin, date-of-marriage, date-of-separation/divorce etc. There is a separate class and mapping to facilitate this feature. Additionally, spousal relationships are described as a `set`. This open-ended relationship mapping leaves the option open for cases when a person may have more than one spouse, for example having concurrent multiple spouses. While this is not allowed in Singapore context, we can discuss if policy/process should be designed into a system.      
  
7.  "One" is part of "some"    
For example, the GetHousehold end-point is designed to actually be able to cater to querying a list of Household Ids, instead of exactly just 1 Id. By designing it this way, the same service can be used for more than just querying 1 specific Id.   
  
8.  Lucene Search  
I wanted to implement Lucene search to improve on the get/search features. However, due to time constraints, I prioritized the other features first. Luence search and index would improve the system performance when the database grows big. Also, it gives us additional tools to do advance searches, such full/partial text search, fuzzy searches etc. which are particularly useful for finding names or addresses etc.    
  
9.  Delete feature and filters  
Similar to Lucene Search, this was reprioritzed. You may find some remnants of it, such as a `notDeleted` filter in the Hibernate files. The database elements are not removed from the table upon a `delete` operation. Instead, a `deleted` flag would be set. This is for archiving and audting purposes. Additionally, the elements should also be tagged with several helper fields, representing when it was originally created, when was it modified, by who, and when was it deleted. Some other logging features can be tweaked or included that can help in this feature, such as recovery from a `delete` operation.  



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
