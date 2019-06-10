package gh.ttms.dao;

import gh.ttms.pojo.Movie;

import java.util.List;

public interface MovieMapper {
    public void addMovie(Movie movie);

    //@Insert("insert into movie(photo) values (#{photo}) where moviename=#{moviename}")
    public void addPhoto(String moviename ,String photo);

    public Movie getMovieByName(String moviename);

    public List<Movie> getMovieList();
}
