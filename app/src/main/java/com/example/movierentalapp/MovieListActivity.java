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
