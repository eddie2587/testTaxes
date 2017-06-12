<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Receipts</title>
</head>
<body>
	<div align="center">
		<h1>Receipts</h1>
		
		<c:forEach var="receipt" items="${receipts}" varStatus="loop">
			<div style="width:400px;background:#F9EECF;border:1px dotted black;text-align:center">
				Receipt ${loop.index + 1}:
				<div align="left">
					<p>
						<c:forEach var="entry" items="${receipt.getEntries()}">
							<p>${entry.quantity} x <b>${entry.product.name}:</b> ${entry.priceWithTaxes}</p>
						</c:forEach>
					</p>
					<p>Sales taxes: ${receipt.getSalesTaxes()} </p>
					<p>Total: ${receipt.getTotal()} </p>
				</div>
			</div>
			<br/>
		</c:forEach>
		
	</div>
</body>
</html>