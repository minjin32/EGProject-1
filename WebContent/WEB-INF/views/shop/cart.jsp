<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
    <style>
        .menubox {
            padding-left: 20px;
            padding-bottom: 20px;
            color: white;
        }
        .main {
            width: 320px;
            --border: 1px solid red;
            background-color: #789f6f;
        }
        .header {
            font-size: 25px;
        }
        .menu {
            border: 3px solid #d1e9ca;
            width: 80%;
            align-content: center;
            margin: 10px;
        }
        .menu-div {
            width: 70px;
            height: 30px;
            border: 3px solid #d1e9ca;
            text-align: center;
            padding-top: 7px;
            position: relative;
            left: 170px;
            bottom: 10px;

        }
        .oder-button {
            Position : relative;
            left: 200px;
        }
        .btn {
            width: 100px;
            height: 50px;
        }
        .price {
            Position : relative;
            left: 240px;
            bottom: 10px;
        }
    </style>
</head>
<body>
    <div class="menubox main">  
        <div class="header">
            <img src="/WEB-INF/cart.png" style="width: 50px">
            장바구니 목록
        </div>
        <h5>가게 이름</h5>
        <div class="menu">
            <ul style="list-style-type: none">
                <li>메뉴</li>
                <li>용기크기</li>
                <li>옵션 선택</li>
            </ul>
            <div class="menu-div">수량(개)</div>
        </div>
        <div class="menu">
            <ul style="list-style-type: none">
                <li>메뉴</li>
                <li>용기크기</li>
                <li>옵션 선택</li>
            </ul>
            <div class="menu-div">수량(개)</div>
        </div>
        <div class="row">
            <div class="col-md-6">총 주문금액</div>
            <div class="price col-md-6">가격(원)</div>
        </div>
        <div class="oder-button">
            <button type="button" class="btn btn-outline-success">주문하기</button>
        </div>
    </div>
</body>
</html>