@Dao
public interface UserDao {
    @Insert void insertUser(User user);

    @Query("SELECT * FROM users WHERE username = :username AND password = :password")
    User login(String username, String password);

    @Query("SELECT COUNT(id) FROM rentals WHERE userId = :userId")
    int getRentedMovieCount(int userId);
}
