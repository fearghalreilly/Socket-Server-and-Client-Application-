The application is a socket server and client application that allows a server and client to chat. The connection to the server can be closed when the client sends “/q”.
To connect to the server the client must connect with a host of “localhost” and port number of 5000. The application will run until “/q” is entered by the client, which triggers the connection to close. When a connection is established between the server and client. The application uses InputStream and OutputStream. Where the InputStream is used to read the data from the source and the OutputStream is used to for writing information for its destination. 

To run on Command Prompt
Open two Command Prompt windows. One for the server and another for the client.
Run the server application as,
java Server
The Command Prompt window will show for the server
 
Run the client application as,
java Client
The Command Prompt window will show for the client
 
The server can now initiate the chat conversation.
 
The server and client can pass messages back and forward.
 
When the client sends “/q”. The server gets the following prompt.
 
