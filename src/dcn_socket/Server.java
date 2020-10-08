import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args){
        try{
//-------------------0. Check Communication Established or Not ----------------
        ServerSocket ss = new ServerSocket(4999);
        Socket s = ss.accept();
        System.out.println("Client Connected");

//-------------------------1.  One Way Communication -----------------------
//------------------ Sending data from Client to server---------------------
        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        String str = bf.readLine();
        System.out.println("Client : "+str);


//-------------------------2. Two Way Communication--------------------------
//---------------------------Client to Server--------------------------------
//---------------------------Server to Client--------------------------------
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("Yes");
        pr.flush();
//------------Basically Copy 1. of Client and Past under 2. of Server--------
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
