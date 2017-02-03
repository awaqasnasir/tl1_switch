import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ConnetionListener {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int request=0;
		try {
			ServerSocket server=new ServerSocket(2222);
			System.out.println("waiting for connections");
			while(true){
				Socket connection=server.accept();
				request++;
				System.out.println("accepted request "+request);
				virtualSwitch VSwitch=new virtualSwitch(connection);
				VSwitch.start();
				
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
