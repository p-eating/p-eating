package com.chinaredstar.eating.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by lixiaohao
 * Date:${DATA}
 * Description:
 */
@Controller
@RequestMapping("photo")
public class PhotoController {


    @RequestMapping("index")
    public String index(){
        return "photo";
    }



    @RequestMapping(value = "upload",method = RequestMethod.POST)
    @ResponseBody
    public String photo(HttpServletRequest request, HttpServletResponse response){


        String path="/Users/lixiaohao/Documents/test/test.png";

        File file = new File( path );
//        response.reset();
//        response.addHeader("Content-Disposition", "attachment;filename=" + new String(file.getName().getBytes()));
//        response.addHeader("Content-Length", "" + file.length());

//        String savePath = request.getRealPath("/") + "//img//";
        String savePath = "/Users/lixiaohao/Documents/test/";
        File tmp_path = new File(savePath);
        tmp_path.mkdirs();
        //System.out.println("照片数据保存路径:" + savePath);
        File file_txt = new File(savePath+"001.PNG");


        String image = request.getParameter("image");

        OutputStream  out = null;
        try {
            byte[] bytes = null;
            String imageStr = null;
            //Base64解码并生成图片
            //替换头
            imageStr = image.replace("data:image/png;base64,", "").trim();
                    /*if (null != image) {
                        image = image.substring(image.indexOf(",") + 1);
                    }*/
            // Base64解码
            bytes = new BASE64Decoder().decodeBuffer(imageStr);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// 调整异常数据
                    bytes[i] += 256;
                }
            }
            // if file doesnt exists, then create it,if file exists ,delete it ,then create it
            if (!file_txt.exists()) {
                file_txt.createNewFile();
            }else{
                file_txt.delete();
                file_txt.createNewFile();
            }
            // 生成jpeg图片
            out = new FileOutputStream(file_txt.getAbsoluteFile());
            out.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (null != out) {
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            return "success";

        }
    }




/*

    @RequestMapping(value = "upload",method = RequestMethod.POST)
    @ResponseBody
    public String photo(HttpServletRequest request, HttpServletResponse response){


        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods","POST,GET,OPTIONS,DELETE");
        response.setHeader("Access-Control-Max-Age","3600");
        response.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");

//        if (!(image.getOriginalFilename() == null || "".equals(image
//                .getOriginalFilename()))) {
//                    */
/*
//                     * upload下面调用的方法，主要是用来检测上传的文件是否属于允许上传的类型范围内，及根据传入的路径名
//                     * 自动创建文件夹和文件名，返回的File文件我们可以用来做其它的使用，如得到保存后的文件名路径等这里我就先不做多的介绍。
//                     *//*

//
//        }
        String path="/Users/lixiaohao/Documents/test/test.jpg";

        File file = new File( path );
        response.reset();
        response.addHeader("Content-Disposition", "attachment;filename=" + new String(file.getName().getBytes()));
        response.addHeader("Content-Length", "" + file.length());
        try {
            InputStream in = new FileInputStream( file );
            OutputStream out = response.getOutputStream();

            int len = -1;
            byte[] buffer = new byte[1024];
            while ( (len = in.read(buffer)) >0 ){
                out.write(buffer);
            }
            in.close();
            out.flush();
            out.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return "success";
    }
*/

}
