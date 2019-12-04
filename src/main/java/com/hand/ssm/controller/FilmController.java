package com.hand.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.hand.ssm.domain.Film;
import com.hand.ssm.service.IFilmService;

@Controller
@RequestMapping(value = "/film")
public class FilmController {
    @Autowired
    private IFilmService filmService;

    @RequestMapping(value = "/findall.do")
    public ModelAndView listFilm() {
        List<Film> filmList = filmService.findAll();
        for (Film film : filmList) {
            System.out.println(film);
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("test");
        return mv;
    }
}
