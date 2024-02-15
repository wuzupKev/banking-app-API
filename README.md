# basic-banking-app
This <em> API</em> allows you to create, view, make deposits and withdraw, simulating what a banking system would do. For its construction, the data transfer object and mapper layers were used. <br>
DTO acts as a data store from where the data is received and transferred to different layers and The mapper generates the boilerplate to execute queries and convert the results into application-level objects.

## End points
### create a user
/api/account/create

### get account by id
/api/account/id

### get all accounts
/api/account/

### make a deposit
/api/account/id/deposit

### make a withdraw
/api/account/id/withdraw


<em> To make a withdrawal, the amount to be withdrawn must not exceed the maximum amount stored. </em>
