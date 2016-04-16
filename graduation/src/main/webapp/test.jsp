<html>
    <!-- jQuery -->
    <script src="../bower_components/jquery/dist/jquery.min.js"></script>

    <!-- JSON -->
    <script src="../bower_components/json/json2.js"></script>
<body>
<h2>Hello World!</h2>
<img src=""/>
<input type="text" name="code" id="code"></input>
<button id="a">a</button>
<script type="text/javascript">

$("#a").click(function(){
var aa = {};
aa.flag = $("input[id='code']").val();
$.ajax({
	url:"/file/download",
	type:"post",
	contentType:"application/json",
	date:JSON.stringify(aa),
	success:function(data){
		alert("fuck");
		// $.each(data, function(){
			// var name = this.name
		// })
		$("img:first").attr('src','QRimages/' + data.code);
	}
})
})

</script>
</body>
</html>
