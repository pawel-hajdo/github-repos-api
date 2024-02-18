# Github-repos-api
This project is an API server built with Spring Boot and using github rest api. </br>

## Endpoints
### `GET`  /api/{userName}
Endpoint used to get information about user's public repositories on github which are not forks.
Also returns information about owner of the repository and information about branches and sha of last commit on this branch.
#### Parameters
```
Path:
  userName - name of github account
```
#### Example Response
```json
[
    {
        "name": "github-repos-api",
        "owner": {
            "login": "pawel-hajdo"
        },
        "branches": [
            {
                "name": "master",
                "commit": {
                    "sha": "6de1a8db2edeb7f3a163120230130e7d91aae0db"
                }
            }
        ]
    }
]
```

## Getting started
To get started with this project, you will need to have the following installed on your local machine:
- JDK 21+
- Maven

To build and run the project, follow these steps:
- Clone the repository: `git clone https://github.com/pawel-hajdo/github-repos-api.git`
- Run the project

-> The application will be available at http://localhost:8080.


