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
            
            <div class="col-md-6 col-md-offset-3">
              <s:if test="%{fieldErrors.size() > 0}">
                <div class="alert alert-danger alert-dismissible">
                  <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                  <s:fielderror />
                </div>
              </s:if>
              
              <div class="box">
                <h3>Create new account</h3>
  
                <s:form action="processRegister" method="POST">
                  <div class="form-group">
                    <label>Name</label> <span class="require">(*)</span> 
                    <s:textfield cssClass="form-control" name="name" />
                  </div>
                  <div class="form-group">
                    <label>Email</label> <span class="require">(*)</span>
                    <s:textfield cssClass="form-control" name="email" />
                  </div>
                  <div class="form-group">
                    <label>Password</label> <span class="require">(*)</span>
                    <s:password cssClass="form-control" name="password" />
                  </div>
                  <div class="form-group">
                    <label for="password">Confirm Password</label> <span class="require">(*)</span> 
                    <s:password cssClass="form-control" name="confirmPassword" />
                  </div>
                  <div class="text-center">
                    <s:submit cssClass="btn btn-primary" value="Register" />
                  </div>
                </s:form>
              </div>
            </div>
            
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