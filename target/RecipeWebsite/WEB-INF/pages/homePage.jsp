 <!-- 
 Hermes Mimini and Bryce Schmisseur
 CST-341-TF300
 CLC Final Project
 Page fragment for displaying the user the home page
  -->
  
  	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css"></link>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>

<script>

function getBlogs()
{	
	$.ajax(
		{
			type: "GET",
			url: "/v1/blogs",
			dataType: "json",
						
			success: function(data)
			{
				table = $('#usersPostTable').dataTable({
					"data": data,
					"columns": [{"data": "blogTitle"}, {"data": "blogBody"}]
				});		
			},
			
			error: function (xhr, ajaxOptions, thrownError) 
			{
				alert(xhr.status);
				alert(thrownError);
			}
		})
}

$(document).ready(getBlogs);
</script>

<h2>HomePage</h2><br/>

<div style="width:60%">
<table style="width: 100%" id="usersPostTable">
	<thead>
		<tr style="Background-color:#A0A0A0">
			<th><label>Blog Title</label></th>
			<th><label>Blog Body</label></th>
		</tr>
	</thead>
	
	<tbody>
	
	</tbody>
</table>
</div>
