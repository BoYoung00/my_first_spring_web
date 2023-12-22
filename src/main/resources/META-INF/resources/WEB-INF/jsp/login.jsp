<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login Page</title>
</head>
<body>
    Welcome to the login page!

    <div class="container">
        <pre>${errorMessage}</pre>
        <form action="" method="post">
            <p>Name : <input type="text" name="name"></p>
            <p>Password : <input type="password" name="pw"></p>
            <input type="submit">
        </form>
    </div>
</body>
</html>