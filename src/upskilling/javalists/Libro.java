
package upskilling.javalists;


public class Libro {
    private String title;
    private String author;
    private int yearPublication;
    
    public Libro (String title, String author, int yearPublication){
        this.title = title;
        this.author = author;
        this.yearPublication = yearPublication;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublication() {
        return yearPublication;
    }

    public void setYearPublication(int yearPublication) {
        this.yearPublication = yearPublication;
    }

    @Override
    public String toString() {
        return "{" + title + ", "+ author + ", " + yearPublication + '}';
    }
    
}
