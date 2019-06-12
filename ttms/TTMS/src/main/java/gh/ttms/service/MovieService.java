package gh.ttms.service;

import gh.ttms.pojo.Movie;

import java.util.List;

public interface MovieService {
    public void addMovie(Movie movie);
    public void addPhoto(String moviename,String photo);
    public List<Movie> getMovieList();
    public int getID(String moviename);
    public Movie getMovieByName(String moviename);
    public void alterMovie(Movie movie);
    public List<String> getMovieNameNotShow();
    public void takeMovieON(String moviename);
    public void takeMovieDown(String moviename);
}
