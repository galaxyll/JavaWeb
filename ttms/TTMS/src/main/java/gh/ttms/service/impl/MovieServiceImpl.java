package gh.ttms.service.impl;

import gh.ttms.dao.MovieMapper;
import gh.ttms.pojo.Movie;
import gh.ttms.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("movieService")
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;

    @Override
    public void addMovie(Movie movie) {
        movieMapper.addMovie(movie);
    }

    @Override
    public void addPhoto(String moviename,String photo) {
        Movie movie = new Movie();
        movie.setMoviename(moviename);
        movie.setPhoto(photo);
        movieMapper.addPhoto(movie);
    }

    @Override
    public List<Movie> getMovieList() {
        return movieMapper.getMovieList();
    }

    @Override
    public int getID(String moviename) {
        return movieMapper.getIDByName(moviename);
    }

    @Override
    public Movie getMovieByName(String moviename) {
        Movie movie = movieMapper.getMovieByName(moviename);
        if (movie==null){
            System.out.println("movie==null");
        }
        return movie;
    }


}
