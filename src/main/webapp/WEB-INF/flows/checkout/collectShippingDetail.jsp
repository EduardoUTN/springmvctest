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
          <h1>Shipping</h1>
          <p>Shipping Details</p>
        </div>
      </div>
    </section>
    <section class="container">
      <form:form modelAttribute="order.shippingDetail" class="form-horizontal">
        <fieldset>
          <legend>Shipping Details</legend>
          <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="name">Name</label>
            <div class="col-lg-10">
              <form:input id="name" class="form:input-large" type="text" path="name"/>
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="shippingDate">shipping Date (dd/mm/yyyy)</label>
            <div class="col-lg-10">
              <form:input id="shippingDate" class="form:input-large" type="text" path="shippingDate"/>
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="doorNo">Door No</label>
            <div class="col-lg-10">
              <form:input id="doorNo" class="form:input-large" type="text" path="shippingAddress.doorNo"/>
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="streetName">Street Name</label>
            <div class="col-lg-10">
              <form:input id="streetName" class="form:input-large" type="text" path="shippingAddress.streetName"/>
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="areaName">Area Name</label>
            <div class="col-lg-10">
              <form:input id="areaName" class="form:input-large" type="text" path="shippingAddress.areaName"/>
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="state">State</label>
            <div class="col-lg-10">
              <form:input id="state" class="form:input-large" type="text" path="shippingAddress.state"/>
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="country">Country</label>
            <div class="col-lg-10">
              <form:input id="country" class="form:input-large" type="text" path="shippingAddress.country"/>
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="zipCode">Zip Code</label>
            <div class="col-lg-10">
              <form:input id="zipCode" class="form:input-large" type="text" path="shippingAddress.zipCode"/>
            </div>
          </div>
          <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
          <div class="form-group">
            <div class="col-lg-offset-2 col-lg-10">
              <button id="back" class="btn btn-default" name="_eventId_backToCollectCustomerInfo">back</button>
              <input type="submit" id="btnAdd" class="btn btn-primary" name="_eventId_shippingDetailCollected" value="Add"/>
              <button id="btnCancel" class="btn btn-default" name="_eventId_cancel">Cancel</button>
            </div>
          </div>
        </fieldset>
      </form:form>
    </section>
  </body>
</html>
