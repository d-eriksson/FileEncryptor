# DON'T RUN THIS PROJECT ON YOUR COMPUTER IF YOU DON'T KNOW WHAT YOU ARE DOING!
# Introduction
This project is created to demonstrate how a ransomware can be implemented. It doesn't include a way to distribute the malware and it doesn't have the infrastructure to require payment.

### The goal
I wanted to create a program that could run through the computer and encrypt all files that seemed harmful to encrypt. Then the software would send the randomly generated decryption key to a server where it would store it. The target of the attack would only be able to decrypt and regain the files if they obtain the decryption key from the attacker.

### What was achieved
All the goals that were set was achieved the software is able to encrypt all files and decrypt all files in a timely fashion. After all files have been encrypted the key is sent to the server.

### What can be improved
Although all the goals were met there are some concerns that needs to be adressed. Currently the client server connection is a unencrypted connection so if there is a sniffer active during the encryption the key could be seen. Some infrastructure would have to be implemented aswell, the server is currently unprotected and the ip-adress could be found by a sniffer aswell. This could lead to an ip-trace that unveils who the attacker is. The keys are currently not stored in a good way, currently the keys are stored in text files that are stored on the server. It would be better if the keys were stored in a database of somesort, this is not difficult to implement but due to time I didn't find it necessary.

# The classes

#### ClientConnection
This class was implemetented to control the conversation with the server. It has one method sendInformation(String serverName, int port, String pass, int NumberOfFiles); This will send the password aswell as the number of files that were encrypted to the server. It will also esatblish the connection to the given server.

#### Encryptor
This class is used to encrypt and decrypt, it has four methods two encrypt methods and two decrypt methods. Two for handling byte arrays and two for handling Strings, The two handling Strings are actually never used in this project. This is a common implementation of a AES encryption which is a strong encryption block cipher.

#### FileCreeper
This class will take a root position on the harddrive i.e. a directory (for a whole harddrive you would use "C:/") then it traverse all files in that directory and enters those directories. This is a recursive function which won't stop until all files have been found. The class performs some optimisations by not entering som pre-determined folders, like /node_modules and /Windows This is done to enhance performance and not to encrypt any essential files for the operating system to function. It also only searches for the filetypes that are given, there's no reason to encrypt .exe files and similar files. We want to encrypt personal files like textdocuments, pdfs, images and windows.

#### FileEncryptor
Takes a file encrypts it using the encryptor class and then writes over the old file with the encrypted one.

#### Main
This is the main file that runs the encryption software and connects to the server.

#### MainDecrypt
This program is used to decrypt all the files that have been encrypted.

# How to compile and run
## Start client
go to root folder cd FileEncryptor
javac -cp ".;commons-codec-1.11.jar;commons-io-2.6.jar" *.java
java -cp ".;commons-codec-1.11.jar; commons-io-2.6.jar" Test

## Start Server
go to the server folder and run
javac Server.java
java Server
