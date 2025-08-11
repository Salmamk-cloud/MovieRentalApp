@Entity(tableName = "users")
public class User {
    @PrimaryKey(autoGenerate = true) public int id;
    public String username;
    public String password;

    public User(String username, String password) {
        this.username = username; this.password = password;
    }
}
