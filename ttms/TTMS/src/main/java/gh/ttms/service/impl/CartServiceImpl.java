package gh.ttms.service.impl;

import gh.ttms.dao.CartMapper;
import gh.ttms.pojo.param.Stringstring;
import gh.ttms.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    public void putMovieToCart(Stringstring param) {
        cartMapper.putMovieToCart(param);
    }

    @Override
    public List<String> getMovieFromCart(String moviename) {
        return cartMapper.getMovieFromCart(moviename);
    }
}
