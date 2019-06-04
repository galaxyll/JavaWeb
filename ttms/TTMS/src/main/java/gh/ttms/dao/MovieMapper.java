package gh.ttms.dao;

import gh.ttms.pojo.Movie;

public interface MovieMapper {
    public void addMovie(Movie movie);
    public Movie getMovieByName(String moviename);

}
