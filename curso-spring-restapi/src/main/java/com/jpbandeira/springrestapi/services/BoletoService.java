package com.jpbandeira.springrestapi.services;

import com.jpbandeira.springrestapi.domain.PagamentoComBoleto;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class BoletoService {

    public void preencherPagamentoComBoleto(PagamentoComBoleto pagamentoComBoleto, Date instantePagamento){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(instantePagamento);
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        pagamentoComBoleto.setDataVencimento(calendar.getTime());
    }
}
