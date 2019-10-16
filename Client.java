import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	Socket c=new Socket("192.168.42.157", 5000);
	System.out.println("Connected");
	Scanner scanner=new Scanner(System.in);
	DataInputStream din=new DataInputStream(c.getInputStream());
	DataOutputStream dout=new DataOutputStream(c.getOutputStream());
	while(true)
	{
		System.out.println("Enter message:-");
		String cmsg=scanner.nextLine();
		dout.writeUTF(cmsg);
		if(cmsg.equals("exit"))
		{
			System.out.println("Quiting!!!");
			din.close();
			dout.close();
			scanner.close();
			c.close();
			System.exit(0);
		}
		String smsg=din.readUTF();
		System.out.println("Server:-"+smsg);
		if(smsg.equals("exit"))
		{
			System.out.println("Quiting!!!");
			din.close();
			dout.close();
			scanner.close();
			c.close();
			System.exit(0);
		}
	}
} catch (UnknownHostException e) {
	// TODO Auto-generated catch block
	//e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	//e.printStackTrace();
}

	}

}
