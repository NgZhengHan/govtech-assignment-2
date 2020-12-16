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

### Connect to the postgres container
After installing pgAdmin, run pgAdmin.  
Your browser should launch and bring you to the pgAdmin UI.  
On the left side, you should see something similar to a file structure. Right click on `Servers` -> `Create` -> `Server`

