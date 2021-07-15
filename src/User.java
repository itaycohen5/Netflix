import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private String name, userName, password, formatedCreated, formatedMembershipEnd;
    private LocalDate created, membershipEnd;
    private DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private HashMap<TvShow, ArrayList<String>> shows_watched;

    public User() {}
    public User(String name, String u_name, String password, int monthsOfMembership) {
        this.name = name;
        this.userName = u_name;
        this.password = password;
        this.created = LocalDate.now();
        this.formatedCreated = created.format(formater);
        this.membershipEnd = created.plusMonths(monthsOfMembership);
        this.formatedMembershipEnd = membershipEnd.format(formater);
        this.shows_watched = new HashMap<TvShow, ArrayList<String>>();
    }


    public User(User user) {

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getU_name() {
        return userName;
    }
    public void setU_name(String u_name) {
        this.userName = u_name;
    }
    public String getPassword() {
        return password;
    }
    public String getFormatedCreated() {
        return formatedCreated;
    }
    public String getFormatedMembershipEnd() {
        return formatedMembershipEnd;
    }
    public HashMap<TvShow, ArrayList<String>> getShowsWatched() {
        return shows_watched;
    }

    public void displayWatchedShows() {
        for (TvShow key : shows_watched.keySet()) {
            System.out.println(key.getName());
            System.out.println("Last episode: " + shows_watched.get(key).get(shows_watched.get(key).size()-1));

        }
    }

    public void viewMemberDetails() {
        int totalShows = shows_watched.size(), showsFinished = 0, totalEpisodes = 0;

        for (TvShow key : shows_watched.keySet()) {
            ArrayList<String> a = shows_watched.get(key);
            totalEpisodes += a.size();
            String lastEpisode = a.get(a.size()-1);
            if (key.getEpisodes().get(key.getEpisodes().size()-1).getName().equals(lastEpisode)) {
                showsFinished ++;
            }
        }

        System.out.println(toString());
        System.out.println("Total shows watched " + totalShows);
        System.out.println("Total episodes watched " + totalEpisodes);
        System.out.println("Total shows finished " + showsFinished);
    }

    public void addToWatched(TvShow show, String episode) {
        if (!shows_watched.containsKey(show)) {
            shows_watched.put(show, new ArrayList<String>());
        }
        shows_watched.get(show).add(episode);
    }


    public String toString() {
        return "Hello, this is user info:\n" +
                String.format("Name: %s\n", name) +
                String.format("User name: %s\n", userName) +
                String.format("Joined at: %s\n", formatedCreated) +
                String.format("Ending in: %s\n", formatedMembershipEnd) ;
    }

}
