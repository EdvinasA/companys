package com.data.company.jwt.service;

import com.data.company.jwt.model.Token;
import com.data.company.jwt.repository.TokenCommandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TokenCommandService {

	private final TokenCommandRepository commandRepository;

	public void create(Token token) {
		commandRepository.create(token);
	}

}
