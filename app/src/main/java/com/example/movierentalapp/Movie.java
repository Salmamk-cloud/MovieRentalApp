@Entity(tableName = "movies")
public class Movie {
    @PrimaryKey(autoGenerate = true) public int id;
    public String title, description, imageUrl, trailerUrl;
    public int copiesAvailable;

    public Movie(String title, String description, String imageUrl, String trailerUrl, int copiesAvailable) {
        this.title = title; this.description = description;
        this.imageUrl = imageUrl; this.trailerUrl = trailerUrl; this.copiesAvailable = copiesAvailable;
    }
}
