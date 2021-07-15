import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Episode {
    private String name, brief, formatDate;
    private LocalDate publishDate;
    private DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public Episode(String name, String brief, int day, int month, int year) {
        this.name = name;
        this.brief = brief;
        this.publishDate = LocalDate.of(year, month, day);
        this.formatDate = publishDate.format(formater);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }




    public String toString() {
        return String.format("%s \n", name) +
                String.format("%s \n", brief) +
                String.format("%s \n", formatDate) ;
    }


    public boolean equals(Object obj) {
        if (obj instanceof Episode) {
            if (((Episode)obj).getName().equals(this.name)) {
                return true;
            }
        }
        return false;
    }


}
