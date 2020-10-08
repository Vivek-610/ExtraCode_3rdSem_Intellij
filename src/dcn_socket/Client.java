import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args){
        try{
//-------------0. Check Communication Established or Not -----------
        Socket s = new Socket("localhost",4999);

//----------------------1.  One Way Communication ------------------
//------------------ Sending data from Client to server-------------
        PrintWriter pr = new PrintWriter(s.getOutputStream());
//        pr.println("Hello, Checking Connection");
        pr.println("is it Working");
        pr.flush();

//------------------------2. Two Way Communication------------------
//----------------------------Client to Server----------------------
//----------------------------Server to Client----------------------
        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        String str = bf.readLine();
        System.out.println("Server : "+str);
//------Basically Copy 1. of Server and Past under 2. of Client-----
        }
        catch(Exception e1){
            e1.printStackTrace();
        }
    }
}
