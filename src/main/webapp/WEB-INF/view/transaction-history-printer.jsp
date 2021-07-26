<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<t:template title="Impressão Extrato">
    <jsp:body>
        <main>
            <p>${message}</p>
            <c:if test="${not empty history}">
                <ul>
                    <c:forEach var="operation" items="${history}">
                        <li>
                            <p>${operation}</p>
                        </li>
                    </c:forEach>
                </ul>
            </c:if>
        </main>
    </jsp:body>
</t:template>
