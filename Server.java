import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Server
{
	//initialize socket and input stream
	private Socket		 socket = null;
	private ServerSocket server = null;
	private DataInputStream input	 = null;
	private DataOutputStream out= null;

	// constructor with port
	public Server(int port)
	{
		// starts server and waits for a connection
		try
		{
			server = new ServerSocket(port);
			System.out.println("Server started");

			System.out.println("Waiting for a client ...");

			socket = server.accept();
			System.out.println("Client accepted");

			// takes input from the client socket
			input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

			// sends output to the socket
			out = new DataOutputStream(socket.getOutputStream());

			Scanner scanner= new Scanner(System.in);
			String ClientMsg="";
			String line = "";

			// reads message from client until "/q" is sent
			while (!line.equals("/q"))
			{
				try
				{


					System.out.print("Server: ");
					ClientMsg=scanner.nextLine();
					out.writeUTF(ClientMsg);

					line = input.readUTF();
					System.out.println(line);

				}
				catch(IOException i)
				{
					System.out.println(i);
				}
			}
			System.out.println("Closing connection");

			// close connection
			socket.close();
			input.close();
		}
		catch(IOException i)
		{
			System.out.println(i);
		}
	}

	public static void main(String args[])
	{
		Server server = new Server(5000);
	}
}
