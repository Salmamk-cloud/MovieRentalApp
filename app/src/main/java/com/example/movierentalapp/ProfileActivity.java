int loggedInUserId = getIntent().getIntExtra("USER_ID_EXTRA", -1);
String username = getIntent().getStringExtra("USERNAME_EXTRA");
TextView usernameTextView = findViewById(R.id.profile_username_text);
TextView rentedCountTextView = findViewById(R.id.rented_count_text);

usernameTextView.setText("Nom d'utilisateur : " + username);
new Thread(() -> {
    int count = db.userDao().getRentedMovieCount(loggedInUserId);
    runOnUiThread(() -> rentedCountTextView.setText("Films loués : " + count));
}).start();
