<link rel="stylesheet" href="css/style.css">



<nav id="nav">
    <ul>
        <li><a href="/logout" title="logout">Log Out</a></li>
    </ul>
</nav>
<navbar id="studentNavbar">
    <nav>
                <form action="/userpage" method="post">
                <select id="user_type" name="courseId">
                    <c:forEach items="${AllStudentsInCourse}" var="dataPunkt">
                        <option value="${dataPunkt[1]}">${dataPunkt[1]}</option>
                    </c:forEach>
                </select>
                    <input type="submit" id="studentSubmit" name="studentSubmitButton" value="Show Details">
                    <button onclick=location.href='/userpage'>Go Back</button>
                </form>
    </nav>
</navbar>

<h1> Welcome student </h1>