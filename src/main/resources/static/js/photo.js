$(function(){


    var w = 320, h = 240;                                       //摄像头配置,创建canvas
    var pos = 0, ctx = null, saveCB, image = [];
    var canvas = document.createElement("canvas");
    $("body").append(canvas);
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
        onSave: function(data){              //保存图像
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
                console.log(canvas.toDataURL(""));
//                Imagedata =canvas.toDataURL().substring(22);  //上传给后台的图片数据
                var Imagedata =canvas.toDataURL('image/png');  //上传给后台的图片数据


                var req = {
                    image:Imagedata
                }
                $.ajax({
                    type : "POST",
                    url : '/face/checkFace',
                    contentType:'application/json; charset=utf-8',
                    data : JSON.stringify(req),
                    timeout : 60000,
                    success : function(data){

                        console.log(data);

                    }
                });


            }
        },
        onCapture: function () {               //捕获图像
            webcam.save();
        },
        debug: function (type, string) {       //控制台信息
            console.log(type + ": " + string);
        },
        onLoad: function() {                   //flash 加载完毕执行
            console.log('加载完毕！')
            var cams = webcam.getCameraList();
            for(var i in cams) {
                $("body").append("<p>" + cams[i] + "</p>");
            }
        }
    });

    $(".play").click(function(){
        webcam.capture(2);        //拍照，参数5是倒计时
    });

});