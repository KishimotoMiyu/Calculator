package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/calculator")

public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("result","0");
		request.setAttribute("message"," ");
		request.setAttribute("num1str"," ");
		
		String views = "WEB-INF/views/calculator.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(views);
	    dis.forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String n = request.getParameter("number");
		String result =   request.getParameter("result");
		String symbol =   request.getParameter("symbol");
		String symbolMemo =   request.getParameter("symbolMemo");
		String execution = request.getParameter("execution");
		String num1str =   request.getParameter("num1str");
		String num2str ="";
		int answer = 0;
		int num1 = 0;
		int num2 = 0;
		
		// cボタンがクリックされた時の処理
		

		//＝がクリックされた場合
	    
	    if(execution != null ) {
	    	
	    	  num1 =Integer.parseInt(num1str); 
	    	  num2 =Integer.parseInt(result); 
	    
			    switch(symbolMemo) {
				   case "+":
				   answer = num1 + num2;
				   break;
				   
				   case "-":
				   answer = num1 - num2;
				   break;
				   
				   case "×":
				   answer = num1 * num2;
				   break;
				   
				   case "÷":
				   answer = num1 / num2;
				   break;
			   }
		    
		    result = String.valueOf(answer); 
		    num1str = result; 
		    request.setAttribute("result",result);
		    request.setAttribute("message","");
		    request.setAttribute("symbolMemo",null);
		    
		    String views = "WEB-INF/views/calculator.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(views);
		    dis.forward(request, response);
		    doGet(request, response);
		 
	    } 
		
		
		// 計算処理
		if(symbol == null) {	
			if( result.equals("0") ||  result.equals("+") ||  result.equals("-") ||  result.equals("×") ||  result.equals("÷")  ) {	
				result = n;
			} else {
				result += n;
			}
			
			request.setAttribute("symbolMemo",symbolMemo);
			request.setAttribute("result",result);
			request.setAttribute("num1str",num1str);
			request.setAttribute("message"," ");
			String views = "WEB-INF/views/calculator.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(views);
		    dis.forward(request, response);
		
		} else if( symbol.equals("+")) {
			
			num1str = result;
			symbolMemo = "+";
			request.setAttribute("result","+");
			request.setAttribute("message"," ");
			request.setAttribute("num1str",num1str);
			request.setAttribute("symbolMemo",symbolMemo);
			String views = "WEB-INF/views/calculator.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(views);
		    dis.forward(request, response);
			
		}else if( symbol.equals("-")) {
			
			num1str = result;
			request.setAttribute("result","-");
			request.setAttribute("message"," ");
			request.setAttribute("num1str",num1str);
			request.setAttribute("symbolMemo","-");
			String views = "WEB-INF/views/calculator.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(views);
		    dis.forward(request, response);
			
		}else if( symbol.equals("×")) {
			
			num1str = result;
			request.setAttribute("result","×");
			request.setAttribute("message"," ");
			request.setAttribute("num1str",num1str);
			request.setAttribute("symbolMemo","×");
			String views = "WEB-INF/views/calculator.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(views);
		    dis.forward(request, response);
			
		}else if( symbol.equals("÷")) {
			
			num1str = result;
			request.setAttribute("result","÷");
			request.setAttribute("message"," ");
			request.setAttribute("num1str",num1str);
			request.setAttribute("symbolMemo","÷");
			String views = "WEB-INF/views/calculator.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(views);
		    dis.forward(request, response);
			
		}  else if( symbol.equals("c")) {
			
			n = null;
			result =   "0";
			symbol =   null;
			num1str =  null;
			num2str =  null;
			answer = 0;
			num1 = 0;
			num2 = 0;
		
			request.setAttribute("result",result);
			request.setAttribute("message"," ");
			request.setAttribute("num1str",num1str);
			request.setAttribute("cancel",null);
			
			String views = "WEB-INF/views/calculator.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(views);
		    dis.forward(request, response);
			
		}
		
		String views = "WEB-INF/views/calculator.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(views);
	    dis.forward(request, response);
	    doGet(request, response);
	    
		}	
	}

	
