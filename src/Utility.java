
public class Utility {

	public static String generateResponse(String commandFromServer) {
		// TODO Auto-generated method stub
		System.out.println("generating response for:"+ commandFromServer);
		String response="";
		String header="";
		String responseIdentiication="";
		String optionalTextBlock="";
		String terminator=";";
		String[] blocks=commandFromServer.split(":");
		String TID=blocks[1];
		String CTAG=blocks[3];
		if(TID!=null){
			header="   "+TID+" 2016-12-20 12:00:00";
		}else{
			header="   EDFA3 2016-12-20 12:00:00";
		}
		responseIdentiication="M  "+CTAG+" COMPLD";
		optionalTextBlock="optiona more information about response message ";
		response=header+" "+responseIdentiication+" "+optionalTextBlock+terminator;
		System.out.println("response succesfully generated:"+ response);
		return response;
	}
	

}
