<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html"; charset="utf-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Check Out Cancelled</title>
  </head>
  <body>
    <section>
      <div class="jumbotron">
        <div class="container">
          <h1 class="alert alert-danger">Check ut Cancelled</h1>
          <p>Your check out process cancelled! you may continue shopping...</p>
        </div>
      </div>
    </section>
    <section>
      <div class="container">
        <p>
          <a href="<spring:url value="/products/"/>" class="btn btn-primary"></a>
          <span class="glyphicon-hand-left glyphicon"></span>
        </p>
      </div>
    </section>
  </body>
</html>
