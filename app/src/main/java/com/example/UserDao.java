@Dao
public interface UserDao {
    @Insert void insertUser(User user);

    @Query("SELECT * FROM users WHERE username = :username AND password = :password")
    User login(String username, String password);

    @Query("SELECT COUNT(id) FROM rentals WHERE userId = :userId")
    int getRentedMovieCount(int userId);
}
@Delete void returnMovie(Rental r);
new Thread(() -> {
    Rental r = db.rentalDao().getRentalByUserIdAndMovieId(userId, movie.id);
    if (r != null) {
        db.rentalDao().returnMovie(r);
        movie.copiesAvailable += 1;
        db.movieDao().updateMovie(movie);
    }
    runOnUiThread(this::refreshList);
}).start();

