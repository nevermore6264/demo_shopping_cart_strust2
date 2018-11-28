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
            
            <div class="col-md-8 col-md-offset-2">
            <ul class="breadcrumb">
              <li><a href="<s:url action="index" />">Home</a></li>
              <li>Checkout</li>
            </ul>
          </div>

          <div class="col-md-8 col-md-offset-2">
            <s:if test="%{fieldErrors.size() > 0}">
              <div class="alert alert-danger alert-dismissible">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <s:fielderror />
              </div>
            </s:if>
          </div>

          <div class="col-md-8 col-md-offset-2" id="checkout">

            <div class="box">
              <s:form action="processCheckout" method="POST">
                <h1>Checkout</h1>

                <div class="content">
                  <div class="row">
                    <div class="col-sm-6">
                      <div class="form-group">
                        <label>First name</label> <span class="require">(*)</span>
                        <s:textfield cssClass="form-control" name="firstname" />
                      </div>
                    </div>
                    <div class="col-sm-6">
                      <div class="form-group">
                        <label>Last name</label> <span class="require">(*)</span>
                        <s:textfield cssClass="form-control" name="lastname" />
                      </div>
                    </div>
                  </div>
                  <!-- /.row -->

                  <div class="row">
                    <div class="col-sm-12">
                      <div class="form-group">
                        <label>Address</label> <span class="require">(*)</span>
                        <s:textarea cssClass="form-control" name="address" rows="5"></s:textarea>
                      </div>
                    </div>
                  </div>
                  <!-- /.row -->

                  <div class="row">

                    <div class="col-sm-6">
                      <div class="form-group">
                        <label>Phone</label> <span class="require">(*)</span>
                        <s:textfield cssClass="form-control" name="phone" />
                      </div>
                    </div>
                    <div class="col-sm-6">
                      <div class="form-group">
                        <label>Email</label> <span class="require">(*)</span>
                        <s:textfield cssClass="form-control" name="email" />
                      </div>
                    </div>

                  </div>
                  <!-- /.row -->
                </div>

                <div class="box-footer">
                  <div class="pull-left">
                    <a href="<s:url action="viewCart" />" class="btn btn-default">
                      <i class="fa fa-chevron-left"></i>Back to shopping cart
                    </a>
                  </div>
                  <div class="pull-right">
                    <s:submit cssClass="btn btn-primary" value="Agree to order" />
                  </div>
                </div>
              </s:form>
            </div>
            <!-- /.box -->

          </div>
          <!-- /.col-md-9 -->
            
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