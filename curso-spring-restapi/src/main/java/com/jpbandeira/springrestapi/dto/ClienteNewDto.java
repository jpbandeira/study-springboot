package com.jpbandeira.springrestapi.dto;

import com.jpbandeira.springrestapi.domain.Estado;
import lombok.Data;

import java.io.Serializable;

@Data
public class ClienteNewDto implements Serializable {

    private String nomeCliente;
    private String email;
    private String cpfOuCnpj;
    private Integer tipoCliente;

    private String logadouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;

    private String telefone1;
    private String telefone2;
    private String telefone3;

    private Long cidadeId;

    public ClienteNewDto(){}
}
