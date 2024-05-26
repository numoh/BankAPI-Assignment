package com.atlar.fakebankapi.service;

import com.atlar.fakebankapi.model.Transaction;
import com.atlar.fakebankapi.util.XMLUtil;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionsService {

    private final XMLUtil xmlUtil;

    private List<Transaction> transactions = new ArrayList<>();

    public TransactionsService(XMLUtil xmlUtil) {
        this.xmlUtil = xmlUtil;
    }

    public String parseTransactions() {
        try {
            Document document = xmlUtil.loadXMLDocument();
            document.getDocumentElement().normalize();

            NodeList transactionsList = document.getElementsByTagName("Ntry");

            for (int i = 0; i < transactionsList.getLength(); i++) {
                Node transactionNode = transactionsList.item(i);

                Element transactionElement = (Element) transactionNode;

                // Unique Identifier
                String uniqueIdentifier = transactionElement.getElementsByTagName("NtryRef").item(0).getTextContent();

                // BookingDate
                NodeList bookingDatum = transactionElement.getElementsByTagName("BookgDt");
                Element bookingDatumElement = (Element) bookingDatum.item(0);
                String datum = bookingDatumElement.getElementsByTagName("Dt").item(0).getTextContent();

                NodeList ntryDtls = transactionElement.getElementsByTagName("NtryDtls");

                Element ntryDtlsElement = (Element) ntryDtls.item(0);
                NodeList txDtls = ntryDtlsElement.getElementsByTagName("TxDtls");

                for (int j = 0; j < txDtls.getLength(); j++) {
                    Node txDtlsNode = txDtls.item(j);

                    Element txDtlsElement = (Element) txDtlsNode;

                    // Amount
                    String amount = txDtlsElement.getElementsByTagName("Amt").item(0).getTextContent();

                    // Currency
                    Element amtElement = (Element) txDtlsElement.getElementsByTagName("Amt").item(0);
                    String currency = amtElement.getAttribute("Ccy");

                    // Remittance Information
                    NodeList rmtInfNode = txDtlsElement.getElementsByTagName("RmtInf");
                    Element rmtInfElement = (Element) rmtInfNode.item(0);

                    NodeList refNodes = rmtInfElement.getElementsByTagName("Ref");
                    NodeList ustrdNodes = rmtInfElement.getElementsByTagName("Ustrd");

                    String remittanceInformation = "";
                    if (refNodes.getLength() > 0) {
                        remittanceInformation = refNodes.item(0).getTextContent();
                    } else if (ustrdNodes.getLength() > 0) {
                        remittanceInformation = ustrdNodes.item(0).getTextContent();
                    }

                    // Account name
                    String accountName = "";
                    NodeList dbtrNode = txDtlsElement.getElementsByTagName("Dbtr");
                    if (dbtrNode.getLength() > 0) {
                        Element dbtrElement = (Element) dbtrNode.item(0);
                        accountName = dbtrElement.getElementsByTagName("Nm").item(0).getTextContent();
                    }

                    transactions.add(new Transaction(datum, amount, currency, remittanceInformation.trim(), uniqueIdentifier, accountName.trim()));
                }
            }
            return "Parsed Transactions successfully!";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error parsing the file!";
        }
    }

    public List<Transaction> getTransactions() {
        return this.transactions;
    }

    public List<Transaction> getTransactionsForAnAccount(String accountName) {
        List<Transaction> transactionList = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getAccountName().equalsIgnoreCase(accountName)) {
                transactionList.add(transaction);
            }
        }
        return transactionList;
    }
}
