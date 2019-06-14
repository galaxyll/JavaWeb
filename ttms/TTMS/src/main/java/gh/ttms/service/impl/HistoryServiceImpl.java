package gh.ttms.service.impl;

import gh.ttms.dao.HistoryMapper;
import gh.ttms.pojo.param.Stringstring;
import gh.ttms.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryMapper historyMapper;

    @Override
    public void putMovieToHistory(Stringstring param) {
        historyMapper.putMovieToHistory(param);
    }

    @Override
    public List<String> getMovieFromHistory(String moviename) {
        return historyMapper.getMovieFromHistory(moviename);
    }
}
