import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket ss=new ServerSocket(3000);
			System.out.println("Waiting For Connection:-");
			System.out.println("Waiting For :-");
			Socket s=ss.accept();
			Scanner scanner=new Scanner(System.in);
			DataInputStream din=new DataInputStream(s.getInputStream());
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());
			while(true)
			{
				String cmsg=din.readUTF();
				System.out.println("Client:-"+cmsg);
				if(cmsg.equals("exit"))
				{
					System.out.println("Quiting!!!");
					din.close();
					dout.close();
					scanner.close();
					s.close();
					ss.close();
					System.exit(0);
				}
			
				System.out.println("Enter message:-");
				String smsg=scanner.nextLine();
				dout.writeUTF(smsg);
				if(smsg.equals("exit"))
				{
					System.out.println("Quiting!!!");
					din.close();
					dout.close();
					scanner.close();
					s.close();
					ss.close();
					System.exit(0);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
