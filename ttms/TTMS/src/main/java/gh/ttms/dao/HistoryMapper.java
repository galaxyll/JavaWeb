package gh.ttms.dao;

import gh.ttms.pojo.param.Stringstring;

import java.util.List;

public interface HistoryMapper {
    public void putMovieToHistory(Stringstring param);
    public List<String> getMovieFromHistory(String username);
}
