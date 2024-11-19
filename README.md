# Restaurant Management System Project

Welcome to our group's Restaurant Management System project! To ensure that the application runs well, please do the following:

1. Ensure that you have JDK 23 installed on your system as this project was built with JDK 23.

2. Ensure that MySQL is currently running on your system. Open our Database Schema SQL script inside MySQL Workbench (8.0 CE), ensuring that you have an active local instance and make sure you remember or note down your password to this instance. Have a database selected (it is selected when the name is bold). Then run the script using the first lightning icon to create the database used for our project.

![Alt](Images%20for%20README/schema.png)

3. Download the project ZIP file and then import into Netbeans IDE.

![ALt](Images%20for%20README/import.png)

4. Once imported, head over to ConnectionProvider.java within Database folder.

![Alt](Images%20for%20README/connection.png)

5. Change the following details at the start of the code. Change the name after localhost:3306/ to the name you used for the database within MySQL Workbench. The next line "root" should be fine as is unless you used a different username, if so change it to fit yours. Finally, the next line is the password to your instance in MySQL, change this to the password that you set.

![Alt](Images%20for%20README/infochange.png)

6. Run the file Login.java within the GUI folder to begin the application.

# Troubleshooting

In the event that when importing the project and the name is displayed in red, it is most likely JDK version issue:

![Alt](Images%20for%20README/red.png)

Please do the following:

1. Right click the project and look for Resolve Project Problems

2. You will be brought to this screen, click on Resolve

![Alt](Images%20for%20README/resolve.png)

4. In the next screen, please change the version to JDK 23

![Alt](Images%20for%20README/jdk23.png)



