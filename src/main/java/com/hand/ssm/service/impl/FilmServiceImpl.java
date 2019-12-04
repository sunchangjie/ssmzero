package com.hand.ssm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hand.ssm.domain.Film;
import com.hand.ssm.mapper.IFilmMapper;
import com.hand.ssm.service.IFilmService;

@Service
public class FilmServiceImpl implements IFilmService {

    @Autowired
    private IFilmMapper filmMapper;

    @Override
    public List<Film> findAll() {
        List<Film> filmList = new ArrayList<>();
        filmList = filmMapper.findAll();
        return filmList;
    }
}
