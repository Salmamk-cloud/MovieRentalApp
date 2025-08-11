public interface OnRentClick { void onRent(Movie m); }
public interface OnTrailerClick { void onTrailer(Movie m); }

// onBindViewHolder (extrait)
holder.titleTextView.setText(m.title);
holder.descriptionTextView.setText(m.description);
holder.copiesTextView.setText("Copies : " + m.copiesAvailable);
if (m.imageUrl != null && !m.imageUrl.isEmpty()) Picasso.get().load(m.imageUrl).into(holder.movieImageView);

holder.rentButton.setOnClickListener(v -> rentClick.onRent(m));
holder.trailerButton.setOnClickListener(v -> trailerClick.onTrailer(m));
if (m.imageUrl != null && !m.imageUrl.isEmpty()) {
    Picasso.get().load(m.imageUrl).into(holder.movieImageView);
} else {
    holder.movieImageView.setImageDrawable(null);
}
