@Dao
public interface MovieDao {
    @Insert void insertAllMovies(java.util.List<Movie> movies);
    @Query("SELECT * FROM movies") java.util.List<Movie> getAllMovies();
    @Update void updateMovie(Movie movie);
}
