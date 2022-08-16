package com.TrackThatTrackAdmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	//mapping to return login page
  @GetMapping("/login")
  public String login () {
    return "login";
  }
}
