package com.jpbandeira.springrestapi;

import com.jpbandeira.springrestapi.domain.Categoria;
import com.jpbandeira.springrestapi.domain.Cidade;
import com.jpbandeira.springrestapi.domain.Estado;
import com.jpbandeira.springrestapi.domain.Produto;
import com.jpbandeira.springrestapi.repositories.CidadeRepository;
import com.jpbandeira.springrestapi.repositories.CategoriaRepository;
import com.jpbandeira.springrestapi.repositories.EstadoRepository;
import com.jpbandeira.springrestapi.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursoSpringRestapiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CursoSpringRestapiApplication.class, args);
	}

	private CategoriaRepository categoriaRepository;
	private ProdutoRepository produtoRepository;
	private CidadeRepository cidadeRepository;
	private EstadoRepository estadoRepository;

	@Autowired
	public CursoSpringRestapiApplication(CategoriaRepository categoriaRepository,ProdutoRepository produtoRepository, CidadeRepository cidadeRepository, EstadoRepository estadoRepository){
		this.categoriaRepository = categoriaRepository;
		this.produtoRepository = produtoRepository;
		this.cidadeRepository = cidadeRepository;
		this.estadoRepository = estadoRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria categoria1 = new Categoria(null,"Informatica");
		Categoria categoria2 = new Categoria(null,"Escritorio");

		Produto produto1 = new Produto(null,"Computador",2000.00);
		Produto produto2 = new Produto(null,"Impressora",800.00);
		Produto produto3 = new Produto(null,"Mouse",80.00);

		Estado estado1 = new Estado(null, "MG");
		Estado estado2 = new Estado(null, "SP");

		Cidade cidade1 = new Cidade(null, "Uberlandia", estado1);
		Cidade cidade2 = new Cidade(null, "São Paulo", estado2);
		Cidade cidade3 = new Cidade(null, "Campinas", estado2);

		categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
		categoria2.getProdutos().addAll(Arrays.asList(produto2));

		produto1.getCategorias().addAll(Arrays.asList(categoria1));
		produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
		produto3.getCategorias().addAll(Arrays.asList(categoria1));

		estado1.getCidades().addAll(Arrays.asList(cidade1));
		estado2.getCidades().addAll(Arrays.asList(cidade2,cidade3));

		categoriaRepository.saveAll(Arrays.asList(categoria1,categoria2));
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));
		estadoRepository.saveAll(Arrays.asList(estado1, estado2));
	}
}
