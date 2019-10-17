# cheque-handler
Desktop application to print cheques and store the cheque details.

## Following text is as it is copied form README file from 2010 when this application was developed

Java Swing UI based desktop application using MS Access as database.

### Installation

Requirements: You can have any Windows(xp,vista or windows 7). This software runs on any amount of RAM and Hard Disk and on every processor.
Only requirement is MS-Access which comes with MS-Office and Java Runtime Enviroment(JRE) which is installed mostly by default.
If it's not intalled then download it from https://cds.sun.com/is-bin/INTERSHOP.enfinity/WFS/CDS-CDS_Developer-Site/en_US/-/USD/ViewProductDetail-Start?ProductRef=jre-6u23-oth-JPR@CDS-CDS_Developer OR search google for JRE. JRE is legally free and only of 15 Mbs.

### Database setup
Keep 'ChequePrintStartdatabase.mdb' file in any folder where the path or location of this file will not be changed.
->Go to control panel of you computer
->click on administrative tools
->click on DataSources(ODBC)
->click on Add->choose Microsoft Access Driver (*.mdb) and click Finish
->Now a new window will open Type cheque in Data Source Name field.
->click on select->Now browse to the 'ChequePrintStartdatabase.mdb' file. While choosing the databse as you will click on folder containing 'ChequePrintStartdatabase.mdb' file, 'ChequePrintStartdatabase.mdb' will appear written on left side of window. Select it and click on Ok
->Now click on 'cheque' under name field and click on advanced->enter the password you received from LoJis System Solutions. Click on ok without filling any other field. Now you are ready to use the software.

### How to use the application
1) Run the software by double clicking on ChequePrintStart.jar file.
2) Then you must enter username and password.
Default username and password is lojis.
3) You can change the default username and password by clicking on 'change password' button.
4) When you click on 'change password' button a new window opens. Enter your current username.
Then in next field type new username (or type the current username again if you don't want to change the username).
Then enter the current password and in next 2 fields type the new password and click on submit button.
A message will appear telling you that new username and password has been saved.
5) Now when you login into the software a new window will open.
6) Type the customer's name or choose the customer's name from drop=down menu.
Type the amount in numbers in next field and amount in owrds in next field followed by date in next field.
If you want crossed cheque then click on Crossed checkbox. Now choose the bank from the drop-down menu.
7) Now you can click on 'save & create image' button to save the details in database alongwith creating an image of the cheque which can be printed in future OR you can click on 'save & print' button to save the details in database and print the cheque OR click on 'save only' button to only save the details in database.
8) Also enter any name in Name field and click on 'search' button to view all details of the customer. If Name field is empty and you click on 'search' button then details of all customers will be shown.
9) To delete an entry, first search that entry using 'search' button. Then enter the ID of the row you want to delete in ID field and click on 'delete' button.
10) To create a new cheque click on 'create new cheque' button. As shown in image on new window enter the measurements of the cheque in milimeters(mm) which can be measured using a scale.
Also enter a name for the cheque(for eg. enter bank's name) and click on 'save'.
You have to close the software and again open it to see the name of newly created cheque name in Bank drop down list.
11) WARNING: Don't move the database 'ChequePrintStartdatabase.mdb' file after database has been installed.
