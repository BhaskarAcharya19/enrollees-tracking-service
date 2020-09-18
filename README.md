# enrollees-tracking-service
 To run this code you first need to pull this repo by doing git clone into your local. You must have java 1.8 or higher version. 
 Use IDE(intellij or eclipse).
 tested on postman. created collection for all working api's
 used H2 database. So once the server is down we will loose all data of enrollee and its dependents.
 credentials for H2 database is , username = sa ,password = password
 handled custom exception through ResponseEntityExceptionHandler  class.

Post Request for enrollee (both req and res in JSON format): 
URL : http://localhost:8081/registration/v1/enrollee


request body : 
{    
    "name":"Ram",
    "activationStatus":true,
    "dateOfBirth":"2020-06-19",
    "phoneNumber":"333-444-9997"
}

response body :
{
    "id": 1,
    "name": "Ram",
    "activationStatus": true,
    "dateOfBirth": "2020-06-19",
    "phoneNumber": "333-444-9997",
    "dependentList": []
}
Get Request for enrollee
http://localhost:8081/registration/v1/enrollee/1

Put Request for enrollee
http://localhost:8081/registration/v1/enrollee/2
Request body
{     
    "name":"David",
    "activationStatus":true,
    "dateOfBirth":"2019-06-19",
    "phoneNumber":"125-444-9997"
}

Post Request for dependent (both req and res in JSON format):
http://localhost:8081/registration/v1/enrollee/1/dependents
[
    {
     "name":"exam1233",  
     "dateOfBirth":"2020-05-10"
    },
     {
     "name":"Final123",  
     "dateOfBirth":"2020-01-25"
    }
]
Put Request for dependent
http://localhost:8081/registration/v1/enrollee/1/dependents/2
{
    "id": 2,
    "name": "exam 2",
    "dateOfBirth": "2020-05-10"
}
Delete Request for dependent
http://localhost:8081/registration/v1/enrollee/1/dependents/2

