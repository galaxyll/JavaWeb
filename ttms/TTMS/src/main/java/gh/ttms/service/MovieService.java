package gh.ttms.service;

import gh.ttms.pojo.Movie;
import gh.ttms.pojo.Ticket;
import gh.ttms.pojo.param.IntAndString;
import gh.ttms.pojo.param.Stringstring;

import java.util.List;

public interface MovieService {
    public void addMovie(Movie movie);
    public void addPhoto(String moviename,String photo);
    public List<Movie> getMovieList();
    public int getID(String moviename);
    public Movie getMovieByName(String moviename);
    public void alterMovie(Movie movie);
    public List<String> getMovieNameNotShow();
    public List<String> getMovieNameHadShow();
    public void takeMovieON(String moviename);
    public void takeMovieDown(String moviename);
    public List<Stringstring> getHHFMovieList(String type);
    public void addMovieQuantity(String param);
    public String getPhotoByName(String moviename);
    public void markMovie(Ticket ticket);
    public List<IntAndString> getMovieSell();
    public void delMovie(String moviename);
}
