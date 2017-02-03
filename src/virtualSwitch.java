import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;


public class virtualSwitch extends Thread{
	String ip="";
	private Socket connection;
	private PrintStream write;
	BufferedReader read;
	public virtualSwitch(Socket conn){
		connection=conn;
	}
	

	
	public void run(){
		try {
			write=new PrintStream(connection.getOutputStream());
			read=new BufferedReader(new InputStreamReader(connection.getInputStream()));
		
			//getting handshake message right after accepting connection
			String serverReply=read.readLine();
			if(serverReply.equalsIgnoreCase("Handshake")){
				System.out.println("handshake message received");
				// sending handshake response
				write.println("Handshake response");
				System.out.println("response sent");
				// getting ip from server
				ip=read.readLine();
				System.out.println("device received ip"+ip);
				//wait to receive command
				String commandFromServer="";
				boolean toggelMessage=true;
				while(true){
					if(toggelMessage==true){
						System.out.println("waiting for command");
						toggelMessage=false;
					}
					
					if(connection.getInputStream().available()!=0){
						
						commandFromServer=read.readLine();
						System.out.println("command Received: "+commandFromServer);
						
						String response=Utility.generateResponse(commandFromServer);
						System.out.println("about to send reply");
						write.println(response);
						
						System.out.println("Reply sent: in while"+commandFromServer);
						
						toggelMessage=true;
					}
				}
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
