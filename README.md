# FakerAPI Implementation

## Introduction
This repository contains a basic implementation of a FakerAPI for bank, designed to get transactions and accounts information. The project integrates Auth0 for authentication and authorization, ensuring secure access to the API endpoints.

## Table of Contents
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Endpoints](#endpoints)
- [Models](#models)
- [Security](#security)
- [Improvements](#improvements)
- [Example](#example)

## Prerequisites
Before you begin, ensure you have the following installed:
- Java 17
- Maven 3.8.1
- Spring Boot 3.2.5
- Auth0 account for authentication and authorization

## Installation
1. **Clone the repository and navigate to the project directory:**

   ```bash
   git clone https://github.com/numoh/BankAPI-Assignment.git

   cd BankAPI-Assignment
    ```
2. **Configure Auth0:**
    Update the `application.properties` file with your Auth0 credentials: (for testing purposes, you can use the provided token down below) 
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

## Improvements

* Error Handling: Custom exception handling for better error messages.
* Testing: Implement unit and integration tests.
* Swagger: Add Swagger documentation for API endpoints.

## Example

Test the API using the terminal or Postman.

Token for testing (valid for 24 hours, until 2024-05-23):

```eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IlhYRThBUEp3RHJrUy1KeXBhZEJSQSJ9.eyJpc3MiOiJodHRwczovL2Rldi0zN3ZzNXlocmpxNHd1ZzA0LnVzLmF1dGgwLmNvbS8iLCJzdWIiOiJlM3ZQQkxTZDNEbWEzYWpZeWZ6cWU2R0lYVWRxeHZOSEBjbGllbnRzIiwiYXVkIjoiaHR0cHM6Ly9mYWtlYmFua2FwaSIsImlhdCI6MTcxNjMzMjc2MCwiZXhwIjoxNzE2NDE5MTYwLCJzY29wZSI6InJlYWQ6YWNjb3VudHMgcmVhZDphY2NvdW50LXRyYW5zYWN0aW9ucyIsImd0eSI6ImNsaWVudC1jcmVkZW50aWFscyIsImF6cCI6ImUzdlBCTFNkM0RtYTNhall5ZnpxZTZHSVhVZHF4dk5IIn0.fRYf91IW-w9slkQOoGYd2lyqOY5lLSh8MebeJz1GIqw3aq9LX-HO3tPGWdIx75r30ALdlCCreAJoaSdCqWq_krnWs2gCbprUxWXEYj4hCMFGraz8dweBitPORbX6j6hf0YXgEHXbrXAP5qaic_hDSNabRsLKhzBL7K7gwWeARuB7YecvmIa2vxFWpRBT1pww3_wGl_3LQu-X-6KosbL_YPPVz1BuHpbY1Q_cwo3Bo7bpvjFTYZH3ZGU-EcgP7XGsVNgdP4IsV1lD91lD_FNK7AGascoDWSmeKFaRCbBruiY7bBmrg9LlemMrXJGC1l6HfFpBg2lVm1fTFUmN3p_5Wg```

Example request:

This request will return a 403 Forbidden error, as the token does not have the required scope.

```
curl -X GET "http://localhost:8080/transactions/getAllTransactions" -H "Authorization: Bearer TOKEN"
```

![alt text](image-4.png)

This request will return a list of all accounts, as the token has the required scope.

```
curl -X GET "http://localhost:8080/accounts/getAllAccounts" -H "Authorization: Bearer TOKEN"
```

![alt text](image-5.png)

