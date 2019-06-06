package gh.ttms.controller;

import gh.ttms.pojo.Movie;
import gh.ttms.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping("/addMovieExceptPhoto")
    @ResponseBody
    public Map<String,String> addMovie(@RequestBody Movie movie)
    {
        movieService.addMovie(movie);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("message","OK");
        return map;
    }

    @RequestMapping("/addMovieOnlyPhoto")
    @ResponseBody
    public Map<String,String> addPhoto(MultipartFile file)
    {
        Map<String,String> map = new HashMap<>();
        String filename = file.getOriginalFilename();
        File dest = new File(filename);
        try {
            file.transferTo(dest);
            movieService.addPhoto("","/home/admin/galaxy/ttms/"+filename);
            map.put("status","200");
            map.put("message","OK");
        } catch (IllegalStateException | IOException e){
            map.put("status","500");
            map.put("message","上传文件失败！");
            e.printStackTrace();
        }
        return map;
    }
}
