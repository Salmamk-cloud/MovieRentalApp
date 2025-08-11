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

