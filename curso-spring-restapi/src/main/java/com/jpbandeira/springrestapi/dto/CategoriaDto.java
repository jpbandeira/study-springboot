package com.jpbandeira.springrestapi.dto;

import com.jpbandeira.springrestapi.domain.Categoria;

import java.io.Serializable;

public class CategoriaDto implements Serializable {

    private Long id;
    private String nome;

    public CategoriaDto(){}

    public CategoriaDto(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /*Data Transfer Object (DTO) ou simplesmente Transfer Object é um padrão de projetos bastante usado em Java para o transporte de dados entre diferentes componentes
    de um sistema, diferentes instâncias ou processos de um sistema distribuído ou diferentes sistemas via serialização.

A ideia consiste basicamente em agrupar um conjunto de atributos numa classe simples de forma a otimizar a comunicação.

Numa chamada remota, seria ineficiente passar cada atributo individualmente. Da mesma forma seria ineficiente ou até causaria erros passar uma entidade mais complexa.

Além disso, muitas vezes os dados usados na comunicação não refletem exatamente os atributos do seu modelo.
Então, um DTO seria uma classe que provê exatamente aquilo que é necessário para um determinado processo.

Em alguns casos, usa-se o DTO ou TO para mapear informações obtidas do banco de dados e então usar numa View (MVC).
Isso não é completamente errado, e até pode otimizar a apresentação dos dados, afinal o Controller já recebe as informações prontas para uso.
Entretanto, isso pode também acabar em um modelo muito poluído com informações redundantes.

Quando tenho um domínio bem estruturado, prefiro criar beans que representam esse modelo. Esses beans geralmente são chamados de Entidades.
Aí, em determinados casos (como em certas pesquisas no banco de dados baseadas em views ou que possuem joins ),
crio um tipo de TO ou DTO para facilitar o transporte desses dados.*/

}