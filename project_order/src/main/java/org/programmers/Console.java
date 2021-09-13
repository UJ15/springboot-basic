package org.programmers;

import org.programmers.customer.Customer;
import org.programmers.voucher.Voucher;

import java.io.*;
import java.util.List;

public class Console implements Input, Output {

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    @Override
    public String input() throws IOException {
        return br.readLine();
    }

    @Override
    public void printPrompt() throws IOException {
        bw.write("=== Voucher Program ===\n");
        bw.write("Type exit to exit the program.\n");
        bw.write("Type create to create a new voucher.\n");
        bw.write("Type list to list all vouchers.\n");
        bw.write("Type blacklist to list all customers on blacklist.\n");
        bw.write("Type wallet to use the wallet function.\n");
        bw.flush();
    }

    @Override
    public void printSign() throws IOException {
        bw.write("> ");
        bw.flush();
    }

    @Override
    public void printVoucherTypes() throws IOException {
        bw.write("Type fixed to create fixed amount voucher.\n");
        bw.write(("Type percent to create percent discount voucher.\n"));
        bw.flush();
    }

    @Override
    public void printVoucherList(List<Voucher> voucherList) throws IOException {
        for (int i = 0; i < voucherList.size(); i++)
            bw.write("[" + i + "] " + voucherList.get(i) + "\n");
        bw.flush();
    }

    @Override
    public void printCustomerList(List<Customer> customerList) throws IOException {
        for (int i = 0; i < customerList.size(); i++)
            bw.write("[" + i + "] " + customerList.get(i) + "\n");
        bw.flush();
    }

    @Override
    public void printBlackList(List<Customer> blackList) throws IOException {
        if (blackList.isEmpty()) bw.write("Empty voucher list.\n");
        else blackList.forEach(blackCustomer -> {
            try {
                bw.write(blackCustomer.toString() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bw.flush();
    }

    @Override
    public void askAmount() throws IOException {
        bw.write("How much do you want to discount?\n");
        bw.flush();
    }

    @Override
    public void askPercentage() throws IOException {
        bw.write("What percentage do you want to discount?\n");
        bw.flush();
    }

    @Override
    public void askCustomerNumber() throws IOException {
        bw.write("Select the customer's number to view the voucher.\n");
        bw.flush();
    }

    @Override
    public void askVoucherNumber() throws IOException {
        bw.write("Select the voucher's number to be assigned.\n");
        bw.flush();
    }

}
