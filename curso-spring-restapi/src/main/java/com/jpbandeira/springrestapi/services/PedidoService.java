package com.jpbandeira.springrestapi.services;

import com.jpbandeira.springrestapi.domain.ItemPedido;
import com.jpbandeira.springrestapi.domain.PagamentoComBoleto;
import com.jpbandeira.springrestapi.domain.Pedido;
import com.jpbandeira.springrestapi.enums.EstadoPagamento;
import com.jpbandeira.springrestapi.repositories.ItemPedidoRepository;
import com.jpbandeira.springrestapi.repositories.PagamentoRepository;
import com.jpbandeira.springrestapi.repositories.PedidoRepository;
import com.jpbandeira.springrestapi.repositories.ProdutoRepository;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
public class PedidoService {


	private PedidoRepository pedidoRepository;
	private BoletoService boletoService;
	private PagamentoRepository pagamentoRepository;
	private ProdutoRepository produtoRepository;
	//private ProdutoService produtoService;
	private ItemPedidoRepository itemPedidoRepository;
	private ClienteService clienteService;

	@Autowired
	public PedidoService(PedidoRepository pedidoRepository, BoletoService boletoService, PagamentoRepository pagamentoRepository, ProdutoRepository produtoRepository, ItemPedidoRepository itemPedidoRepository, ClienteService clienteService){
		this.pedidoRepository = pedidoRepository;
		this.boletoService = boletoService;
		this.pagamentoRepository = pagamentoRepository;
		this.produtoRepository = produtoRepository;
		this.itemPedidoRepository = itemPedidoRepository;
		this.clienteService = clienteService;
	}

	public Pedido buscarPedido(Integer id) throws ObjectNotFoundException {
		Optional<Pedido> objetoPedido = pedidoRepository.findById(id);
		return objetoPedido.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}

	@Transactional
	public Pedido insert(Pedido objeto) throws ObjectNotFoundException {
		objeto.setId(null);
		objeto.setInstantePedido(new Date());
		objeto.setCliente(clienteService.buscar(objeto.getCliente().getId()));
		objeto.getPagamento().setEstadoPagamento(EstadoPagamento.PENDENTE);
		objeto.getPagamento().setPedido(objeto);
		if(objeto.getPagamento() instanceof PagamentoComBoleto){
			PagamentoComBoleto pagamentoComBoleto = (PagamentoComBoleto) objeto.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagamentoComBoleto, objeto.getInstantePedido());
		}
		objeto = pedidoRepository.save(objeto);
		pagamentoRepository.save(objeto.getPagamento());
		for(ItemPedido itemPedido : objeto.getItens()){
			itemPedido.setDesconto(0.0);
			itemPedido.setPreco(produtoRepository.findById( itemPedido.getProduto().getId()).get().getPreco() );
			itemPedido.setPedido(objeto);
		}
		itemPedidoRepository.saveAll(objeto.getItens());
		return objeto;
	}
}