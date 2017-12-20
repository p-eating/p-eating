// $(function() {
//
//     var video = document.getElementById('video'),
//         canvas = document.getElementById('canvas'),
//         snap = document.getElementById('tack'),
//         img = document.getElementById('img'),
//         vendorUrl = window.URL || window.webkitURL;
//
//     //媒体对象
//     navigator.getMedia = navigator.getUserMedia ||
//         navagator.webkitGetUserMedia ||
//         navigator.mozGetUserMedia ||
//         navigator.msGetUserMedia;
//     navigator.getMedia({
//         video: true, //使用摄像头对象
//         audio: false  //不适用音频
//     }, function (strem) {
//         console.log(strem);
//         video.src = vendorUrl.createObjectURL(strem);
//         video.play();
//     }, function (error) {
//         //error.code
//         console.log(error);
//     });
//     snap.addEventListener('click', function () {
//
//         //绘制canvas图形
//         canvas.getContext('2d').drawImage(video, 0, 0, 800, 600);
//
//         //把canvas图像转为img图片
//         img.src = canvas.toDataURL("image/png");
//
//     })
//
//
//     $('#btn').click(function () {
//         $('#canvas').faceDetection({
//             complete: function (faces) {
//
//                 if (faces.length == 0) { //说明没有检测到人脸
//                     // alert("无人脸")
//                     console.log('无人脸')
//                 } else {
//
//                     for (var i in faces) {
//                         draw(faces[i].x, faces[i].y, faces[i].width, faces[i].height);
//                         // var leftTop = [faces[i].x, faces[i].y];
//                         //     drawRectangle(leftTop, faces[i].width, faces[i].height);
//                     }
//                     console.log("有人脸")
//                     flag = true;
//                 }
//             },
//             error: function (code, message) {
//                 alert("complete回调函数出错")
//             }
//         });
//
//     });
//
//
// //画方框
//     function draw(x, y, w, h) {
//         var img = document.getElementById("image");
//         // var rect = document.getElementById("imgContainer");
//         var rect = document.createElement('div');
//         document.querySelector('.imgContainer').appendChild(rect);
//         rect.classList.add('rect');
//         rect.style.width = w + 'px';
//         rect.style.height = h + 'px';
//         rect.style.left = (img.offsetLeft + x) + 'px';
//         rect.style.top = (img.offsetTop + y) + 'px';
//     };
//
// })
//
