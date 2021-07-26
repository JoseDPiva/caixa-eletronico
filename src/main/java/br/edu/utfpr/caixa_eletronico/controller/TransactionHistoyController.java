package br.edu.utfpr.caixa_eletronico.controller;

import br.edu.utfpr.caixa_eletronico.model.domain.Account;
import br.edu.utfpr.caixa_eletronico.model.domain.Deposit;
import br.edu.utfpr.caixa_eletronico.model.domain.Withdrawal;
import br.edu.utfpr.caixa_eletronico.service.AccountService;
import br.edu.utfpr.caixa_eletronico.service.DepositService;
import br.edu.utfpr.caixa_eletronico.service.WithdrawalService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ExtratoServlet", value = "/extrato")
public class TransactionHistoyController extends HttpServlet {

    WithdrawalService withdrawalService = new WithdrawalService();
    AccountService accountService = new AccountService();
    DepositService depositService = new DepositService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNumber = request.getParameter("accountNumber");
        String password = request.getParameter("password");
        String message = "Operações realizadas:";

        if(accountNumber == null || password == null) {
            request.getRequestDispatcher("/WEB-INF/view/transaction-history.jsp").forward(request, response);
        } else {
            Integer accountNumberInt = Integer.parseInt(accountNumber);
            Account account = accountService.getById(accountNumberInt);

            List<Withdrawal> listWithdrawals = withdrawalService.findAll();
            List<Deposit> listDeposits = depositService.findAll();

            if((account.getPassword().equals(password))) {
                List<String> transactionHistory = (List<String>) getServletContext().getAttribute("history");
                if(transactionHistory == null) {
                    transactionHistory = new ArrayList<>();
                    getServletContext().setAttribute("history", transactionHistory);
                }

                transactionHistory.clear();

                transactionHistory.add("Saldo: R$ " + account.getBalance());

                for(Withdrawal w : listWithdrawals) {
                    if (w.getAccountNumber() == accountNumberInt) {
                        String aux = "";
                        aux = "Operação: Saque - R$: " + String.valueOf(w.getValue());
                        transactionHistory.add(aux);
                    }
                }

                for(Deposit d : listDeposits) {
                    if (d.getAccountNumber() == accountNumberInt) {
                        String aux = "";
                        aux = "Operação: Depósito - R$: " + String.valueOf(d.getValue());
                        transactionHistory.add(aux);
                    }
                }

                getServletContext().setAttribute("history", transactionHistory);
                request.setAttribute("flash.message", message);

                request.getRequestDispatcher("/WEB-INF/view/transaction-history-printer.jsp").forward(request, response);
            } else {
                response.sendRedirect("hello-servlet");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNumber = request.getParameter("accountNumber");
        String password = request.getParameter("password");
        Integer accountNumberInt = Integer.parseInt(accountNumber);
        Account account = accountService.getById(accountNumberInt);
        String message = "Operações realizadas:";

        List<Withdrawal> listWithdrawals = withdrawalService.findAll();
        List<Deposit> listDeposits = depositService.findAll();

        if((account.getPassword().equals(password))) {
            List<String> transactionHistory = (List<String>) getServletContext().getAttribute("history");
            if(transactionHistory == null) {
                transactionHistory = new ArrayList<>();
                getServletContext().setAttribute("history", transactionHistory);
            }

            transactionHistory.clear();

            transactionHistory.add("Saldo: R$ " + account.getBalance());

            for(Withdrawal w : listWithdrawals) {
                if (w.getAccountNumber() == accountNumberInt) {
                    String aux = "";
                    aux = "Operação: Saque - R$: " + String.valueOf(w.getValue());
                    transactionHistory.add(aux);
                }
            }

            for(Deposit d : listDeposits) {
                if (d.getAccountNumber() == accountNumberInt) {
                    String aux = "";
                    aux = "Operação: Depósito - R$: " + String.valueOf(d.getValue());
                    transactionHistory.add(aux);
                }
            }

            getServletContext().setAttribute("history", transactionHistory);
            request.setAttribute("flash.message", message);

            request.getRequestDispatcher("/WEB-INF/view/transaction-history-printer.jsp").forward(request, response);
        } else {
            response.sendRedirect("hello-servlet");
        }
    }
}
