package br.edu.utfpr.caixa_eletronico.service;

import br.edu.utfpr.caixa_eletronico.model.dao.WithdrawalDAO;
import br.edu.utfpr.caixa_eletronico.model.domain.Withdrawal;

public class WithdrawalService extends AbstractService<Integer, Withdrawal>{

    public WithdrawalService() {
        dao = new WithdrawalDAO();
    }
}
