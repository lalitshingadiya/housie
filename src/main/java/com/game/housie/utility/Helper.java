package com.game.housie.utility;

import com.game.housie.model.MediUser;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {

    public static String getTodayDate(){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(new Date());
    }
    public static Date getTodayDateDDMMYYYY() {
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            return df.parse(new Date().toString());
        } catch (Exception e) {
            return null;
        }
    }
     public static Long getUserId(SecurityContext sc){
            MediUser user=(MediUser) sc.getAuthentication().getPrincipal();
            return user.getUserId();
        }
    public static String getUserName(SecurityContext sc){
        MediUser user=(MediUser) sc.getAuthentication().getPrincipal();
        return user.getUsername();
    }

    }


