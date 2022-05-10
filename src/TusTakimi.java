import java.util.Scanner;

public class TusTakimi implements ITusTakimi{
    @Override
    public String stringVeriAl() {
        Scanner input = new Scanner(System.in);
        return input.next();
    }

    @Override
    public int veriAl() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
}
