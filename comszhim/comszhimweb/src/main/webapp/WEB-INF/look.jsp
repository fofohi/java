<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/css/bootstrap-grid.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/css/bootstrap.css" rel="stylesheet">
</head>

<body>

<input id="bookName" name="bookName" value="" style="width: 100%">
<input id="dirName" name="dirName" value="" width="50px">
<button id="load">loading</button>

<div>
    <img src="" id="imgs">
    <button id="prev">上一页</button>
    <button id="next">下一页</button>
</div>


<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script>

    $("#load").click(function(){
        if($("#dirName").val() == ""){
            alert("dir name");
            return;
        }
        $("#imgs").attr("src","http:" + $("#bookName").val());
        $.get("/download?url="+ "http:" + $("#bookName").val() + "&dir=" + $("#dirName").val());
    })

    $("#next").click(function(){
        var url = $("#imgs").attr("src");

        regex = new RegExp(".*\/(.*).thumb.jpg");
        s = regex.exec(url)[1];



        regex2= new RegExp("(.*)/"+s);
        s2 = regex2.exec(url)[1];

        regex3 = new RegExp("00(.*)|0(.*)");
        s3 = regex3.exec(s);
        if(s3[1] == undefined){
            s4 = parseInt(s3[2]) + 1;
        }else{
            s4 = parseInt(s3[1]) + 1;
        }

        if(s4 >= 10){
            s5 = "0"+s4;
        }else{
            s5 = "00" + s4;
        }

        s6 = s2 + "/" + s5 + ".thumb.jpg";
        $("#imgs").attr("src",s6);
        $.get("/download?url="+s6+ "&dir=" + $("#dirName").val());

    });


    $("#prev").click(function(){
        var url = $("#imgs").attr("src");

        regex = new RegExp(".*\/(.*).thumb.jpg");
        s = regex.exec(url)[1];



        regex2= new RegExp("(.*)/"+s);
        s2 = regex2.exec(url)[1];

        regex3 = new RegExp("00(.*)|0(.*)");
        s3 = regex3.exec(s);
        if(s3[1] == undefined){
            s4 = parseInt(s3[2]) - 1;
            s5 = "0" + s4;
        }else{
            s4 = parseInt(s3[1]) - 1;
            s5 = "00"+s4;
        }
        s6 = s2 + "/" + s5 + ".thumb.jpg";
        console.log(s6);
        $("#imgs").attr("src",s6);
        $.get("/download?url="+s6+"&dir=" + $("#dirName").val());
    });


</script>
</body>
</html>