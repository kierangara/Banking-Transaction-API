# Banking Transaction API

This repository contains a simple RESTful API for handling banking transactions. The API performs the following three (3) operations:

| URL               | Method   | Input Parameters | Description|
|-------------------|-------------|-------------|-------------------------------------|
| /accounts           | POST | {firstName, lastName, balance} | Create a new user account with an initial balance |
| /transactions      | PUT | {srcAccount, destAccount, amount} | Transfer funds from one account to another |
| /transactions/{id} | GET | N/A | Retrieve the transaction history for a given account |


## Prerequisites
Java JDK 17 must be installed before building and running the project. It is available at the link below:

https://www.oracle.com/java/technologies/downloads/#java17

## Build and Run Instructions

1. Clone the repository:

```bash
git clone [https://github.com/kierangara/Banking-Transaction-API.git]
```

2. Navigate to the project directory:

```bash
cd Banking-Transaction-API
```

3. Build and run the application using the Maven wrapper:

```bash
./mvnw clean spring-boot:run
```

## Sample API Requests
Enter the following commands into a separate terminal while the project is running:

1. Create a new account:

```bash
curl -X POST localhost:8080/accounts -H 'Content-type:application/json' -d '{"firstName": "John", "lastName": "Smith", "balance": "200"}'|json_pp
```
Create at least two accounts to enable transactions.

2. Transfer funds between two accounts:

```bash
curl -X PUT localhost:8080/transactions -H 'Content-type:application/json' -d '{"srcAccount": "1", "destAccount": "2", "amount": "100"}'|json_pp
```

3. View the transaction history for a given account:

```bash
curl localhost:8080/transactions/1|json_pp
```

API Requests can alternatively be performed via the Postman desktop app while the application is running. Postman is available for download at the link below:

https://www.postman.com/

## Assumptions
- Accounts are associated with unique generated Ids
- The amount of a transaction must be greater than 0
- An account cannot complete a transaction to itself
- An account not given an initial balance has an initial balance of 0.
