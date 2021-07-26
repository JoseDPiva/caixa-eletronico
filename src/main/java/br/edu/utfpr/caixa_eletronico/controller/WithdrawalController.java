package br.edu.utfpr.caixa_eletronico.controller;

import br.edu.utfpr.caixa_eletronico.model.domain.Account;
import br.edu.utfpr.caixa_eletronico.model.domain.Withdrawal;
import br.edu.utfpr.caixa_eletronico.service.AccountService;
import br.edu.utfpr.caixa_eletronico.service.WithdrawalService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SaqueServlet", value = "/saque")
public class WithdrawalController extends HttpServlet {

    WithdrawalService withdrawalService = new WithdrawalService();
    AccountService accountService = new AccountService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNumber = request.getParameter("accountNumber");
        String withdrawalValue = request.getParameter("withdrawalValue");
        String password = request.getParameter("password");
        String type = "withdrawal";

        if (accountNumber == null || withdrawalValue == null || password == null) {
            request.getRequestDispatcher("/WEB-INF/view/withdrawal.jsp").forward(request, response);
        } else {
            withdrawalValue = withdrawalValue.replaceAll(",", ".");
            Integer accountWithdrawalInt = Integer.parseInt(accountNumber);
            Double withdrawalValueInt = Double.parseDouble(withdrawalValue);

            Account account = accountService.getById(accountWithdrawalInt);
            double newBalance = account.getBalance() - withdrawalValueInt;

            if((newBalance>=0) && (withdrawalValueInt>=0) && (account.getPassword().equals(password))) {
                account.setBalance(newBalance);

                Withdrawal withdrawal = new Withdrawal(accountWithdrawalInt, withdrawalValueInt, type);

                withdrawalService.save(withdrawal);
                accountService.update(account);

                request.getRequestDispatcher("/contador-operacoes").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountWithdrawal = request.getParameter("accountNumber");
        String withdrawalValue = request.getParameter("withdrawalValue");
        String password = request.getParameter("password");
        String type = "withdrawal";

        withdrawalValue = withdrawalValue.replaceAll(",", ".");
        Integer accountWithdrawalInt = Integer.parseInt(accountWithdrawal);
        Double withdrawalValueInt = Double.parseDouble(withdrawalValue);

        Account account = accountService.getById(accountWithdrawalInt);

        double newBalance = account.getBalance() - withdrawalValueInt;

        if((newBalance>=0) && (withdrawalValueInt>=0) && (account.getPassword().equals(password))) {
            account.setBalance(newBalance);

            Withdrawal withdrawal = new Withdrawal(accountWithdrawalInt, withdrawalValueInt, type);

            withdrawalService.save(withdrawal);
            accountService.update(account);

            request.getRequestDispatcher("/contador-operacoes").forward(request, response);
        } else {
            response.sendRedirect("hello-servlet");
        }
    }
}
