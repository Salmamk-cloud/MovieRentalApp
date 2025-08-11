@Dao
public interface RentalDao {
    @Insert void rentMovie(Rental r);

    @Query("SELECT movies.* FROM movies INNER JOIN rentals ON movies.id = rentals.movieId WHERE rentals.userId = :userId")
    List<Movie> getRentedMoviesForUser(int userId);

    @Query("SELECT * FROM rentals WHERE userId = :userId AND movieId = :movieId LIMIT 1")
    Rental getRentalByUserIdAndMovieId(int userId, int movieId);

    @Delete void returnMovie(Rental rental);
}
