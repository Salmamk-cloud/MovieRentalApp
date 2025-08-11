moviesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
adapter = new MovieAdapter(
    movie -> { /* onRent plus bas */ },
    movie -> { /* onTrailer plus bas */ }
);
moviesRecyclerView.setAdapter(adapter);
private boolean showingRented = false;

private void refreshList() {
    new Thread(() -> {
        List<Movie> list = (showingRented && userId != -1)
            ? db.rentalDao().getRentedMoviesForUser(userId)
            : db.movieDao().getAllMovies();
        runOnUiThread(() -> adapter.setMovies(list));
    }).start();
}

allBtn.setOnClickListener(v -> { showingRented = false; refreshList(); });
rentedBtn.setOnClickListener(v -> { showingRented = true;  refreshList(); });
movie -> {
    if (movie.trailerUrl == null || movie.trailerUrl.isEmpty()) {
        Toast.makeText(this,"Bande-annonce non dispo",Toast.LENGTH_SHORT).show(); return;
    }
    try { startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(movie.trailerUrl))); }
    catch (Exception e) { Toast.makeText(this,"Aucune app vidéo",Toast.LENGTH_LONG).show(); }
}
profileBtn.setOnClickListener(v -> {
    Intent i = new Intent(this, ProfileActivity.class);
    i.putExtra("USER_ID_EXTRA", userId);
    i.putExtra("USERNAME_EXTRA", username);
    startActivity(i);
});
userId  = getIntent().getIntExtra("USER_ID_EXTRA", -1);
username = getIntent().getStringExtra("USERNAME_EXTRA");
private void seedIfEmptyThenLoadAll() {
    new Thread(() -> {
        List<Movie> all = db.movieDao().getAllMovies();
        if (all == null || all.isEmpty()) db.movieDao().insertAllMovies(createDefaultMovies());
        runOnUiThread(this::refreshList);
    }).start();
}
private List<Movie> createDefaultMovies() {
    List<Movie> movies = new ArrayList<>();
    movies.add(new Movie("Inception","Un cambrioleur infiltre les rêves.",
        "https://image.tmdb.org/t/p/w500/qmDpIHrmpJINaRKAfWQfftjCdyi.jpg",
        "https://www.youtube.com/watch?v=YoHD9XEInc0",5));
    movies.add(new Movie("The Matrix","La réalité est une simulation.",
        "https://image.tmdb.org/t/p/w500/f89U3ADr1oiB1s9GkdPOEpXUk5H.jpg",
        "https://www.youtube.com/watch?v=vKQi3bBA1y8",3));
    movies.add(new Movie("Interstellar","Voyage au-delà de notre galaxie.",
        "https://image.tmdb.org/t/p/w500/gEU2QniE6E77NI6lCU6MxlNBvIx.jpg",
        "https://www.youtube.com/watch?v=zSWdZVtXT7E",7));
    return movies;
}


