
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client
{
	// initialize socket and input output streams
	private Socket socket		 = null;
	private DataInputStream input = null;
	private DataOutputStream out	 = null;

	// constructor to put ip address and port
	public Client(String address, int port)
	{
		// establish a connection
		try
		{
			socket = new Socket(address, port);
			System.out.println("Connected!");
			System.out.println("Awaiting on a confirmation reply from the Server to begin...");

			// takes input from terminal
			input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

			// sends output to the socket
			out = new DataOutputStream(socket.getOutputStream());
		}
		catch(UnknownHostException u)
		{
			System.out.println(u);
		}
		catch(IOException i)
		{
			System.out.println(i);
		}

		// string to read message from input

		Scanner scanner= new Scanner(System.in);
		String serverMsg="";

		String line = "";

		// keep reading until "/q" is input
		while (!line.equals("/q"))
		{

			try
			{

				
				serverMsg = input.readUTF();
				System.out.println((String) serverMsg);

				System.out.print("Client: ");
				line = scanner.nextLine();
				out.writeUTF(line);

			}       
			catch(IOException i)
			{
				System.out.println(i);
			}
		}

		// close the connection
		try
		{
			input.close();
			out.close();
			socket.close();
		}
		catch(IOException i)
		{
			System.out.println(i);
		}
	}

	public static void main(String args[])
	{
		Client client = new Client("localhost", 5000);
	}
}
