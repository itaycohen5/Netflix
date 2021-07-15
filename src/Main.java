import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        Netflix netflix = new Netflix();
        // Add tv shows
        netflix.addTvShow();
        //netflix.add_tv_show();
        User user = authentication(netflix);
        if (user == null) {
            return;
        }
        menu(netflix, user);
    }

    public static User authentication(Netflix netflix) {
        int choice;
        String u_name, password;
        User user = new User();
        while (true) {
            try {
                System.out.println("1.Sign-in");
                System.out.println("2.Sign-up");
                choice = s.nextInt();
                switch (choice) {

                    case 1:
                        System.out.print("Plz insert user name: ");
                        u_name = s.next();
                        System.out.print("Plz insert password: ");
                        password = s.next();
                        user = netflix.login(u_name, password);
                        if (user != null) {
                            return user;
                        }
                        System.out.println("User name or password is not correct");
                        break;

                    case 2:
                        System.out.print("Plz insert user name: ");
                        u_name = s.next();
                        if (netflix.check_u_name(u_name)) {
                            user = Input.sign_up(u_name);
                            return user;
                        }
                        break;
                    default:
                        break;
                }
            } catch (Exception exception) {
                System.out.println("only 1/2");
                s.nextLine();
            }
        }
    }

    public static void menu(Netflix netflix, User user) {
        int choice;
        boolean runMenu = true;
        while(runMenu) {
            try {
                System.out.println("1.List all our tv shows");
                System.out.println("2.List all tv shows you started watching");
                System.out.println("3.View membership details");
                System.out.println("4.Choose tv show to watch");
                System.out.println("5.Log out");
                choice = s.nextInt();
                switch (choice) {
                    case 1:
                        netflix.display_all_tvShows();
                        break;

                    case 2:
                        user.displayWatchedShows();
                        break;

                    case 3:
                        user.viewMemberDetails();
                        break;

                    case 4:
                        System.out.println("Enter the TV show you want to watch:");
                        String showName = s.next();
                        netflix.watch_show(showName, user);
                        break;

                    case 5:
                        System.out.println("Goodbye :)");
                        runMenu = false;
                        break;

                    default:
                        break;
                }
            } catch (Exception exception) {
                System.out.println("only 1/2/3/4/5");
                s.nextLine();
            }
        }
    }

}
