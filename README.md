# FakerAPI Implementation

## Introduction
This repository contains a basic implementation of a FakerAPI, designed to simulate transactions, balances, and account information. The project integrates Auth0 for authentication and authorization, ensuring secure access to the API endpoints.

## Table of Contents
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Endpoints](#endpoints)
- [Models](#models)
- [Security](#security)
- [API Documentation](#api-documentation)
- [Improvements](#improvements)
- [Examples](#examples)

## Prerequisites
Before you begin, ensure you have the following installed:
- Java 17 or higher
- Maven 3.6 or higher
- Auth0 account for authentication and authorization

## Installation
1. **Clone the repository and navigate to the project directory:**

   ```bash
   git clone https://github.com/your-username/fakerapi.git

   cd fakerapi
    ```
2. **Configure Auth0:**
    Update the `application.properties` file with your Auth0 credentials:
    ```properties
    spring.security.oauth2.resourceserver.jwt.issuer-uri=https://YOUR_AUTH0_DOMAIN/
    
    spring.security.oauth2.resourceserver.jwt.audiences=YOU AUTH0 API IDENTIFIER
    ```

## Endpoints
Access the API endpoints:

- List all transactions: `GET /transactions/getAllTransactions`

- Retrieve specific transaction: `GET /transactions/getTransactionForAnAccount`

- List all accounts: `GET /accounts/getAllAccounts`

## Models
The API includes the following models and their respective attributes:

- Account

        accountNumber
        currency
        ownerName
        balances

- Transaction

        bookingDate
        amount
        currency
        remittanceInformation
        uniqueIdentifier
        accountNumber

- Balance
    
        amount
        creditLineAmount
        type
        creditDebitIndicator
        date

## Security

* Authentication: Managed by Auth0 using JWT tokens.
* Authorization: Enforced using @PreAuthorize annotations with scopes.

## API Documentation

* The API documentation is available at `http://localhost:8080/swagger-ui.html`

## Improvements

* Error Handling: Custom exception handling for better error messages.
* Testing: Implement unit and integration tests.

