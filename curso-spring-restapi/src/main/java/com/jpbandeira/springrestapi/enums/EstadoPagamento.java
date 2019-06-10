package com.jpbandeira.springrestapi.enums;

public enum EstadoPagamento {
    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private Integer codigo;
    private String descrição;

    private EstadoPagamento(int codigo, String descrição) {
        this.codigo = codigo;
        this.descrição = descrição;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescrição() {
        return descrição;
    }

    public static  EstadoPagamento toEnum(Integer codigo){
        if(codigo == null){
            return null;
        }

        for(EstadoPagamento estadoPagamento : EstadoPagamento.values()){
            if (codigo.equals(estadoPagamento.getCodigo())){
                return  estadoPagamento;
            }
        }

        throw new IllegalArgumentException("Id invalido: " + codigo);
    }
}
