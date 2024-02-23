<navbar id="studentNavbar">
    <nav>
                <form action="/showCourse" method="post">
                <input type="submit" id="teacherSubmit" name="teacherSubmitCourse" value="Show Details">
                <button onclick=location.href='/userpage'>Go Back</button>
                <select id="user_type" name="showCourse">
                    <c:forEach items="${AllStudentsInCourse}" var="dataPunkt">
                        <option value="${dataPunkt[1]}">${dataPunkt[1]}</option>
                    </c:forEach>
                </select>
                </form>
    </nav>
</navbar>