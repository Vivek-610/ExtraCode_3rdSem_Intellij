package throwANDthrows;

import java.util.Scanner;

class YoungerAgeException extends RuntimeException {
    YoungerAgeException(){
        super("\n\t\"Defalt message given by programmer(19CE055)\"");
    }
    YoungerAgeException(String msg) {
        super(msg);
    }
}
public class VotingInThrow {
    public static void main(String[] args) {
        System.out.println("\n\t\t\t*****VOTING*****");

        Scanner sc = new Scanner(System.in);
        System.out.print("\n\tEnter your age:-\t");
        int age = sc.nextInt();
        try {
            if (age < 18) {
                throw new YoungerAgeException("\n\tWorking with throw keyword in Voting Class\n\t\tVIVEK D KAPADIA -19CE055");//Custom Message
//                throw new YoungerAgeException(); //Default Message
            } else {
                System.out.println("\n\tYou can VOTE successfully.");
            }
        } catch (YoungerAgeException e) {
//            System.out.println(e);
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("\t\tThankyou for choosing us.");
    }
}
