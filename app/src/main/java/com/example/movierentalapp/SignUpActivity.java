signUpButton.setOnClickListener(v -> {
    String u = usernameEditText.getText().toString().trim();
    String p = passwordEditText.getText().toString().trim();
    if (u.isEmpty() || p.isEmpty()) { Toast.makeText(this,"Champs requis",Toast.LENGTH_SHORT).show(); return; }
    new Thread(() -> {
        db.userDao().insertUser(new User(u, p));
        User created = db.userDao().login(u, p);
        runOnUiThread(() -> {
            if (created != null) {
                Intent i = new Intent(this, MovieListActivity.class);
                i.putExtra("USER_ID_EXTRA", created.id);
                i.putExtra("USERNAME_EXTRA", created.username);
                startActivity(i); finish();
            }
        });
    }).start();
});
