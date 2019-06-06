package gh.ttms.service;

import gh.ttms.pojo.Movie;

public interface MovieService {
    public void addMovie(Movie movie);
    public void addPhoto(String moviename,String photo);
    public Movie getMovie();
}
