<html>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
<body>
<h2>Hello World!</h2>
<img src=""/>
<input type="text" name="code" id="code"></input>
<button id="a">a</button>
<script type="text/javascript">
var aa = {
	"code" : $(#code).val()
}
$("#a").click(function(){
$.ajax({
	url:"/qr/create",
	type:"post",
	contentType:"application/json",
	date:JSON.stringfy(aa),
	success:function(data){
		$.each(data, function(){
			var name = this.name
		})
		$("img:first").attr('src','QRimages/' + data);
	}
})
})

</script>
</body>
</html>
