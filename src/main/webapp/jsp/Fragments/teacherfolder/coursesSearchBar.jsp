<navbar id="studentNavbar">
    <nav>

                <form action="/showCourse" method="post">
                <input type="submit" id="teacherSubmit" name="teacherSubmitButton" value="Show Details">
                <button onclick=location.href='/showCourse'>Go Back</button>
                <select id="user_type" name="courseName">
                    <c:forEach items="${searchACourse}" var="dataPunkt">
                        <option value="${dataPunkt[1]}">${dataPunkt[1]}</option>
                    </c:forEach>
                </select>
                </form>
    </nav>
</navbar>