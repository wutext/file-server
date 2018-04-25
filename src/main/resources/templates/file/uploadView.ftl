<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <script type="text/javascript" src="/jquery/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="/jquery/jquery-form.js"></script>
    <script type="text/javascript">

        $(function() {
            $("#uploadForm").submit(function() {


                var fileName = $("#file").val();
                var fileType = fileName.lastIndexOf(".");
                var ext = fileName.substring(fileType,fileName.length).toUpperCase();
                var isType = imgType(ext);

                var file = $('#file').get(0).files[0]; //获取上传的文件
                var fileSize = file.size;
                var isSize = imgSize(fileSize);


                if(isType && isSize) {
                    $(this).ajaxSubmit(options);
                    return false;
                }else {
                    return false;
                }
            });

            var options={
                url:"/upload/ajaxUpload",
                type:"post",
                success:function(mes){

                    if(mes != "error") {
                        /*$("#img").append("<img src='/upload/"+mes+"'  />");*/
                        $("#img").append("<a href='/upload/"+mes+"' target='view_window'>查看图片</a>");
                    }
                }
            };
        });

        function imgType(ext) {
            if(ext !== '.PNG' && ext !== '.JPG' && ext !== '.JPEG' && ext !== '.GIF'){
                alert('图片格式不正确');
                return false;
            }else{
                return true;
            }
        }

        function imgSize(fileSize) {

            if(fileSize > 2*1024*1024) {
                alert("图片过大"+fileSize > 2*1024*1024 );
                return false;
            }else {
                return true;
            }
        }
    </script>
</head>
<body>


    <div class="upload">
        <form id="uploadForm" enctype="multipart/form-data" method="post">
            图片<input id="file" type="file" name="file"/>
            <input id="" type="submit" value="上传"/>
        </form>

        <div id="img" style="margin-top:30px">

            <a href="/upload/demo-pic2.jpg" target="view_window">查看图片</a>
        </div>
    </div>

</body>
</html>