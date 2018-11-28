<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>

<s:include value="fragments/head.jsp" />

<body>

  <s:include value="fragments/header.jsp" />

  <div id="all">

    <div id="content">
      <div class="container">
        <div class="row">
          
          <div class="col-md-10 col-md-offset-1">
            <ul class="breadcrumb">
              <li><a href="<s:url action="index" />">Home</a></li>
              <li>Shopping cart</li>
            </ul>
          </div>
          
          <div class="col-md-10 col-md-offset-1">
            <s:if test="%{#session.success != null}">
              <div class="alert alert-success alert-dismissible">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <i class="icon fa fa-check-circle"></i>
                <s:property value="%{#session.success}" />
              </div>
              <s:set var="success" value="" scope="session" />
            </s:if>
          </div>

          <div class="col-md-10 col-md-offset-1" id="basket">

            <div class="box">
              <h3>Shopping cart</h3>
              <p class="text-muted">You currently have <s:property value="%{#session.cart.count}" /> items in your cart.</p>
              <div class="table-responsive">
                <table class="table">
                  <thead>
                    <tr>
                      <th colspan="2">Product</th>
                      <th>Quantity</th>
                      <th>Price</th>
                      <th colspan="3">Sub Total</th>
                    </tr>
                  </thead>
                  <tbody>
                    <s:iterator value="%{#session.cart.items}">
                      <s:url action="product" var="productUrl">
                        <s:param name="id"><s:property value="product.id" /></s:param>
                      </s:url>
                      <s:url action="removeCart" var="removeCartUrl">
                        <s:param name="id"><s:property value="product.id" /></s:param>
                      </s:url>
                      
                      <s:form action="updateCart" method="POST">
                        <s:hidden name="id" value="%{product.id}" />
                        <tr>
                          <td>
                            <s:a href="%{productUrl}">
                              <img src="upload/<s:property value="product.image" />" alt="Product">
                            </s:a>
                          </td>
                          <td>
                            <s:a href="%{productUrl}"><s:property value="product.name" /></s:a>
                          </td>
                          <td>
                            <s:textfield type="number" name="quantity" value="%{quantity}"
                              class="form-control" min="0" max="10" />
                          </td>
                          <td><s:property value="getText('currency.vi', {product.regular})" /></td>
                          <td><s:property value="getText('currency.vi', {subTotal})" /></td>
                          <td align="center"><s:submit cssClass="btn btn-primary btn-update" value="Update" /></td>
                          <td align="center"><s:a href="%{removeCartUrl}" cssClass="btn btn-danger">Remove</s:a></td>
                        </tr>
                      </s:form>
                      
                    </s:iterator>
                  </tbody>
                  <tfoot>
                    <tr>
                      <th colspan="4">Total</th>
                      <th colspan="3"><s:property value="getText('currency.vi', {#session.cart.total})" /></th>
                    </tr>
                  </tfoot>
                </table>

              </div>
              <!-- /.table-responsive -->

              <div class="box-footer">
                <div class="pull-left">
                  <a href="<s:url action="index" />" class="btn btn-default">
                    <i class="fa fa-chevron-left"></i> Continue shopping
                  </a>
                </div>
                <div class="pull-right">
                  <a href="<s:url action="checkout" />" class="btn btn-primary">
                    Proceed to checkout <i class="fa fa-chevron-right"></i>
                  </a>
                </div>
              </div>
            </div>
            <!-- /.box -->

          </div>
          <!-- /.col-md-10 -->
                              
        </div>
        <!-- /.row -->
      </div>
      <!-- /.container -->
    </div>
    <!-- /#content -->

    <s:include value="fragments/footer.jsp" />

  </div>
  <!-- /#all -->

  <s:include value="fragments/scripts.jsp" />

</body>

</html>