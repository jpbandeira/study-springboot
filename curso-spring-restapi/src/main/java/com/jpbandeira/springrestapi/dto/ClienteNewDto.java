package com.jpbandeira.springrestapi.dto;

import com.jpbandeira.springrestapi.services.validator.ClienteInsert;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@ClienteInsert
public class ClienteNewDto implements Serializable {

    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    @NotEmpty(message = "Preenchimento obrigatório")
    private String nomeCliente;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotEmpty(message = "Preenchimento obrigatorio")
    private String cpfOuCnpj;
    private Integer tipoCliente;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String logadouro;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String numero;
    private String complemento;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String bairro;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String cep;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String telefone1;
    private String telefone2;
    private String telefone3;

    private Long cidadeId;

    public ClienteNewDto() {
    }
}
