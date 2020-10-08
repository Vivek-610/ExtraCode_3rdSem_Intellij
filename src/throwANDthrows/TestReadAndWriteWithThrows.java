//Major Point, throws keyword is used only for checked exceptions.

package throwANDthrows;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

class ReadAndWriteWithThrows {
    void readFile() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("d:/abc.txt");
        //Statements
    }

    void saveFile() throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("d:/pqr.txt");
        //Statements
    }
}

public class TestReadAndWriteWithThrows {
//    public static void main(String[] args) throws FileNotFoundException{
    public static void main(String[] args) {
        System.out.println("\n\t\t*****Coding With Throws*****");

        ReadAndWriteWithThrows rw = new ReadAndWriteWithThrows();
        try{
            rw.readFile();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try{
            rw.readFile();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("\n\tProgram Completed\n\tMade By:- VIVEK D KAPADIA\n\t19CE055");
    }
}


