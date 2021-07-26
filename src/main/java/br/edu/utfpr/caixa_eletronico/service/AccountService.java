package br.edu.utfpr.caixa_eletronico.service;

import br.edu.utfpr.caixa_eletronico.model.dao.AccountDAO;
import br.edu.utfpr.caixa_eletronico.model.domain.Account;

public class AccountService extends AbstractService<Integer, Account>{

    public AccountService() {
        dao = new AccountDAO();
    }
}
