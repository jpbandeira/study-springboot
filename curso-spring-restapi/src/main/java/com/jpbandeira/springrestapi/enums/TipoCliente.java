package com.jpbandeira.springrestapi.enums;

public enum TipoCliente {
    PESSOAFISICA(1,"Pessoa Física"),
    PESSOAJURIDICA(2, "Pessoa Jurídica");

    private Integer codigo;
    private String descrição;

    private TipoCliente(Integer codigo, String descrição) {
        this.codigo = codigo;
        this.descrição = descrição;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescrição() {
        return descrição;
    }

    public static  TipoCliente toEnum(Integer codigo){
        if(codigo == null){
            return null;
        }

        for(TipoCliente tipoCliente : TipoCliente.values()){
            if (codigo.equals(tipoCliente.getCodigo())){
                return  tipoCliente;
            }
        }

        throw new IllegalArgumentException("Id invalido: " + codigo);
    }
}
