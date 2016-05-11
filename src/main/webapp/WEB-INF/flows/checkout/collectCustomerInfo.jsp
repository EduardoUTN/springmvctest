<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html"; charset="utf-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Customer</title>
  </head>
  <body>
    <section>
      <div class="jumbotron">
        <div class="container">
          <h1>Customer</h1>
          <p>Customer details</p>
        </div>
      </div>
    </section>
    <section class="container">
      <form:form modelAttribute="order.customer" class="form-horizontal">
        <fieldset>
          <legend>Customer Details</legend>
          <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="customerId">Customer Id</label>
            <div class="col-lg-10">
              <form:input id="customerId" class="form:input-large" type="text" path="customerId"/>
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="name">Customer Name</label>
            <div class="col-lg-10">
              <form:input id="name" class="form:input-large" type="text" path="name"/>
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="phoneNumber">Customer Phone Number</label>
            <div class="col-lg-10">
              <form:input id="phoneNumber" class="form:input-large" type="text" path="phoneNumber"/>
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="streetName">Address Street Name</label>
            <div class="col-lg-10">
              <form:input id="streetName" class="form:input-large" type="text" path="billingAddress.streetName"/>
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="doorNo">Address Door Number</label>
            <div class="col-lg-10">
              <form:input id="doorNo" class="form:input-large" type="text" path="billingAddress.doorNo"/>
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="areaName">Address Area Name</label>
            <div class="col-lg-10">
              <form:input id="areaName" class="form:input-large" type="text" path="billingAddress.areaName"/>
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="zipCode">Address Zip Code</label>
            <div class="col-lg-10">
              <form:input id="zipCode" class="form:input-large" type="text" path="billingAddress.zipCode"/>
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="state">Address State</label>
            <div class="col-lg-10">
              <form:input id="state" class="form:input-large" type="text" path="billingAddress.state"/>
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="country">Address Country</label>
            <div class="col-lg-10">
              <form:input id="country" class="form:input-large" type="text" path="billingAddress.country"/>
            </div>
          </div>
          <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
          <div class="form-group">
            <div class="col-lg-offset-2 col-lg-10">
              <input type="submit" id="btnAdd" class="btn btn-primary" name="_eventId_customerInfoCollected" value="Add"/>
              <button id="btnCancel" class="btn btn-default" name="_eventId_cancel">Cancel</button>
            </div>
          </div>
        </fieldset>
      </form:form>
    </section>
  </body>
</html>
