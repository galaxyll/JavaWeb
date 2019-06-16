package gh.ttms.service;


import gh.ttms.pojo.param.Stringstring;

import java.util.List;

public interface CartService {
    public void putMovieToCart(Stringstring param);
    public List<String> getMovieFromCart(String moviename);
    public void delMovieFromCart(Stringstring param);
}
