<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>접수완료페이지</title>
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
            margin-top: 10%;
            padding-top: 20%;
            padding-bottom: 20%;
        }
        .menu-div {
            --width: 100%;
            --height: 30px;
            --border: 3px solid #d1e9ca;
            text-align: center;
            --padding: 7px;
            --position: relative;
            --left: 170px;
            --bottom: 10px;

        }
        .oder-button {
            Position : relative;
            left: 30%;
            top: 5px;
        }
        .btn {
            width: 30%;
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
            접수완료
        </div>
        <div class="menu">
            <div class="menu-div">접수가 완료되었습니다.</div>
        </div>
        <div class="oder-button">
            <button type="button" class="btn btn-outline-success">
                <a href="#" style="text-decoration: none">상세내역</a>
            </button>
        </div>
    </div>
</body>
</html>