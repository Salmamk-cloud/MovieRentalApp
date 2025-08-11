moviesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
adapter = new MovieAdapter(
    movie -> { /* onRent plus bas */ },
    movie -> { /* onTrailer plus bas */ }
);
moviesRecyclerView.setAdapter(adapter);
