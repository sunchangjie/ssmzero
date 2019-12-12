<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h2>------Test Page------</h2>

<a href="/film/findall.do">findall--</a>
<a href="javascript:void(0);" onclick="loadXMLDoc('/film/findall.do')">findall</a>


<p>-------------------UserCacheController--------------------</p>

<a href="javascript:void(0);" onclick="loadXMLDoc('/cache/addUser.do')">addUser</a>


<br>
<a href="javascript:void(0);" onclick="loadXMLDoc('/cache/addUser2.do')">addUser2</a>


<br>
<a href="javascript:void(0);" onclick="loadXMLDoc('/cache/getUser.do')">getUser</a>

<br>
<a href="javascript:void(0);" onclick="loadXMLDoc('/cache/removeUser.do')">removeUser</a>

<br>
<a href="javascript:void(0);" onclick="loadXMLDoc('/cache/addUser.do')">addUser</a>

<%--结果输出--%>
<p>-----------------result---------------------</p>
<%--<div id="myDiv">result...</div>--%>

<textarea rows="20" cols="80" id="myDiv" placeholder="result will show here..."></textarea >

<script>
    function loadXMLDoc(url) {
        var xmlhttp;
        if (window.XMLHttpRequest) {
            //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
            xmlhttp = new XMLHttpRequest();
        } else {
            // IE6, IE5 浏览器执行代码
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                console.log(xmlhttp.responseText)
                document.getElementById("myDiv").innerHTML = xmlhttp.responseText.trim();
            }
        }
        xmlhttp.open("GET", url, true);
        xmlhttp.send();
    }
</script>

</body>
</html>
