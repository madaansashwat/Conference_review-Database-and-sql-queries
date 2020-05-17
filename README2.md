Before getting started, you must set up your Java development environment.
Open ecplise and open a new project, name it as you like.
Eclipse might ask you whether you want to switch to the Java perspective. If so, say Yes.
Connector/J driver so your program can connect to MySQL. Please make sure you download the version that is compatible with your version of MySQL.
Go to this web page: http://www.mysql.com/downloads/connector/j/
Press the download button next to the “Platform Independent (Architecture Independent),ZIP Archive” version. (Or the TAR version if you prefer; it doesn’t really matter.)
The next page will ask you to create an account. Instead, click the little blue link on thebottom that says “No thanks, just start my download.”
Open the .zip file you just downloaded, and look for a file inside named something likemysql-connector-java-xxxx-bin.jar. Copy this file into your project directory (from the Location box in step 3 of the last section).
Now that we have the driver, we need to tell your project about it. Go back to Eclipse, right click on the project, and select Build Path → Add External Archives…
Select mysql-connector-java-xxxx-bin.jar and press Open
Now we’re ready to configure the project for your copy of MySQL and run it!
Open the .java source code file. copy the contents and past it in the ecplise. 
Right click on the file with the main method, and from the context menu select the Run->Java Application menu option.
