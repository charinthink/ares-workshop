# ares-workshop

### ER Diagrams
![image](https://drive.google.com/uc?export=view&id=1D1eSQpPyqA3qBUwHX7SzzU4u8lMtpyWC)

### Schema 'Company' Format JSON
```json
{
    "id": 1,
    "companyName": "GREEK_TECHNOLOGY",
    "offices": [
        {
            "id": 1,
            "officeName": "DOCKER_CAMPUS",
            "departmentDtos": [
                {
                    "id": 1,
                    "departmentName": "ATHENA"
                },
                {
                    "id": 2,
                    "departmentName": "ZEUS"
                }
            ]
        },
        {
            "id": 2,
            "officeName": "KUBERNETES_CAMPUS",
            "departmentDtos": [
                {
                    "id": 1,
                    "departmentName": "ATHENA"
                },
                {
                    "id": 2,
                    "departmentName": "ZEUS"
                }
            ]
        }
    ]
}
```
### Schema 'Employee' Format JSON

```json
    {
    "titleName": "Mr",
    "firstName": "World Wide Web",
    "surName": "WWW",
    "age": 25,
    "office": {
        "id": 1
    },
    "department": {
        "id": 1
    },
    "addresses": [
        {
            "address": "111",
            "city": "Thai",
            "country": "Thailand",
            "postcode": "11111"
        },
        {
            "address": "111",
            "city": "Thai",
            "country": "Thailand",
            "postcode": "11111"
        }
    ]
}
```
