import java.util.Scanner;

public class Input {
    private static Scanner s = new Scanner(System.in);

    public static User sign_up(String u_name) {
        System.out.println("Insert name:");
        String name = s.nextLine();
        String pass = create_pass();
        User newUser = new User(name, u_name, pass, 12);
        return newUser;
    }

    public static String create_pass() {
        String pass = "";
        int c1 = 0, c2 = 0;
        System.out.println("Plz insert password:");
        boolean isStrong = false;
        do {
            System.out.println("(Password must be at least 6 characters,at least one english letter, and one digit)");
            pass = s.next();
            for (int i = 0; i < pass.length(); i++) {
                if (Character.isDigit(pass.charAt(i))) {
                    c1++;
                }
                if (Character.isAlphabetic(pass.charAt(i))) {
                    c2++;
                }
                if (c1 > 0 && c2 > 0 && pass.length() > 5) {
                    isStrong = true;
                    break;
                }
            }
        } while (!isStrong);
        return pass;
    }
}

