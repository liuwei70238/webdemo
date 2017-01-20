package com.lov.ctrl;

import com.alibaba.fastjson.JSONObject;
import com.lov.util.NetUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

/**
 * Created by liuw on 2017/1/18.
 */
@Controller
public class FormCtrl {

    @RequestMapping("/form-view.do")
    public ModelAndView view() {
        ModelAndView mv = new ModelAndView("model_two");
        return mv;
    }

    //    spring方法上传文件
    @RequestMapping("/form.do")
    public String form(
            String name,
            MultipartFile file,
           // HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        String path = "G:/lw/workspace/" + name + file.getOriginalFilename();
        //上传 multipartFile 方法
        file.transferTo(new File(path));
        JSONObject r = new JSONObject();
        r.put("code", true);
        NetUtil.pringJson(r, response);

        return null;
    }
//得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
//        String savePath = "G:/lw/workspace/";
//        File file = new File(savePath);
//        //判断上传文件的保存目录是否存在
//        if (!file.exists() && !file.isDirectory()) {
//            System.out.println(savePath+"目录不存在，需要创建");
//            //创建目录
//            file.mkdir();
//        }
//        //消息提示
//        String message = "";
//        try{
//
//            //1、创建一个DiskFileItemFactory工厂
//            DiskFileItemFactory factory = new DiskFileItemFactory();
//            //2、创建一个文件上传解析器
//            ServletFileUpload upload = new ServletFileUpload(factory);
//            //解决上传文件名的中文乱码
//            upload.setHeaderEncoding("UTF-8");
//            //3、判断提交上来的数据是否是上传表单的数据
//            if(!ServletFileUpload.isMultipartContent(request)){
//                //按照传统方式获取数据
//                return null;
//            }
//            //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
//            List<FileItem> list = upload.parseRequest(request);
//            for(FileItem item : list){
//                //如果fileitem中封装的是普通输入项的数据
//                if(item.isFormField()){
//                    String name = item.getFieldName();
//                    //解决普通输入项的数据的中文乱码问题
//                    String value = item.getString("UTF-8");
//                    //value = new String(value.getBytes("iso8859-1"),"UTF-8");
//                    System.out.println(name + "=" + value);
//                }else{//如果fileitem中封装的是上传文件
//                    //得到上传的文件名称，
//                    String filename = item.getName();
//                    System.out.println("filename:" + filename);
//                    if(filename==null || filename.trim().equals("")){
//                        continue;
//                    }
//                    //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
//                    //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
//                    filename = filename.substring(filename.lastIndexOf("\\")+1);
//                    //获取item中的上传文件的输入流
//                    InputStream in = item.getInputStream();
//                    //创建一个文件输出流
//                    FileOutputStream out = new FileOutputStream(savePath + "\\" + filename);
//                    //创建一个缓冲区
//                    byte buffer[] = new byte[1024];
//                    //判断输入流中的数据是否已经读完的标识
//                    int len = 0;
//                    //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
//                    while((len=in.read(buffer))>0){
//                        //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
//                        out.write(buffer, 0, len);
//                    }
//                    //关闭输入流
//                    in.close();
//                    //关闭输出流
//                    out.close();
//                    //删除处理文件上传时生成的临时文件
//                    item.delete();
//                   // message = "文件上传成功！";
//
//                    System.out.println("文件上传成功");
//                }
//            }
//        }catch (Exception e) {
//            //message= "文件上传失败！";
//            System.out.println("文件上传失败");
//            e.printStackTrace();
//
//        }


    @RequestMapping("/upload.do")
    public String upLoad(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 从请求中获取到文件信息需要将请求转换为MultipartHttpServletRequest类型
//        MultipartHttpServletRequest MulRequest = request instanceof MultipartHttpServletRequest ? (MultipartHttpServletRequest) request : null;
//        String name = request.getParameter("name");// 依然可以从请求中获取到除图片之外的参数
//        System.out.println("name:" + name);
//        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
//        if (multipartResolver.isMultipart(request)) {
//            //将request变成多部分request
//            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
//            //获取multiRequest 中所有的文件名
//            Iterator iter = multiRequest.getFileNames();
//
//            while (iter.hasNext()) {
//                //一次遍历所有文件
//                MultipartFile file = multiRequest.getFile(iter.next().toString());
//                if (file != null) {
//                    String path = "G:/lw/workspace/" + name + file.getOriginalFilename();
//                    //上传
//                    file.transferTo(new File(path));
//                }
//
//            }
//        }
//        return null;
//    }
//        MultipartHttpServletRequest MulRequest = request instanceof MultipartHttpServletRequest ? (MultipartHttpServletRequest) request : null;
//       String na request.getParameter("name");// 依然可以从请求中获取到除图片之外的参数
//        System.out.println("name:" + name);
//        Iterator<String> fileNames = MulRequest.getFileNames();
//        if (fileNames.hasNext()) { // 遍历请求中的图片信息
//            String fileName = fileNames.next(); // 图片对应的参数名
//            log.debug("fileName:" + fileName);
//            file = MulRequest.getFile(fileName); // 获取到图片
//            if (file != null) {
//                log.debug("file.getSize():" + file.getSize()); // 图片大小
//                file.getBytes();// 可以获取到图片的字节数组
//                images.put(fileName, file.getBytes());// 获取到图片以字节数组形式保存在服务器内存中
//            }
//        }
//
        return null;
        //}
    }
}
