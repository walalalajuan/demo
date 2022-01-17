package com.example.demo.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Alan.Juan
 *
 */
public class Utils {

    public static String getCurrentUserName() {
        String currentUser = "";
        
        Object principl = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principl instanceof UserDetails) {
            currentUser = ((UserDetails) principl).getUsername();
        } else {
            currentUser = principl.toString();
        }
        return currentUser;
    }
}
