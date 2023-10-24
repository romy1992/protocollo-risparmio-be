package com.protocollo.risparmio.brk.controller;

import com.protocollo.risparmio.brk.model.LoginRequest;
import com.protocollo.risparmio.brk.model.UserContainerModel;
import com.protocollo.risparmio.brk.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@CrossOrigin(origins = {"http://localhost:3000","https://protocollo-risparmio.netlify.app/"})
public class AuthController {

  @Autowired AuthService authService;

  @PostMapping("login")
  public Boolean login(@RequestBody LoginRequest model){
    return authService.login(model);
  }

  @PostMapping("insert/user")
  public UserContainerModel insert(@RequestBody UserContainerModel model) {
    return authService.insert(model);
  }

  @GetMapping("search/{email}")
  public UserContainerModel search(@PathVariable(name = "email") String email) {
    return authService.search(email);
  }

  @PutMapping("update")
  public UserContainerModel update(@RequestBody UserContainerModel model) {
    return authService.update(model);
  }

  @DeleteMapping("delete/{email}")
  public Boolean delete(@PathVariable(name = "email") String email) {
    return authService.delete(email);
  }
}
