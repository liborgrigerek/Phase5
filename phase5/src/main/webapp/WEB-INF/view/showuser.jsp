<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>User Information</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>User information</h1>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<p>
				<a href="<spring:url value="/user?id=${user.id}" />" class="btn btn-default">
					<span class="glyphicon-hand-left glyphicon"></span>ID: ${user.id}, NAME: ${user.lastname}, ${user.firstname}
				</a>
			</p>
		</div>
	</section>
    <h3>List of his books:</h3>
    <c:if test="${!empty bookList}">
        <section>
            <table class="table table-hover">
                <tr>
                    <th>Title</th>
                    <th>Description</th>
                    <th>&nbsp;</th>
                </tr>
                <c:forEach items="${bookList}" var="book">
                    <tr>
                        <td>${book.title}</td>
                        <td>${book.description}</td>
                    </tr>
                </c:forEach>
            </table>
        </section>
    </c:if>
    <h3>List of his accounts:</h3>
    <c:if test="${!empty accountList}">
        <section>
            <table class="table table-hover">
                <tr>
                    <th>Name</th>
                    <th>Account Prefix</th>
                    <th>Account Number</th>
                    <th>Bank Code</th>
                    <th>&nbsp;</th>
                </tr>
                <c:forEach items="${accountList}" var="account">
                    <tr>
                        <td>${account.name}</td>
                        <td>${account.accountPrefix}</td>
                        <td>${account.accountNumber}</td>
                        <td>${account.bankCode}</td>
                    </tr>
                </c:forEach>
            </table>
        </section>
    </c:if>
    <section>
        <div class="container">
            <div class="row">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <a href="<spring:url value="/"></spring:url>"
                    class="btn btn-info btn-lg">Back</a>
            </div>
            </div>
        </div>
    </section>
</body>
</html>