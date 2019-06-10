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
        movieMapper.addPhoto(moviename,photo);
    }

    @Override
    public List<Movie> getMovieList() {
        return movieMapper.getMovieList();
    }
}
