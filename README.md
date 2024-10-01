### _**How to run the server program**_
* Open the project in IntelliJ IDE. 
* Setup SDK to Java 11. Go to File > Project Structure > Modules > Dependencies. Set Module SDK to OpenJDK version 11. Other versions may also be used. 
* Right click on TCPServer.java file and run TCPServer.main()
* Once the program runs, it will prompt the user to enter the port on which the server should run. For example, port number 1524.
* The server will then start in passive mode listening for a transmission from the client. Once the client is up and running, connection between server and client will be established.
* Run the TCPClient program. 
* TCP Server will exit once request is received and response is sent to the client.

