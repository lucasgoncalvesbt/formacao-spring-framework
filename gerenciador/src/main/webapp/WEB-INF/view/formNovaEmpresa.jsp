<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<c:url value="/principal" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />

    <form action="${linkServletNovaEmpresa}" method="post">

        Nome: <input type="text" name="nome"  />
        Data Abertura: <input type="text" name="data"  />
        <input type="hidden" name="acao" value="NovaEmpresa"/>	

        <input type="submit" />
    </form>

</body>
</html>