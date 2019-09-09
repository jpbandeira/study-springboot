package com.jpbandeira.springrestapi;

import com.jpbandeira.springrestapi.domain.*;
import com.jpbandeira.springrestapi.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursoSpringRestapiApplication implements CommandLineRunner {

	private CidadeRepository cidadeRepository;
	private CategoriaRepository categoriaRepository;
	private ProdutoRepository produtoRepository;
	private PedidoRepository pedidoRepository;
	private PagamentoRepository pagamentoRepository;

	@Autowired
	public CursoSpringRestapiApplication(CidadeRepository cidadeRepository,
										 CategoriaRepository categoriaRepository,
										 ProdutoRepository produtoRepository,
										 PedidoRepository pedidoRepository,
										 PagamentoRepository pagamentoRepository){

		this.cidadeRepository = cidadeRepository;
		this.categoriaRepository = categoriaRepository;
		this.produtoRepository = produtoRepository;
		this.pedidoRepository = pedidoRepository;
		this.pagamentoRepository = pagamentoRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CursoSpringRestapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws  Exception{

		Estado estado = new Estado(null, "CE");
		Cidade cidade = new Cidade(null, "Fortaleza", estado);

		Categoria categoria1 = new Categoria(null, "Cat1");
		Categoria categoria2 = new Categoria(null, "Cat2");
		Categoria categoria3 = new Categoria(null, "Cat3");
		Categoria categoria4 = new Categoria(null, "Cat4");
		Categoria categoria5 = new Categoria(null, "Cat5");
		Categoria categoria6 = new Categoria(null, "Cat6");
		Categoria categoria7 = new Categoria(null, "Cat7");

		Produto produto1 = new Produto(null, "Prod1", 50.00, categoria4);
		Produto produto2 = new Produto(null, "Prod2", 50.00, categoria1);
		Produto produto3 = new Produto(null, "Prod3", 50.00, categoria1);
		Produto produto4 = new Produto(null, "Prod4", 50.00, categoria2);
		Produto produto5 = new Produto(null, "Prod5", 50.00, categoria3);
		Produto produto6 = new Produto(null, "Prod6", 50.00, categoria3);
		Produto produto7 = new Produto(null, "Prod7", 50.00, categoria4);
		Produto produto8 = new Produto(null, "Prod8", 50.00, categoria5);
		Produto produto9 = new Produto(null, "Prod9", 50.00, categoria6);
		Produto produto10 = new Produto(null, "Prod10", 50.00, categoria6);
		Produto produto11 = new Produto(null, "Prod11", 50.00, categoria7);

		categoriaRepository.saveAll(Arrays.asList(categoria1,categoria2,categoria3, categoria4, categoria5, categoria6, categoria7));
		produtoRepository.saveAll(Arrays.asList(produto1,produto2, produto3, produto4, produto5, produto6, produto7, produto8, produto9, produto10, produto11));
		cidadeRepository.saveAll(Arrays.asList(cidade));

		}
	}