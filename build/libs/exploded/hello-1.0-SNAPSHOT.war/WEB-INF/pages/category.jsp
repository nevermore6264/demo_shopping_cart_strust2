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
          
          <!-- *** SESSION MESSAGES *** -->
          <div class="col-md-12">
            <s:if test="%{#session.success}">
              <div class="alert alert-success alert-dismissible">
                <button type="button" class="close" data-dismiss="alert"
                  aria-hidden="true">×</button>
                <i class="icon fa fa-exclamation-circle"></i>
                <s:property value="%{#session.success}" />
              </div>
               <s:set var="success" value="" scope="session" />
            </s:if>

            <s:if test="%{#session.error}">
              <div class="alert alert-danger alert-dismissible">
                <button type="button" class="close" data-dismiss="alert"
                  aria-hidden="true">×</button>
                <i class="icon fa fa-exclamation-circle"></i>
                <s:property value="%{#session.error}" />
              </div>
              <s:set var="error" value="" scope="session" />
            </s:if>
          </div>

          <div class="col-md-3">
            <!-- *** MENUS *** -->
            <div class="panel panel-default sidebar-menu">

              <div class="panel-heading">
                <h3 class="panel-title">Categories</h3>
              </div>

              <div class="panel-body">
                <ul class="nav nav-pills nav-stacked category-menu">
                  <s:iterator value="categories">
                    <s:url action="category" var="categoryUrl">
                      <s:param name="id"><s:property value="id" /></s:param>
                    </s:url>
                    <li><s:a href="%{categoryUrl}"><s:property value="name" /></s:a></li>
                  </s:iterator>
                </ul>
              </div>
            </div>
            <!-- *** MENUS END *** -->
          </div>

          <div class="col-md-9">
            <ul class="breadcrumb">
              <li><a href="<s:url action="index" />">Home</a></li>
              <li><a href="<s:url action="index" />">Category</a></li>
              <li><s:property value="category.name" /></li>
            </ul>

            <div class="row products">
              <s:iterator value="category.products">
                <s:url action="product" var="productUrl">
                  <s:param name="id"><s:property value="id" /></s:param>
                </s:url>
                <s:url action="addCart" var="addCartUrl">
                  <s:param name="id"><s:property value="id" /></s:param>
                </s:url>
                
                <div class="col-md-4 col-sm-6">
                  <div class="product">
                    <s:a href="%{productUrl}">  
                      <img src="upload/<s:property value="image" />" alt="Product" class="img-responsive" />
                    </s:a>
                    <div class="text">
                      <h3>
                        <s:a href="%{productUrl}"> <s:property value="name" /></s:a>
                      </h3>
                      <p class="price">
                        <s:if test="%{#discount == 0}">
                          <s:property value="getText('currency.vi', {regular})" />
	                    </s:if>
                        <s:else>
                          <del><s:property value="getText('currency.vi', {price})" /></del> 
                          <s:property value="getText('currency.vi', {regular})" />
                        </s:else>
                      </p>
                      <p class="buttons">
                        <s:a href="%{productUrl}" class="btn btn-default"> 
                          <i class="fa fa-eye"></i>View detail
                        </s:a> 
                        <s:a href="%{addCartUrl}" class="btn btn-primary"> 
                          <i class="fa fa-shopping-cart"></i>Add to cart
                        </s:a>
                      </p>
                    </div>
                    <!-- /.text -->
                  </div>
                  <!-- /.product -->
                </div>
              </s:iterator>
            </div>
            <!-- /.products -->
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