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

          <div class="col-md-12">

            <div class="row" id="error-page">
              <div class="col-sm-6 col-sm-offset-3">
                <div class="box">
  
                  <p class="text-center">
                    <img src="images/logo.png" alt="Obaju template">
                  </p>
  
                  <h3>We are sorry - this page is not here anymore</h3>
                  <h4 class="text-muted">Error 404 - Page not found</h4>
  
                  <p class="text-center">
                    To continue please use the <strong>Search
                      form</strong> or <strong>Menu</strong> above.
                  </p>
  
                  <p class="buttons">
                    <a href="<s:url action="index" />" class="btn btn-primary">
                      <i class="fa fa-home"></i> Go to Homepage
                    </a>
                  </p>
                </div>
              </div>
            </div>
  
          </div>
          <!-- /.col-md-12 -->
                
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