public class Film {
    int id;
    String title;
    double rating;

    public Film(int id, String title, double rating) {
        this.id = id;
        this.title = title;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nJudul Film: " + title + "\nipk: " + rating;
    }
}
