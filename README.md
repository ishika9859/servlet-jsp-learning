# Java Servlet Learning – DemoApp

My hands-on practice with Java Servlets using Eclipse and Apache Tomcat 9. Each small demo here covers a core Servlet concept: request parameters, cookies, sessions, redirects, filters, init parameters, and login-protected pages.

## What I Practiced

| Demo | Concept | Entry page |
|------|---------|------------|
| **Square of a sum** | Adds two numbers, passes the result through a **cookie** to another servlet, which prints its square | `index.html` |
| **User details with a filter** | Reads `name` and `age`; a **servlet filter** checks the age before the servlet runs | `index2.html` |
| **Login / secure pages** | **Session**-based login, a protected welcome page, a protected video page, and logout | `login.html` |

`mainPage.html` is the landing page that links to all three demos.

## Tech Used

- Java (Servlet API 4.0 / `javax.servlet`)
- Apache Tomcat v9.0
- Eclipse IDE for Enterprise Java
- Plain HTML forms

## Folder Structure

```
DemoApp/
├── src/main/java/com/ishika/
│   ├── AddServlet.java          # /add     – adds num1 + num2, stores result in a cookie, redirects to /sq
│   ├── SqServlet.java           # /sq      – reads the cookie and prints the square
│   ├── UserDetailServlet.java   # /user    – prints name and age
│   ├── ageFilter.java           # filter on /user – validates age
│   ├── loginServlet.java        # /login   – POST; validates credentials, creates session
│   ├── welcome.java             # /welcome – protected page (needs session)
│   ├── video.java               # /video   – protected page with an embedded YouTube video
│   ├── logoutServlet.java       # /logout  – invalidates session
│   └── MyServlet.java           # /home    – demonstrates ServletConfig init params
└── src/main/webapp/
    ├── mainPage.html            # landing page
    ├── index.html               # addition form
    ├── index2.html              # user details form
    ├── login.html               # login form
    └── WEB-INF/web.xml          # deployment descriptor
```

## URL Mappings

| URL | Method | Servlet / Filter | Purpose |
|-----|--------|------------------|---------|
| `/add?num1=&num2=` | GET | `AddServlet` | Adds two ints, saves the sum in cookie `val`, redirects to `/sq` |
| `/sq` | GET | `SqServlet` | Reads cookie `val` and prints its square |
| `/user?name=&age=` | GET | `UserDetailServlet` (+ `ageFilter`) | Prints a welcome message and the age |
| `/login` | POST | `loginServlet` | Checks `uname` / `pass`, starts a session |
| `/welcome` | GET | `welcome` | Shows the logged-in user, a video link, and a logout button |
| `/video` | GET | `video` | Embeds a YouTube video (login required) |
| `/logout` | GET | `logoutServlet` | Ends the session and redirects to `login.html` |
| `/home` | GET | `MyServlet` | Prints the `name` init parameter |

## Concepts Covered

- `HttpServlet` with `doGet` / `doPost`
- `@WebServlet` and `@WebFilter` annotations
- Reading request parameters
- **Cookies** to share data between servlets
- **Sessions** (`HttpSession`) for login
- `sendRedirect` redirects
- **Filters** for request validation
- `ServletConfig` / `ServletContext` init parameters
- Cache-control headers on protected pages

Other ways of passing data between servlets (request forwarding, URL rewriting, session attributes) are kept as commented-out code in `AddServlet` and `SqServlet` for comparison.

## How to Run

### Prerequisites

- JDK installed and configured in Eclipse
- Eclipse IDE for Enterprise Java and Web Developers
- Apache Tomcat 9.0 added as a server in Eclipse

### Steps

1. In Eclipse, go to **File → Import** and bring in the `DemoApp` folder.
2. Make sure the targeted runtime is **Apache Tomcat v9.0** (Properties → Targeted Runtimes).
3. Right-click `DemoApp` → **Run As → Run on Server** and choose Tomcat v9.0.
4. Open this in a browser (8080 is Tomcat's default port):

   ```
   http://localhost:8080/DemoApp/mainPage.html
   ```

### Try the demos

- **Square:** open `index.html`, enter two numbers, and submit. You are redirected to `/sq`, which shows the square of their sum.
- **User details:** open `index2.html` and enter a name and an age.
- **Login:** open `login.html` and sign in with the credentials set in `loginServlet.java`. You land on `/welcome`, which links to `/video`. Use the **LogOut** button to end the session.

## Author

Ishika
