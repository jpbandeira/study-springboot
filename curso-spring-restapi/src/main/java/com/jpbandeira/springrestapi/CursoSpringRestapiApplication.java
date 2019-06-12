package com.jpbandeira.springrestapi;

import com.jpbandeira.springrestapi.domain.*;
import com.jpbandeira.springrestapi.enums.EstadoPagamento;
import com.jpbandeira.springrestapi.enums.TipoCliente;
import com.jpbandeira.springrestapi.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class CursoSpringRestapiApplication /*implements CommandLineRunner */{

	public static void main(String[] args) {
		SpringApplication.run(CursoSpringRestapiApplication.class, args);
	}

/*
	private CategoriaRepository categoriaRepository;
	private ProdutoRepository produtoRepository;
	private CidadeRepository cidadeRepository;
	private EstadoRepository estadoRepository;
	private ClienteRepository clienteRepository;
	private EnderecoRepository enderecoRepository;
	private PedidoRepository pedidoRepository;
	private PagamentoRepository pagamentoRepository;
	private ItemPedidoRepository itemPedidoRepository;

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	@Autowired
	public CursoSpringRestapiApplication(CategoriaRepository categoriaRepository,ProdutoRepository produtoRepository, CidadeRepository cidadeRepository, EstadoRepository estadoRepository, ClienteRepository clienteRepository, EnderecoRepository enderecoRepository, PedidoRepository pedidoRepository, PagamentoRepository pagamentoRepository, ItemPedidoRepository itemPedidoRepository){
		this.categoriaRepository = categoriaRepository;
		this.produtoRepository = produtoRepository;
		this.cidadeRepository = cidadeRepository;
		this.estadoRepository = estadoRepository;
		this.clienteRepository = clienteRepository;
		this.enderecoRepository = enderecoRepository;
		this.pedidoRepository = pedidoRepository;
		this.pagamentoRepository = pagamentoRepository;
		this.itemPedidoRepository = itemPedidoRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria categoria1 = new Categoria("Informatica");
		Categoria categoria2 = new Categoria("Escritorio");

		Produto produto1 = new Produto("Computador",2000.00);
		Produto produto2 = new Produto("Impressora",800.00);
		Produto produto3 = new Produto("Mouse",80.00);

		Estado estado1 = new Estado("MG");
		Estado estado2 = new Estado ("SP");

		Cidade cidade1 = new Cidade("Uberlandia", estado1);
		Cidade cidade2 = new Cidade("São Paulo", estado2);
		Cidade cidade3 = new Cidade("Campinas", estado2);

		Cliente cliente1 = new Cliente("João Pedro", "joao@pedro.com", "03054945000160", TipoCliente.PESSOAFISICA);

		cliente1.getTelefones().addAll(Arrays.asList("8599922035", "8599920350"));

		Endereco endereco1 = new Endereco("Rua Suiça", "120", "AP 202 B A9", "Maraponga", "60711035", cliente1, cidade1);
		Endereco endereco2 = new Endereco("Rua Alpha", "121", "AP 203 B A10", "Maraponga", "60711034", cliente1, cidade2);

		Pedido pedido1 = new Pedido(simpleDateFormat.parse("30/09/2017 10:32"), cliente1, endereco1);
		Pedido pedido2 = new Pedido(simpleDateFormat.parse("30/09/2018 11:32"), cliente1, endereco2);

		ItemPedido itemPedido1 = new ItemPedido(pedido1, produto1, 0.00, 1, 2000.00);
		ItemPedido itemPedido2 = new ItemPedido(pedido1, produto3, 0.00,2,80.00);
		ItemPedido itemPedido3 = new ItemPedido(pedido2, produto2, 100.00,1,800.00);

		Pagamento pagamento1 = new PagamentoComCartao(EstadoPagamento.QUITADO, pedido1, 6);
		pedido1.setPagamento(pagamento1);

		Pagamento pagamento2 = new PagamentoComBoleto(EstadoPagamento.PENDENTE, pedido2, simpleDateFormat.parse("20/10/2017 00:00"), null);
		pedido2.setPagamento(pagamento2);

		categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
		categoria2.getProdutos().addAll(Arrays.asList(produto2));

		produto1.getCategorias().addAll(Arrays.asList(categoria1));
		produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
		produto3.getCategorias().addAll(Arrays.asList(categoria1));

		estado1.getCidades().addAll(Arrays.asList(cidade1));
		estado2.getCidades().addAll(Arrays.asList(cidade2,cidade3));

		cliente1.getEnderecos().addAll(Arrays.asList(endereco1, endereco2));
		cliente1.getPedidos().addAll(Arrays.asList(pedido1, pedido2));

		pedido1.getItens().addAll(Arrays.asList(itemPedido1, itemPedido2));
		pedido2.getItens().addAll(Arrays.asList(itemPedido3));

		produto1.getItens().addAll(Arrays.asList(itemPedido1));
		produto2.getItens().addAll(Arrays.asList(itemPedido3));
		produto3.getItens().addAll(Arrays.asList(itemPedido2));

		categoriaRepository.saveAll(Arrays.asList(categoria1,categoria2));
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));
		estadoRepository.saveAll(Arrays.asList(estado1, estado2));
		clienteRepository.saveAll(Arrays.asList(cliente1));
		enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2));
		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2));
		pagamentoRepository.saveAll(Arrays.asList(pagamento1, pagamento2));
		itemPedidoRepository.saveAll(Arrays.asList(itemPedido1, itemPedido2, itemPedido3));
	}
*/
}
