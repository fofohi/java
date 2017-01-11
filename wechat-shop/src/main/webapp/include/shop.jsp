<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2016/9/30
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="common/head.jsp"/>
    <nav class="bar bar-tab">
        <a class="tab-item active" href="#">
            <span class="icon icon-home"></span>
            <span class="tab-label">首页</span>
        </a>
        <a class="tab-item" href="#">
            <span class="icon icon-me"></span>
            <span class="tab-label">我</span>
        </a>
        <!--maybe购物车-->
    </nav>

    <div class="content">
        <!-- 这里是页面内容区 -->

        <!-- 幻灯片 -->
        <div class="swiper-container" style="width: 100%;height: 100%">
            <div class="swiper-wrapper">
                <div class="swiper-slide"><img width="100%" src="http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i1/TB1n3rZHFXXXXX9XFXXXXXXXXXX_!!0-item_pic.jpg_320x320q60.jpg" alt=""></div>
                <div class="swiper-slide"><img width="100%" src="http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i4/TB10rkPGVXXXXXGapXXXXXXXXXX_!!0-item_pic.jpg_320x320q60.jpg" alt=""></div>
                <div class="swiper-slide"><img width="100%" src="http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i1/TB1kQI3HpXXXXbSXFXXXXXXXXXX_!!0-item_pic.jpg_320x320q60.jpg" alt=""></div>
            </div>
            <div class="swiper-pagination"></div>
            <div class="swiper-button-next"></div>
            <div class="swiper-button-prev"></div>
        </div>
        <script>
            $(function() {
                $(".swiper-container").swiper({
                    pagination: '.swiper-pagination',
                    nextButton: '.swiper-button-next',
                    prevButton: '.swiper-button-prev',
                    paginationClickable: true,
                    spaceBetween: 30,
                    centeredSlides: false,
                    autoplay: 2500,
                    autoplayDisableOnInteraction: false
                });
            });
        </script>
        <div>
            <!--商品布局-->
            <div>商品1</div>
            <div>商品1</div>
            <div>商品1</div>
            <div>商品1</div>
            <div>商品1</div>
            <div>商品1</div>
            <div>商品1</div>
            <div>商品1</div>
            <div>商品1</div>
        </div>
    </div>
</div>
</body>
<jsp:include page="common/footer.jsp"/>

