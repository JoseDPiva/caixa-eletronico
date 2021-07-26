package br.edu.utfpr.caixa_eletronico.controller;

import br.edu.utfpr.caixa_eletronico.model.domain.Account;
import br.edu.utfpr.caixa_eletronico.service.AccountService;
import br.edu.utfpr.caixa_eletronico.util.Constants;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ContaServlet", value = "/conta")
public class AccountController extends HttpServlet {

    AccountService accountService = new AccountService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String password = request.getParameter("senha");

        if (name == null || cpf == null || password == null) {
            request.getRequestDispatcher("/WEB-INF/view/registration.jsp").forward(request, response);
        } else {
            double balance = 0;

            Integer counterApplication = (Integer) request.getServletContext().getAttribute(Constants.COUNTER_APPLICATION);
            if(counterApplication == null){
                counterApplication = 0;
            }
            counterApplication++;
            getServletContext().setAttribute(Constants.COUNTER_APPLICATION, counterApplication);

            int accountNumber = counterApplication;

            Account account = new Account(name, cpf, password, accountNumber, balance);

            accountService.save(account);

            response.sendRedirect("hello-servlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String cpf = request.getParameter("cpf");
        String password = request.getParameter("password");
        double balance = 0;

        Integer counterApplication = (Integer) request.getServletContext().getAttribute(Constants.COUNTER_APPLICATION);
        if(counterApplication == null){
            counterApplication = 0;
        }
        counterApplication++;
        getServletContext().setAttribute(Constants.COUNTER_APPLICATION, counterApplication);

        int accountNumber = counterApplication;

        List<Account> accountsApp = (List<Account>) getServletContext().getAttribute("accounts");
        if(accountsApp == null) {
            accountsApp = new ArrayList<>();
            getServletContext().setAttribute("accounts", accountsApp);
        }

        Account account = new Account(name, cpf, password, accountNumber, balance);

        accountService.save(account);

        accountsApp.clear();
        accountsApp.add(account);
        getServletContext().setAttribute("accounts", accountsApp);
        response.sendRedirect("hello-servlet");
    }
}
