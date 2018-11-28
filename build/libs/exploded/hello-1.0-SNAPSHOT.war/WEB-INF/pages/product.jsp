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
            <div class="row box" id="productMain">
              <div class="col-sm-3">
                <div id="mainImage">
                  <img src="upload/<s:property value="product.image" />" alt="Product" class="img-responsive">
                </div>
              </div>
              <div class="col-sm-9">
                <h4 class="text-center"><s:property value="product.name" /></h4>
                <p class="price">
                  <s:if test="%{#product.discount == 0}">
                    <s:property value="getText('currency.vi', {product.regular})" />
           		  </s:if>
                  <s:else>
                    <del><s:property value="getText('currency.vi', {product.price})" /></del> 
                    <s:property value="getText('currency.vi', {product.regular})" />
                  </s:else>
                </p>
                <p class="text-center buttons">
                  <s:url action="addCart" var="addCartUrl">
                    <s:param name="id"><s:property value="product.id" /></s:param>
                  </s:url>
                  <s:a href="%{addCartUrl}" class="btn btn-primary">
                    <i class="fa fa-shopping-cart"></i> Add to cart
                  </s:a>
                </p>
              </div>
            </div>
  
  
            <div class="box" id="details">
              <h4>Category</h4>
              <s:url action="category" var="categoryUrl">
                <s:param name="id"><s:property value="product.category.id" /></s:param>
              </s:url>
              <s:a href="%{categoryUrl}"><s:property value="product.category.name" /></s:a>
              <h4>Product details</h4>
              <p><s:property value="product.description" /></p>
              <hr>
              <div class="social">
                <h4>Show it to your friends</h4>
                <p>
                  <a href="#" class="external facebook"
                    data-animate-hover="pulse"><i
                    class="fa fa-facebook"></i></a> <a href="#"
                    class="external gplus" data-animate-hover="pulse"><i
                    class="fa fa-google-plus"></i></a> <a href="#"
                    class="external twitter" data-animate-hover="pulse"><i
                    class="fa fa-twitter"></i></a> <a href="#" class="email"
                    data-animate-hover="pulse"><i
                    class="fa fa-envelope"></i></a>
                </p>
              </div>
            </div>
            <!-- /product -->
  
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