package throwANDthrows;

public class TestThrow {
    public static void main(String[] args) {
        System.out.println("\n\t\t****Code For Throw*****\n");
        TestThrow t = new TestThrow();
        t.divide();
//        throw new ArithmeticException("\n\n\t\tWorking of throw is checked by\n\t\tVIVEK D KAPADIA - 19CE055");
    }

    void divide() {
        try {
            int a = 200, b = 0, c;
            c = a / b;
            System.out.println(c);
        } catch (Exception e) {
//            e.printStackTrace();
            throw new ArithmeticException("\n\n\t\tWorking of throw is checked by\n\t\tVIVEK D KAPADIA - 19CE055");
        }
    }
}

