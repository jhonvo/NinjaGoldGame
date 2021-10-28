<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Ninja Gold</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	</head>
	<body class="bg-warning">
	<div class="container bg-white p-5">
		<div class="row-s display-6">
			<span class="col-auto p-2">Your Gold:</span><span class="border border-secondary rounded col-auto px-2"><c:out value="${gold}"/></span>
		</div>
        <div class="row-md d-flex flex-row flex-wrap justify-content-evenly ">
            <div class="col border border-secondary p-3 text-center mx-4 mt-4" >
                <p class="display-6 ">Farm</p>
                <p>(earns 10-20 gold)</p>
                <form action="/process" method="POST">
                <input type="hidden" name="space"  value="farm">
                <button type="submit" class="btn  btn-warning">Find Gold!</button>
                </form>
            </div>
            <div class="col border border-secondary p-3 text-center mx-4 mt-4" >
                <p class="display-6 ">Cave</p>
                <p>(earns 5-10 gold)</p>
                <form action="/process" method="POST">
                <input type="hidden" name="space"   value="cave">
                <button type="submit" class="btn btn-warning">Find Gold!</button>
                </form>
            </div>
            <div class="col border border-secondary p-3 text-center mx-4 mt-4" >
                <p class="display-6 ">House</p>
                <p>(earns 2-5 gold)</p>
                <form action="/process" method="POST">
                <input type="hidden" name="space"   value="house">
                <button type="submit" class="btn btn-warning">Find Gold!</button>
                </form>
            </div>
            <div class="col border border-secondary p-3 text-center mx-4 mt-4" >
                <p class="display-6 ">Casino!</p>
                <p>(earns/takes 0-50 gold)</p>
                <form action="/process" method="POST">
                <input type="hidden" name="space"  value="casino">
                <button type="submit" class="btn btn-warning">Find Gold!</button>
                </form>
            </div>
        </div>
        <div class="row-md">
            <p class="display-6 mt-4 ">Actions:</p>
            <div style="height: 200px;" class="border border-secondary p-3 overflow-auto">
				<c:forEach var="action" items="${actions}">
					<p><c:out value="${action}"/></p>
				</c:forEach>
            </div>
        </div>
        <div class="row-md mt-4">
            <a class=" text-decoration-none text-secondary " href="/clear">Restart!</a>
        </div>

	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	</body>
</html>