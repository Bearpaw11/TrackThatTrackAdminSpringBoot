package com.TrackThatTrackAdmin;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class LearningTest {
  
  @Test
  public void encrypt_password () {
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    
    String encodedPassword = passwordEncoder.encode("track");
    
    System.out.println(encodedPassword);
  }
}
