package gh.ttms.controller;

import gh.ttms.pojo.Movie;
import gh.ttms.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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
    public Map<String,String> addPhoto(HttpServletRequest request)
    {
        Map<String,String> map = new HashMap<>();
        System.out.println(request.getParameter("noneImg"));
        if (request instanceof MultipartHttpServletRequest) {
            System.out.println("是multipart请求");
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile file = multipartRequest.getFile("file");

            //String filename = file.getOriginalFilename();
            String movieName = (String)multipartRequest.getParameter("noneImg");
            System.out.println("moviename" + movieName);
            String imgName = String.valueOf(movieService.getID(movieName));
//        Cookie[] cookies = request.getCookies();
//        for (Cookie cookie:cookies){
//            if (cookie.getName().equals("noneImg")){
//                movieName  = (String) cookie.getValue();
//                map.put("message",movieName);
//            }
//        }
//        map.put("message","没找到");
//        return map;
            File dest = new File(imgName);
            try {
                file.transferTo(dest);
                movieService.addPhoto(movieName, "http://192.168.43.133:8080/TTMS/img/" + imgName);
                map.put("status", "200");
                map.put("message", "OK");
            } catch (IllegalStateException | IOException e) {
                map.put("status", "500");
                map.put("message", "上传文件失败！");
                e.printStackTrace();
            }
        }
        else {
            System.out.println("不是multpart请求");
        }

        return map;
    }

    @ResponseBody
    @RequestMapping("/getMovieList")
    public List<Movie> getMovieList()
    {
        List<Movie> movies = movieService.getMovieList();
        return movies;
    }

    @RequestMapping("/img/{imgName}")
    public void getImg(@PathVariable("imgName") String imgName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletOutputStream img = response.getOutputStream();
        String imgPath = "/home/galaxy/GitRepos/JavaWeb/ttms/TTMS/src/main/resources/img/"+imgName;
        FileInputStream fileInputStream = new FileInputStream(imgPath);
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = fileInputStream.read(buffer))>0){
            img.write(buffer,0,len);
        }
        fileInputStream.close();
        img.close();
    }

    @ResponseBody
    @RequestMapping("/getMovieByName")
    public Movie getMovieByName(@RequestBody Map<String,String> movie)
    {
        return movieService.getMovieByName(movie.get("moviename"));
    }

    @ResponseBody
    @RequestMapping("/alterMovie")
    public Map<String,String> alterMovie(@RequestBody Movie movie)
    {
        Map<String,String> map = new HashMap<>();
        movieService.alterMovie(movie);
        System.out.println(movieService.getMovieByName(movie.getMoviename()).getDuration());
        map.put("status","200");
        map.put("message","OK");
        return map;
    }

    @ResponseBody
    @RequestMapping("/getMovieNameListNotShow")
    public List<String> getMovieNameNotShow()
    {
        return movieService.getMovieNameNotShow();
    }
}
