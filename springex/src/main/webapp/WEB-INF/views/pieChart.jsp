<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	<script type="text/javascript">
	
		$(document).ready(()=>{
			$.ajax({
				type:'GET',
				url:'/web/pieChartData',
				success:(json)=>{
					google.charts.load('current', {'packages':['corechart']});
					google.charts.setOnLoadCallback(()=>{
					
						var data = new google.visualization.DataTable();
						data.addColumn('string', 'Topping');
						data.addColumn('number', 'Slices');
						var rowList = new Array();
						$(json).each(function(){
							var row = [];
							row[0] = this.topping;
							row[1] = this.slices;
							rowList.push(row);
						});
						
						data.addRows(rowList);
						var options = {'title':'How Much Pizza I Ate Last Night',
										'width':400,
										'height':300};
						
						var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
						chart.draw(data, options);
					})
				}
			});
		});

    </script>
</head>
<body>
	 <div id="chart_div"></div>
</body>
</html>