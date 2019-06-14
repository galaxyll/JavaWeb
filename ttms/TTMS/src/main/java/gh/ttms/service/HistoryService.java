package gh.ttms.service;

import gh.ttms.pojo.param.Stringstring;

import java.util.List;

public interface HistoryService {
    public void putMovieToHistory(Stringstring param);
    public List<String> getMovieFromHistory(String moviename);
}
