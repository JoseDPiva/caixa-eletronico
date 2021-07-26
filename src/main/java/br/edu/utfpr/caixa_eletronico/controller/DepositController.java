package br.edu.utfpr.caixa_eletronico.controller;

import br.edu.utfpr.caixa_eletronico.model.domain.Account;
import br.edu.utfpr.caixa_eletronico.model.domain.Deposit;
import br.edu.utfpr.caixa_eletronico.service.AccountService;
import br.edu.utfpr.caixa_eletronico.service.DepositService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DepositoServlet", value = "/deposito")
public class DepositController extends HttpServlet {

    DepositService depositService = new DepositService();
    AccountService accountService = new AccountService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountDeposit = request.getParameter("accountNumber");
        String valueDeposit = request.getParameter("depositValue");
        String password = request.getParameter("password");
        String type = "deposit";

        if (accountDeposit == null || valueDeposit == null || password == null) {
            request.getRequestDispatcher("/WEB-INF/view/deposit.jsp").forward(request, response);
        } else {
            valueDeposit = valueDeposit.replaceAll(",", ".");
            Integer accountDepositInt = Integer.parseInt(accountDeposit);
            Double valueDepositInt = Double.parseDouble(valueDeposit);

            Account account = accountService.getById(accountDepositInt);

            double newBalance = account.getBalance() + valueDepositInt;

            if((valueDepositInt>=0) && (account.getPassword().equals(password))) {
                account.setBalance(newBalance);

                Deposit deposit = new Deposit(accountDepositInt, valueDepositInt, type);

                depositService.save(deposit);
                accountService.update(account);

                request.getRequestDispatcher("/contador-operacoes").forward(request, response);
            } else {
                response.sendRedirect("hello-servlet");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountDeposit = request.getParameter("accountNumber");
        String valueDeposit = request.getParameter("depositValue");
        String password = request.getParameter("password");
        String type = "deposit";

        valueDeposit = valueDeposit.replaceAll(",", ".");
        Integer accountDepositInt = Integer.parseInt(accountDeposit);
        Double valueDepositInt = Double.parseDouble(valueDeposit);

        Account account = accountService.getById(accountDepositInt);

        double newBalance = account.getBalance() + valueDepositInt;

        if((valueDepositInt>=0) && (account.getPassword().equals(password))) {
            account.setBalance(newBalance);

            Deposit deposit = new Deposit(accountDepositInt, valueDepositInt, type);

            depositService.save(deposit);
            accountService.update(account);

            request.getRequestDispatcher("/contador-operacoes").forward(request, response);
        } else {
            response.sendRedirect("hello-servlet");
        }
    }
}
