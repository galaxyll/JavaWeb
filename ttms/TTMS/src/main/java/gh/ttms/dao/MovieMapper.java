package gh.ttms.dao;

import gh.ttms.pojo.Movie;
import gh.ttms.pojo.param.Stringstring;

import java.util.List;

public interface MovieMapper {
    public void addMovie(Movie movie);

    //@Insert("insert into movie(photo) values (#{photo}) where moviename=#{moviename}")
    public void addPhoto(Movie movie);

    public Movie getMovieByName(String moviename);

    public Integer getIDByName(String moviename);

    public List<Movie> getMovieList();

    public void updateMovie(Movie movie);

    public List<String> getMovieNameNotShow();

    public List<String> getMovieNameHadShow();

    public void updateMovieStatus(String moviename);

    public void deleteMovie(String moviename);

    public List<Stringstring> getHotMovieList();
    public List<Stringstring> getHighMovieList();
    public List<Stringstring> getFutureMovieList();

}
