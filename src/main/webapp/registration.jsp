<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>

    <link rel="stylesheet" type="text/css" href="style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
          crossorigin="anonymous">
</head>
<body>

    <div class="header"></div>

    <div class="container">
        <div class="row">
            <div class="col"></div>

            <div class="center-bar col">
                <p><strong>Registration</strong></p>

                <form action="/registration" method="post">
                    <input class="mg-top5" type="text" name="name" placeholder="name" minlength="6" maxlength="16" required>           <br/>
                    <input class="mg-top5" type="text" name="login" placeholder="login" minlength="6" maxlength="16" required>         <br/>
                    <input class="mg-top5" type="text" name="password" placeholder="password" minlength="6" maxlength="16" required>   <br/>
                    <button class="btn mg-top5 btn-success">Create</button>
                </form>

                <form class="mg-top5" action="/registration" method="get">
                    <% if (request.getAttribute("user") != null) { %>
                        <h2>${requestScope.user}</h2>
                    <% } %>
                </form>
            </div>

            <div class="col"></div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
            crossorigin="anonymous">
    </script>

</body>
</html>
