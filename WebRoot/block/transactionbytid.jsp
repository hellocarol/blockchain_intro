<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<meta charset="UTF-8">
<title>Document</title>
<link rel="stylesheet" href="../css/layui.css">
<link rel="stylesheet" href="../css/bootstrap.css">
<!-- <link rel="stylesheet" href="css/table.css"> -->
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/layui.js"></script>
<style>
.handle {
	min-width: 125px;
}

.document {
	height: 700px
}

.box {
 display:inline-block;
  *display:inline;
  *zoom:1;
	/* width: 1100px;
	height: 3600px; */
	margin-left: 62px;
	margin-top: 18px;
}

.form-control {
	display: inline-block;
}

.box .form-horizontal .form-group {
	margin-right: 0px;
	margin-left: 0px;
}

#imgHash,#imgHash1 {
	width: 500px;
}

#imgHash2 {
	width: 500px;
}

#userTable {
	width: 460px;
}

#userTable td:first-child {
	width: 105px;
	background: #f2f2f2;
}

#userTable1 {
	width: 460px;
}

#userTable1 td:first-child {
	width: 105px;
	background: #f2f2f2;
}


#img {
	width: 425px;
	position: absolute;
	top: 60px;
	right: 5px;
}
</style>
</head>
<body>
	<div class="box">

		<form class="form-horizontal"></form>

		<h3>交易#${transaction.txid}</h3>
		<h4>所属区块#${transaction.hashcode}</h4>
		<br>
		<div class="layui-row layui-col-space10">
  <div class="layui-col-md6">
   
    <h3>输入：</h3>
		<c:if test="${txindex==0}">
		<br>
			<h4>NO INPUT</h4>
		</c:if>
		<c:if test="${txindex>0}">
			<c:forEach var="in" items="${transaction.vin}" varStatus="status">
				<table id="userTable" class="layui-table layui-fluid" lay-size="sm">
					<tr>
						<td>输入序号</td>
						<td>${status.index}</td>
					</tr>
					<tr>
						<td>输入地址</td>
						<td>${in.getTransactionOutput().scriptPubKey().addresses()}</td>
					</tr>
					<tr>
						<td>输入金额</td>
						<td>${in.getTransactionOutput().value()}</td>
					</tr>
				</table>
			</c:forEach>
		</c:if>
		
  </div>
  <div class="layui-col-md6">
   
    <h3>输出：</h3>
			<c:forEach var="out" items="${transaction.vout}" varStatus="status">
			<table id="userTable1" class="layui-table layui-fluid" lay-size="sm">
				<tr>
					<td>输出序号</td>
					<td>${status.index }</td>
				</tr>
				<tr>
					<td>输出地址</td>
					<td>${out.scriptPubKey().addresses()}</td>
				</tr>

				<tr>
					<td>输出金额</td>
					<td>${out.value()}</td>
				</tr>
			</table>
		</c:forEach>
		
    
  </div>
  
</div>
		<br>
		
	</div>

	<script>
		layui.config({
			base : '/base/lay/modules/'
		}).use([ 'element', 'form', 'layer', 'laypage', 'table' ], function() {
			var element = layui.element;
			var table = layui.table;
			var layer = layui.layer;
			var laypage = layui.laypage;

			//表格
			table.render({
				elem : 'userTable,userTable1,userTable2',
			})

		});
	</script>
</body>
</html>

