<html>
<body>
<h1 id="mes">${errorMessage}</h1>
<div class="container2">
    <h2>Savings</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <td>${todo.custno}</td>
            <td>${todo.custname}</td>
            <td>${todo.cdep}</td>
            <td>${todo.nyears}</td>
            <td>${todo.savtype}</td>

            <td>
                <a type="button" class="btn btn-primary" href="update-todo?id=${todo.custno}">Edit</a>
            </td>
            <td>
                <a type="button" class="btn btn-primary" href="delete-todo?id=${todo.custno}">Delete</a>
            </td>
            <td>
                <a type="button" class="btn btn-primary" onmouseout="myFunction()" href="see-todo?id=${todo.custno}">Projected Investment</a>
            </td>
        </tr>
        </thead>
    </table>
    <script>
        function myFunction() {
            document.getElementById("mes").innerHTML = "";
        }
    </script>
</div>
</body>
</html>
