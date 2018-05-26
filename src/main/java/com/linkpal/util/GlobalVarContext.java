package com.linkpal.util;

import com.linkpal.model.User;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;

public class GlobalVarContext {

    public static User user;

    public static HttpServletRequest request;
}
