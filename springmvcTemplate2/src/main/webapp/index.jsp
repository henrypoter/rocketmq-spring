<html>
<body>
    <a href="v1/users">Get Users</a>
    <br />
    <br />
    <form action="v1/putRequest/1" method="post">
        <input type="hidden" name="_method" value="PUT" /> <input
            type="submit" value="testRest PUT" />
    </form>
    <br />
    <br />
    <form action="v1/deleteRequest/1" method="post">
        <input type="hidden" name="_method" value="DELETE" /> <input
            type="submit" value="testRest DELETE" />
    </form>
    <br />
    <br />
    <form action="v1/postRequest" method="POST">
        <input type="submit" text="Post Request">
    </form>
    <br>
    <br>
    <a href="v1/getRequest/1">Hello World!</a>
    <br>
    <br>
    <a href="v3/getRequest/1">Hello World! V3</a>
    <br>
    <br>
    <a href="v5/getRequest/1">Hello World! V5</a>
    <br>
    <br>
    <a href="v7/getRequest/1">Hello World! V7</a>
</body>
</html>
