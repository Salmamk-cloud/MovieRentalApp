Bundle extras = getIntent().getExtras();
if (extras != null) {
    String title = extras.getString("title");
    String description = extras.getString("description");
    String posterUrl = extras.getString("posterUrl");
    tvMovieTitle.setText(title);
    tvMovieDescription.setText(description);
    if (posterUrl != null && !posterUrl.isEmpty()) Picasso.get().load(posterUrl).into(ivMoviePoster);
}
