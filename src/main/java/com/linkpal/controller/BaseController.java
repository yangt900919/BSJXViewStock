package com.linkpal.controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public abstract class BaseController<E> {

    public abstract void create(HttpServletRequest request, HttpServletResponse response, E obj) throws Exception;

    public abstract void delete(HttpServletRequest request, HttpServletResponse response, int fid) throws Exception;

    public abstract void update(HttpServletRequest request, HttpServletResponse response, E obj) throws Exception;

    public abstract ModelAndView getList(HttpServletRequest request);

    public abstract void getTipList(HttpServletRequest request, HttpServletResponse response) throws Exception;

    public abstract ModelAndView getDetail(HttpServletRequest request);

    public abstract ModelAndView toAdd();

    public abstract ModelAndView toEdit(HttpServletRequest request, int fid);

    public abstract ModelAndView getMatchList(HttpServletRequest request, String fnumber);


}
