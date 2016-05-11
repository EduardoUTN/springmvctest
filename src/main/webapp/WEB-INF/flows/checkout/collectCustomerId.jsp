<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html"; charset="utf-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Collect Customer Id</title>
  </head>
  <body>
    <section>
      <div class="jumbotron">
        <div class="container">
          <h1>Collect Customer Id</h1>
          <p>Please Insert you Customer Id</p>
        </div>
      </div>
    </section>
    <section class="container">
      <form:form modelAttribute="order.customer" class="form-horizontal">
        <fieldset>
          <legend>Customer Id</legend>
          <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="customerId">Customer Id</label>
            <div class="col-lg-10">
              <form:input id="customerId" path="customerId" type="text" class="form-input-large"/>
            </div>
          </div>
          <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}">
          <div class="form-group">
            <div class="col-lg-offset-2 col-lg-10">
              <input type="submit" id="btnAdd" class="btn btn-primary" name="_eventId_customerIdCollected" value="Add"/>
              <button id="btnCancel" class="btn btn-default" name="_eventId_cancel">Cancel</button>
            </div>
          </div>
        </fieldset>
      </form:form>
    </section>
  </body>
</html>
