<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="container">
    <div class="row">
        <c:forEach var="customer" items="${customers}">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <div class="thumbnail">
                    <div class="caption">
                        <h3>${customer.name}</h3>
                        <p>${customer.address}</p>
                        <p>This customer made ${customer.noOfOrdersMade} orders in our store</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>
