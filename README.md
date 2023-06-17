<!-- ABOUT THE PROJECT -->
## A Data Scraping core app of common platforms using Java and Spring

This project is a data scraping core app that displays user parameters from publicly accessible platforms.

Technologies Used:
* Java 17
* Spring boot
* Maven
* Postman


### APIs Consumed with Links
**GitHub**: https://api.github.com/users

**JSONPlaceholder**: https://jsonplaceholder.typicode.com/users


### API Documentation

Link:
[API Doc Link](https://documenter.getpostman.com/view/23183866/2s93si1A3m)

### Installation

Below is an example of how you can install and set up the app.

**NB**: Ensure you have **Java 17** installed.

1. Clone the repo
   ```sh
   git clone https://github.com/danielkpobari/dani-dinosys-scrapper.git
   ```
2. Build the project
   ```sh
   ./mvnw clean install

3. Start the app
   ```sh
   ./mvnw spring-boot:run
   ```
4. **Base urls** to perform calls are within the **application.yml** file as environment variables. 


5. A **GitHub personal access token** is needed to make request to **GitHub API**. 
One has also been provided as environment variable.
##  Pre-populated Data


**Sample request and response structure**

**Typicode**
```sh
  GET http://localhost:9090/api/v1/user?platform=typicode
```

Typicode data
```json
[
   {
      "name": "Leanne Graham",
      "avatar_url": null,
      "username": "Bret",
      "email": "Sincere@april.biz",
      "company": "Romaguera-Crona",
      "blog": "hildegard.org",
      "location": "Gwenborough"
   },
   {
      "name": "Ervin Howell",
      "avatar_url": null,
      "username": "Antonette",
      "email": "Shanna@melissa.tv",
      "company": "Deckow-Crist",
      "blog": "anastasia.net",
      "location": "Wisokyburgh"
   },
   {
      "name": "Clementine Bauch",
      "avatar_url": null,
      "username": "Samantha",
      "email": "Nathan@yesenia.net",
      "company": "Romaguera-Jacobson",
      "blog": "ramiro.info",
      "location": "McKenziehaven"
   },
   {
      "name": "Patricia Lebsack",
      "avatar_url": null,
      "username": "Karianne",
      "email": "Julianne.OConner@kory.org",
      "company": "Robel-Corkery",
      "blog": "kale.biz",
      "location": "South Elvis"
   }
]


```

**Github**
```sh
  GET http://localhost:9090/api/v1/user?platform=github
```

GitHub data
```json
[
    {
        "name": "Tom Preston-Werner",
        "avatar_url": "https://avatars.githubusercontent.com/u/1?v=4",
        "username": null,
        "email": "tom@mojombo.com",
        "company": "@chatterbugapp, @redwoodjs, @preston-werner-ventures ",
        "blog": "http://tom.preston-werner.com",
        "location": "San Francisco"
    },
    {
        "name": "Chris Wanstrath",
        "avatar_url": "https://avatars.githubusercontent.com/u/2?v=4",
        "username": null,
        "email": null,
        "company": null,
        "blog": "http://chriswanstrath.com/",
        "location": null
    },
    {
        "name": "PJ Hyett",
        "avatar_url": "https://avatars.githubusercontent.com/u/3?v=4",
        "username": null,
        "email": "pj@hyett.com",
        "company": "GitHub, Inc.",
        "blog": "https://hyett.com",
        "location": "San Francisco"
    },
    {
        "name": "Yehuda Katz",
        "avatar_url": "https://avatars.githubusercontent.com/u/4?v=4",
        "username": null,
        "email": "wycats@gmail.com",
        "company": "@tildeio ",
        "blog": "http://yehudakatz.com",
        "location": "Portland, OR"
    }
]
```
<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.
