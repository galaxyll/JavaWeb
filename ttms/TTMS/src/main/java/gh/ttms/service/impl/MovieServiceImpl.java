package gh.ttms.service.impl;

import gh.ttms.dao.MovieMapper;
import gh.ttms.pojo.Movie;
import gh.ttms.pojo.Ticket;
import gh.ttms.pojo.param.FloatAndString;
import gh.ttms.pojo.param.IntAndString;
import gh.ttms.pojo.param.Stringstring;
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
        return movie;
    }

    @Override
    public void alterMovie(Movie movie) {
        movieMapper.updateMovie(movie);
    }

    @Override
    public List<String> getMovieNameNotShow() {
        List<String> movieList = movieMapper.getMovieNameNotShow();
        return movieList;
    }

    @Override
    public List<String> getMovieNameHadShow() {
        List<String> movieList = movieMapper.getMovieNameHadShow();
        return movieList;
    }

    @Override
    public void takeMovieON(String moviename) {
        movieMapper.updateMovieStatus(moviename);
    }

    @Override
    public void takeMovieDown(String moviename) {
        movieMapper.deleteMovie(moviename);
    }

    @Override
    public List<Stringstring> getHHFMovieList(String type) {
        if (type.equals("Hot")){
            return movieMapper.getHotMovieList();
        } else if (type.equals("High")){
            return movieMapper.getHighMovieList();
        }else if (type.equals("Future")){
            return movieMapper.getFutureMovieList();
        }
        return null;
    }

    @Override
    public void addMovieQuantity(String moviename) {
        IntAndString param = new IntAndString();
        param.setName(moviename);
        param.setNum(movieMapper.getMovieQuantity(param.getName()));
        param.setNum(param.getNum()+1);
        movieMapper.addMovieQuantity(param);
    }

    @Override
    public String getPhotoByName(String moviename) {
        return movieMapper.getPhotoByName(moviename);
    }

    @Override
    public void markMovie(Ticket ticket) {
        IntAndString param = new IntAndString();
        System.out.println(ticket.getMoviename());
        System.out.println(movieMapper.getTotalScore(ticket.getMoviename()));
        System.out.println(ticket.getIsMark());
        param.setName(ticket.getMoviename());
        param.setNum(ticket.getIsMark()+movieMapper.getTotalScore(ticket.getMoviename()));
        System.out.println("传入总分："+param.getNum());
        FloatAndString param2 = new FloatAndString();
        param2.setName(ticket.getMoviename());
        param2.setNum(movieMapper.getTotalScore(ticket.getMoviename())/movieMapper.getMovieQuantity(ticket.getMoviename()));
        System.out.println("传入平均分："+param2.getNum());
        //改电影分
        movieMapper.alterTotalScore(param);
        movieMapper.alterScore(param2);
        //改用户评分状态
    }

    @Override
    public List<IntAndString> getMovieSell() {
        return movieMapper.getMovieSell();
    }

    @Override
    public void delMovie(String moviename) {
        movieMapper.deleteMovie(moviename);
    }


}
