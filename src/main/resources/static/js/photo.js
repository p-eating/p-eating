$(function(){

    var imgdada = '';

    var w = 320, h = 240;                                       //摄像头配置,创建canvas
    var pos = 0, ctx = null, saveCB, image = [];
    var canvas = document.getElementById("canvas");
    canvas.setAttribute('width', w);
    canvas.setAttribute('height', h);
    ctx = canvas.getContext("2d");
    image = ctx.getImageData(0, 0, w, h);

    $("#webcam").webcam({
        width: w,
        height: h,
        mode: "callback",                       //stream,save，回调模式,流模式和保存模式
        swffile: "../webcam/jscam.swf",
        onTick: function(remain) {
            if (0 == remain) {
                $("#status").text("拍照成功!");
            }
        },
        onSave: function(data){

            //保存图像
            var col = data.split(";");
            var img = image;
            for(var i = 0; i < w; i++) {
                var tmp = parseInt(col[i]);
                img.data[pos + 0] = (tmp >> 16) & 0xff;
                img.data[pos + 1] = (tmp >> 8) & 0xff;
                img.data[pos + 2] = tmp & 0xff;
                img.data[pos + 3] = 0xff;
                pos+= 4;
            }
            if (pos >= 4 * w * h) {

                ctx.putImageData(img,0,0);      //转换图像数据，渲染canvas
                pos = 0;
                Imagedata =canvas.toDataURL().substring(22);  //上传给后台的图片数据
                var Imagedata =canvas.toDataURL('image/png');  //上传给后台的图片数据


                imgdada = Imagedata.replace('data:image/png;base64,','');



//                 var req = {
//                     image:imgdada
//                 }
//                 $.ajax({
//                     type : "POST",
//                     url : '/photo/upload',
//                     // contentType:'application/json; charset=utf-8',
//                     data : req,
//                     timeout : 60000,
//                     success : function(data){
//
//                         console.log(data);
//
//                     }
//                 });

                /*$.ajax({
                 type : "POST",
                 url : '/face/checkFace',
                 contentType:'application/json; charset=utf-8',
                 data : JSON.stringify(req),
                 timeout : 60000,
                 success : function(data){

                 console.log(data);

                 }
                 });*/


            }
        },
        onCapture: function (data) {               //捕获图像
            webcam.save();

            // convertCanvasToImage($('#canvas'));
        },
        debug: function (type, string) {       //控制台信息
            console.log(type + ": " + string);
        },
        onLoad: function(dada) {


            // window.setTimeout(timeout, 1000);
        }
    });

    $(".play").click(function(){
       var datas = getImageData();
        console.log(datas);
    });


    function getImageData() {

        webcam.capture(0);        //拍照，参数5是倒计时
        window.setTimeout(function () {
            console.log('....')
        },500);

        return imgdada;
    }





    // $(".play").click(function(){
    //     webcam.capture(0);        //拍照，参数5是倒计时
    //     window.setTimeout(function () {
    //       console.log('....')
    //     },500);
    //     console.log(imgdada);
    // });

    function convertCanvasToImage() {
        var src = document.getElementById("canvas").toDataURL("image/png");
        $('#img').attr('src',src);
    }

});




function face() {
    var flag = false;
    $('#img').faceDetection({
        complete: function (faces) {

            if (faces.length == 0) { //说明没有检测到人脸
                // alert("无人脸")
                console.log('无人脸')
            } else {

                for (var i in faces) {
                    draw(faces[i].x, faces[i].y, faces[i].width, faces[i].height);
                    // var leftTop = [faces[i].x, faces[i].y];
                    //     drawRectangle(leftTop, faces[i].width, faces[i].height);
                }
                console.log("有人脸")
                flag = true;
            }
        },
        error: function (code, message) {
            alert("complete回调函数出错")
        }
    });

    return flag;
}


//画方框
function draw(x, y, w, h) {
    var img = document.getElementById("image");
    // var rect = document.getElementById("imgContainer");
    var rect = document.createElement('div');
    document.querySelector('.imgContainer').appendChild(rect);
    rect.classList.add('rect');
    rect.style.width = w + 'px';
    rect.style.height = h + 'px';
    rect.style.left = (img.offsetLeft + x) + 'px';
    rect.style.top = (img.offsetTop + y) + 'px';
};

