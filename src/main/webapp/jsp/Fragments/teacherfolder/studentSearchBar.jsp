<navbar id="studentNavbar">
    <nav>
                <form action="/showStudents" method="post">
                <input type="submit" id="teacherSubmit" name="teacherSubmitButton" value="Show Details">
                <button onclick=location.href='/userpage'>Go Back</button>
                <select id="user_type" name="studentName">
                    <c:forEach items="${searchAStudent}" var="dataS">
                        <option value="${dataS[1]}">${dataS[1]}</option>

                    </c:forEach>
                </select>
                </form>
    </nav>
</navbar>