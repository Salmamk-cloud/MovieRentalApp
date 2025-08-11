loginButton.setOnClickListener(v -> {
    String u = usernameEditText.getText().toString().trim();
    String p = passwordEditText.getText().toString().trim();
    if (u.isEmpty() || p.isEmpty()) { Toast.makeText(this,"Champs requis",Toast.LENGTH_SHORT).show(); return; }
    new Thread(() -> {
        User user = db.userDao().login(u, p);
        runOnUiThread(() -> {
            if (user != null) {
                Intent i = new Intent(this, MovieListActivity.class);
                i.putExtra("USER_ID_EXTRA", user.id);
                i.putExtra("USERNAME_EXTRA", user.username);
                startActivity(i); finish();
            } else {
                Toast.makeText(this,"Identifiants invalides",Toast.LENGTH_SHORT).show();
            }
        });
    }).start();
});
