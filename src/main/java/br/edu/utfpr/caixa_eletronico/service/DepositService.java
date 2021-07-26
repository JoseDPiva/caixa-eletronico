package br.edu.utfpr.caixa_eletronico.service;

import br.edu.utfpr.caixa_eletronico.model.dao.DepositDAO;
import br.edu.utfpr.caixa_eletronico.model.domain.Deposit;

public class DepositService extends AbstractService<Integer, Deposit>{

    public DepositService() {
        dao = new DepositDAO();
    }
}
