Contact App:
* The type of fields it can store:
a. Name
b. Address
c. Pic
d. Company name
e. Number //Unique
f. Alternative number //Unique

* A contact list with emergency numbers already saved on it.
a. Citizens Call Centre -155300.
b. Child Helpline -1098.
c. Women Helpline-1091.
d. Crime Stopper-1090.
e. Rescue and Relief-1070.
f. Ambulance-102,108.
g. Police Helpline-100.
h. Railway Helpline-23004000.

* Users can be able to save any contact but company names should be in the format:
Valueshipr1, Valueshipr2, Valueshipr3, etc,..

* The user can add any number of alternative phone numbers in his/her phone but the phone
numbers entered among all data should be unique always.
The user can view his/her contact list (/api/getAllContacts).

APi: 
1)http://localhost:8080/api/getAllContacts
2)http://localhost:8080/api/saveContact
response body(JSON)
{
        "name": "xyz",
        "address": "xyz",
        "pic": null,
        "companyName": "xyz",
        "number": "99999999",
        "alternativeNumbers": "8988776655"
    }
