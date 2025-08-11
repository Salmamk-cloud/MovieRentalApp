package com.example.movierentalapp;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
    tableName = "rentals",
    foreignKeys = {
        @ForeignKey(entity = User.class,   parentColumns = "id", childColumns = "userId",  onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = Movie.class,  parentColumns = "id", childColumns = "movieId", onDelete = ForeignKey.CASCADE)
    }
)
public class Rental {
    @PrimaryKey(autoGenerate = true) public int id;
    public int userId;
    public int movieId;

    public Rental(int userId, int movieId) {
        this.userId = userId;
        this.movieId = movieId;
    }
}
