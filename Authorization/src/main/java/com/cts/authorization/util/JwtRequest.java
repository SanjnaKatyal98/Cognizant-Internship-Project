package com.cts.authorization.util;

import lombok.Data;

@Data
public class JwtRequest {

	private String username;
	private String password;
}