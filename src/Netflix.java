import java.util.ArrayList;
import java.util.Scanner;

public class Netflix {
    private ArrayList<User> users;
    private ArrayList<TvShow> tv_shows;
    private Scanner s = new Scanner(System.in);
    public Netflix() {
        users = new ArrayList<User>();
        tv_shows = new ArrayList<TvShow>();
    }
    public void add_user(String u_name , String pass) {
        login(u_name , pass);
    }


    public User login(String u_name, String pass) {
        User u = null;
        for (User user : users) {
            if (user.getU_name().equals(u_name) && user.getPassword().equals(pass)) {
                u = user;
                u = new User(user);

                break;
            }
        }
        return u;
    }

    public void addTvShow() {
        String ep_name, brief;
        int day, month, year, choice;
        TvShow tv1 = new TvShow("Arrow");
        tv1.add_episode("1" ,"Oliver assembles a group of unlikely allies - Slade, Nyssa, Merlyn and Digger Harkness - to engage in an epic battle against Chase and his army." ,24,5,2017);
        tv1.add_episode("2" ,"Oliver deals with the fallout of the explosion on the island." ,12,10,2017);
        tv1.add_episode("3" ,"Anatoly returns to Star City with a sinister agenda as Oliver tries to balance being the mayor, the Green Arrow and William's father." ,19,10,2017);
        tv_shows.add(tv1);
        TvShow tv2 = new TvShow("friends");
        tv2.add_episode("1" , "Ross tries to get Rachel to go back to Ralph Lauren, Joey doesn't know that his agent has died, and Monica and Chandler bump into Janice.",22,4,2004);
        tv2.add_episode("2"  , "The gang throws Rachel a goodbye party, during which she says goodbye to everybody individually." , 29,4,2004);
        tv2.add_episode("3" ,"Phoebe races Ross to the airport in a bid to stop Rachel from leaving for Paris. Monica and Chandler pack up their apartment ahead of their move to their new house, and Joey buys Chandler a new chick and duck as a leaving present." , 6,5,2005);
        tv_shows.add(tv2);
        TvShow tv3 = new TvShow("GOT");
        tv3.add_episode("1" ,"Cersei and Loras Tyrell stand trial by the gods. Daenerys prepares to set sail for Westeros. Davos confronts Melisandre. Sam and Gilly arrive in the Citadel. Bran discovers a long-kept secret. Lord Frey has an uninvited guest." ,26,6,2016);
        tv3.add_episode("2" ,"Jon organizes the North's defenses. Cersei tries to even the odds. Daenerys comes home. Arya reminds the Freys \"the North remembers.\" Sam adapts to life in Oldtown. The Night King makes his way south." , 16,7,2017);
        tv3.add_episode("3" , "Daenerys receives an unexpected visitor. Jon faces resistance. Tyrion plans the conquest of Westeros. Cersei gathers her allies. Arya has a reunion with old friends. Sam risks his career and life." , 23,7,2017);

        tv_shows.add(tv3);

    }

    public boolean check_u_name(String u_name) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getU_name().equals(u_name)) {
                return false;
            }
        }
        return true;
    }

    public void display_all_tvShows() {
        for (TvShow tvShow : tv_shows) {
            System.out.println(tvShow.getName());
        }
    }

    public void watch_show(String showName, User user) {
        TvShow t = null;
        for (TvShow tvShow : tv_shows) {
            if (tvShow.getName().equals(showName)) {
                t = tvShow;
                if (user.getShowsWatched().containsKey(tvShow.getName())) {
                    ArrayList<String> a = user.getShowsWatched().get(tvShow.getName());
                    System.out.printf("You watched episode %s", a.get(a.size()-1));
                }
                tvShow.view_episodes();
            }
        }
        if (t == null) {
            System.out.println("Show does not exist");
            return;
        }
        System.out.println("Plz enter name of episode you wanna watch");
        String ep_name = s.next();
        if (t.check_ep_exist(ep_name)) {
            user.addToWatched(t, ep_name);
        }
    }









}

