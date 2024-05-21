package com.atlar.fakebankapi.service;

import com.atlar.fakebankapi.model.Account;
import com.atlar.fakebankapi.model.Balance;
import com.atlar.fakebankapi.util.XMLUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    private List<Account> accounts = new ArrayList<>();

    @Autowired
    private XMLUtil xmlUtil;

    public String parseAccount() {
        try {
            Document document = xmlUtil.loadXMLDocument();
            document.getDocumentElement().normalize();

            NodeList accountList = document.getElementsByTagName("Acct");

            for (int i = 0; i < accountList.getLength(); i++) {
                Node accountNode = accountList.item(i);

                Element accountElement = (Element) accountNode;

                // Account number
                NodeList othr = accountElement.getElementsByTagName("Othr");
                Element othrElement = (Element) othr.item(0);
                String accountNumber = othrElement.getElementsByTagName("Id").item(0).getTextContent();

                // Currency
                String currency = accountElement.getElementsByTagName("Ccy").item(0).getTextContent();

                // Owner name
                String ownerName = accountElement.getElementsByTagName("Nm").item(0).getTextContent();

                // Balance
                NodeList balanceList = document.getElementsByTagName("Bal");

                List<Balance> balances = new ArrayList<>();

                for (int j = 0; j < balanceList.getLength(); j++) {
                    Element balanceElement = (Element) balanceList.item(j);
                    String type = balanceElement.getElementsByTagName("Cd").item(0).getTextContent();
                    String balanceAmount = "";
                    NodeList cdLine = balanceElement.getElementsByTagName("CdtLine");
                    String creditLineAmount = "";
                    if (cdLine.getLength() > 0) {
                        Element cdLineElement = (Element) cdLine.item(0);
                        creditLineAmount = cdLineElement.getElementsByTagName("Amt").item(0).getTextContent();
                        balanceAmount = balanceElement.getElementsByTagName("Amt").item(1).getTextContent();
                    } else {
                        balanceAmount = balanceElement.getElementsByTagName("Amt").item(0).getTextContent();
                    }
                    String creditDebitIndicator = balanceElement.getElementsByTagName("CdtDbtInd").item(0).getTextContent();
                    String date = balanceElement.getElementsByTagName("Dt").item(0).getTextContent();

                    balances.add(new Balance(balanceAmount, creditLineAmount, type, creditDebitIndicator, date.trim()));
                }

                Account account = new Account(accountNumber, currency, ownerName, balances);

                accounts.add(account);
            }
            return "Parsed Account successfully!";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error parsing the file!";
        }
    }

    public List<Account> getAccounts() {
        return this.accounts;
    }
}
