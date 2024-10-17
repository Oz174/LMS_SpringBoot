# Library Management System API Documentation
# 🚀 Welcome to LMS API documentation by Postman

This template guides you through CRUD operations (GET, POST, PUT, DELETE), variables, and tests done on Library Management System

# How to Run the App 

**Before running the app , please edit your MySQL database username and password in the application.properties files as I am using mine**

Using IntelliJ , Right After Dependencey Installation for MAVEN 
1. Go to the file "src/main/java/com/project/Library/LibraryApplication.java" and click run , Build should take few seconds
2. You can now use postman for testing the API Urls below

# How to Run Tests (Unit testing)
1. Right click on Folder named "java" in "src/test/java"
2. Click "Run All Tests" , 14 tests should appear as passed


## 🔖 **API Documentation**

## End-point: Get All Books
### Method: GET
>```
>http://localhost:8070/api/books
>```
### Response: 200
```json
[
    {
        "book_id": 1,
        "title": "It Starts with Us",
        "author_name": "Collen Hoovers",
        "borrowed": false
    },
    {
        "book_id": 2,
        "title": "It Ends with Us",
        "author_name": "Collen Hoovers",
        "borrowed": false
    },
    {
        "book_id": 52,
        "title": "Placebo",
        "author_name": "Unknown Author",
        "borrowed": false
    }
]
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Get All Patrons
This is a GET request and it is used to "get" data from an endpoint. There is no request body for a GET request, but you can use query parameters to help specify the resource you want data on (e.g., in this request, we have `id=1`).

A successful GET response will have a `200 OK` status, and should include some kind of response body - for example, HTML web content or JSON data.
### Method: GET
>```
>http://localhost:8070/api/patrons
>```
### Response: 200
```json
[
    {
        "patron_id": 1,
        "name": "Ahmed Tarek",
        "phone_no": "01281512200",
        "membership_no": 1
    },
    {
        "patron_id": 2,
        "name": "Abdelkhalek Ashraf",
        "phone_no": "01281512201",
        "membership_no": 2
    },
    {
        "patron_id": 102,
        "name": "Abdo Ashraf",
        "phone_no": "01281512202",
        "membership_no": 3
    }
]
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Get Single Book
This is a GET request and it is used to "get" data from an endpoint. There is no request body for a GET request, but you can use query parameters to help specify the resource you want data on (e.g., in this request, we have `id=1`).

A successful GET response will have a `200 OK` status, and should include some kind of response body - for example, HTML web content or JSON data.
### Method: GET
>```
>http://localhost:8070/api/books/2
>```
### Response: 200
```json
{
    "book_id": 3,
    "title": "Verity",
    "author_name": "Collen Hoovers",
    "borrowed": false
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Get Single Patron
This is a GET request and it is used to "get" data from an endpoint. There is no request body for a GET request, but you can use query parameters to help specify the resource you want data on (e.g., in this request, we have `id=1`).

A successful GET response will have a `200 OK` status, and should include some kind of response body - for example, HTML web content or JSON data.
### Method: GET
>```
>http://localhost:8070/api/patrons/2
>```
### Response: 200
```json
{
    "name": "Ahmed Tarek",
    "phone_no": "01281532200",
    "membership_no": 110,
    "patron_id": 2
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Post book
This is a POST request, submitting data to an API via the request body. This request submits JSON data, and the data is reflected in the response.

A successful POST request typically returns a `200 OK` or `201 Created` response code.
### Method: POST
>```
>http://localhost:8070/api/books
>```
### Body (**raw**)

```json
{
	"title": "Verity",
    "author_name" : "Collen Hoovers"
}
```

### Response: 200
```json
Book Added Successfully
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Post patron
This is a POST request, submitting data to an API via the request body. This request submits JSON data, and the data is reflected in the response.

A successful POST request typically returns a `200 OK` or `201 Created` response code.
### Method: POST
>```
>http://localhost:8070/api/patrons
>```
### Body (**raw**)

```json
{
	"name": "Abdo Ashraf",
    "phone_no" : "01281512202",
    "membership_no" : 3
}
```

### Response: 201
```json
{
    "patron_id": 102,
    "name": "Abdo Ashraf",
    "phone_no": "01281512202",
    "membership_no": 3
}
```

### Response: 400
```json
{
    "message": "Patron with Membership No. 3 already exists !!"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Update book data
This is a PUT request and it is used to overwrite an existing piece of data. For instance, after you create an entity with a POST request, you may want to modify that later. You can do that using a PUT request. You typically identify the entity being updated by including an identifier in the URL (eg. `id=1`).

A successful PUT request typically returns a `200 OK`, `201 Created`, or `204 No Content` response code.
### Method: PUT
>```
>http://localhost:8070/api/books/1
>```
### Body (**raw**)

```json
{
	"title": "It Starts with Us",
    "author_name" : "Collen Hoovers",
    "borrowed"  : "true"
}
```

### Response: 404
```json
{
    "message": "Book ID Doesn't Exist !!"
}
```

### Response: 200
```json
{
    "book_id": 1,
    "title": "It Starts with Us",
    "author_name": "Collen Hoovers",
    "borrowed": false
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Update patron data
This is a PUT request and it is used to overwrite an existing piece of data. For instance, after you create an entity with a POST request, you may want to modify that later. You can do that using a PUT request. You typically identify the entity being updated by including an identifier in the URL (eg. `id=1`).

A successful PUT request typically returns a `200 OK`, `201 Created`, or `204 No Content` response code.
### Method: PUT
>```
>http://localhost:8070/api/patrons/1
>```
### Body (**raw**)

```json
{
	"name": "Ola Tarek",
    "phone_no" : "01223233035",
    "membership_no" : 112
}
```

### Response: 200
```json
Update Successful!
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Delete book
This is a DELETE request, and it is used to delete data that was previously created via a POST request. You typically identify the entity being updated by including an identifier in the URL (eg. `id=1`).

A successful DELETE request typically returns a `200 OK`, `202 Accepted`, or `204 No Content` response code.
### Method: DELETE
>```
>http://localhost:8070/api/books/3
>```
### Body (**raw**)

```json

```

### Response: 404
```json
{
    "message": "Book ID Doesn't Exist !!"
}
```

### Response: 200
```json
{
    "message": "Book deleted successfully"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Delete Patron
This is a DELETE request, and it is used to delete data that was previously created via a POST request. You typically identify the entity being updated by including an identifier in the URL (eg. `id=1`).

A successful DELETE request typically returns a `200 OK`, `202 Accepted`, or `204 No Content` response code.
### Method: DELETE
>```
>http://localhost:8070/api/patrons/52
>```
### Body (**raw**)

```json

```

### Response: 200
```json
Deleted Successfully
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: BorrowBook
Borrowing by non-existing patron
### Method: POST
>```
>http://localhost:8070/api/borrow/1/patron/2
>```
### Response: 400
```json
{
    "message": "Patron not found"
}
```

### Response: 200
```json
{
    "message": "Book Borrow Successfully"
}
```

### Response: 400
```json
{
    "message": "Book is already borrowed"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: returnbook
Already Borrowed Book
### Method: PUT
>```
>http://localhost:8070/api/return/1/patron/102
>```
### Response: 400
```json
{
    "message": "Book is not borrowed by this patron"
}
```

### Response: 200
```json
{
    "message": "Book returned Successfully"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
