package com.protocollo.risparmio.brk.model;

import lombok.Data;

@Data
public class LoginRequest {
  private String email;
  private String password;
}
