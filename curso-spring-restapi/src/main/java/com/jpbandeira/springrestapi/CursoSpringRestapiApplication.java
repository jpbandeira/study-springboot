package com.jpbandeira.springrestapi;

import com.jpbandeira.springrestapi.domain.Cidade;
import com.jpbandeira.springrestapi.domain.Estado;
import com.jpbandeira.springrestapi.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursoSpringRestapiApplication implements CommandLineRunner {

	@Autowired
	private CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoSpringRestapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws  Exception{

		Estado estado = new Estado(null, "CE");
		Cidade cidade = new Cidade(null, "Fortaleza", estado);

		cidadeRepository.saveAll(Arrays.asList(cidade));

		}
	}