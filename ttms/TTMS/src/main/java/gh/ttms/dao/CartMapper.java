package gh.ttms.dao;

import gh.ttms.pojo.param.Stringstring;

import java.util.List;

public interface CartMapper {
    public void putMovieToCart(Stringstring param);
    public List<String> getMovieFromCart(String username);
    public void delMovieFromCart(Stringstring param);
}
