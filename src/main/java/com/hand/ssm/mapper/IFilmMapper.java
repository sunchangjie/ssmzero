package com.hand.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.hand.ssm.domain.Film;

//@Component
public interface IFilmMapper {

//    @Select("select film_id,title,description,release_year,language_id from film")
//    @Results({
//            @Result(id=true,property = "film_id",column = "filmId"),
//            @Result(property = "title",column = "title"),
//            @Result(property = "description",column = "description"),
//            @Result(property = "release_year",column = "releaseYear"),
//            @Result(property = "language_id",column = "languageId"),
//    })
    List<Film> findAll();

}
