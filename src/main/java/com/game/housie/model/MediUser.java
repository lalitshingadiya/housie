package com.game.housie.model;

import java.util.Collection;

import org.springframework.security.core.userdetails.User;

  public class MediUser extends User {

      private static final long serialVersionUID = -3531439484732724601L;

      @Override
      public String getUsername() {
          return username;
      }
      private final String username;
      private final Long userId;
      public MediUser(String username, String password, Long userId, Collection authorities) {

          super(username, password,  authorities);

          this.userId = userId;
          this.username = username;
      }
      public static long getSerialVersionUID() {
          return serialVersionUID;
      }
      public Long getUserId() {
          return userId;
      }
  }