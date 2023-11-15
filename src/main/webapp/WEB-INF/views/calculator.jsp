<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>電卓</title>
<link rel="stylesheet" href="css/style.css">

</head>
<body>

<h1>電卓アプリ</h1>
 <% String symbolMemo = (String)request.getAttribute("symbolMemo"); %>
  <% String num1str = (String)request.getAttribute("num1str"); %>
 <% String result = (String)request.getAttribute("result"); %>　<!-- オブジェクト型なのでString型にする必要がある -->
       
<% String message = (String)request.getAttribute("message"); %>　<!-- オブジェクト型なのでString型にする必要がある -->
  <p><%= message %></p>


<div class="fv">
	<div class="main">
		<form action="calculator" method="post">
		<input type="hidden" name="result" value='<%= result %>'>
		<input type="hidden" name="num1str" value='<%= num1str %>'>
		<input type="hidden" name="symbolMemo" value='<%= symbolMemo %>'>
		
			<div class="calculator">
			  <div class="result">
				<p><%= result %></p>
			  </div>
				
				<div class="container">
		
					<div class="wrapper">
						<button type="submit" name="number" value="1" > 1 </button>
						<button type="submit" name="number" value="2" > 2 </button>
						<button type="submit" name="number" value="3" > 3 </button>
						<button type="submit" name="symbol" value="+" > + </button>
					</div>
					
					
					<div class="wrapper">
						<button type="submit" name="number" value="4" > 4 </button>
						<button type="submit" name="number" value="5" > 5 </button>
						<button type="submit" name="number" value="6" > 6 </button>
						<button type="submit" name="symbol" value="-" > - </button>
					</div>
					
					<div class="wrapper">
						<button type="submit" name="number" value="7" > 7 </button>
						<button type="submit" name="number" value="8" > 8 </button>
						<button type="submit" name="number" value="9" > 9 </button>
						<button type="submit" name="symbol" value="×" > × </button>
					</div>
					
					<div class="wrapper">
						<button type="submit" name="number" value="0" > 0 </button>
						<button type="submit" name="symbol" value="c" > c </button>
						<button type="submit" name="execution" value="=" > ＝ </button>
						<button type="submit" name="symbol" value="÷" > ÷ </button>
					</div>
				
				</div>
			</div> <!-- calculator -->
		
		</form>
	</div>
</div>

</body>
</html>