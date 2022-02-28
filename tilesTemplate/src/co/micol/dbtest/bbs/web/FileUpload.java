package co.micol.dbtest.bbs.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.JsonObject;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/fileUpload")
public class FileUpload extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JsonObject json = new JsonObject();
		response.setCharacterEncoding("UTF-8");

		System.out.println("doPost call()");
		String path = "c:/tmp";

		ServletContext sc = this.getServletContext();
		path = sc.getRealPath("upload"); // 서버상경로.

		MultipartRequest multi = //
				new MultipartRequest(request, // 요청정보
						path, // 저장위치
						8 * 1024 * 1024, // 용량
						"UTF-8", // 인코딩
						new DefaultFileRenamePolicy());

		Enumeration en = multi.getFileNames();
		String author = multi.getParameter("author");
		String title = multi.getParameter("title");
		String fileN = null;
		while (en.hasMoreElements()) {
			String name = (String) en.nextElement();
			String fileName = multi.getFilesystemName(name);
			fileN = fileName;
			System.out.println("name: " + name + ", fileName: " + fileName);
		}

		json.addProperty("uploaded", 1);
		json.addProperty("fileName", fileN);
		json.addProperty("url", request.getContextPath() + "/upload/" + fileN);

		response.getWriter().print(json);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JsonObject json = new JsonObject();
		PrintWriter printWriter = null;
		OutputStream out = null;
		MultipartHttpServletRequest multiFile = (MultipartHttpServletRequest) req;
		MultipartFile file = multiFile.getFile("upload");

		if (file != null) {
			if (file.getSize() > 0 && StringUtils.isNotBlank((file.getName()))) {
				if (file.getContentType().toLowerCase().startsWith("image/")) {
					String fileName = file.getName();
					byte[] bytes = file.getBytes();
					String uploadPath = req.getServletContext().getRealPath("/img");
					System.out.println(uploadPath);
					File uploadFile = new File(uploadPath);
					if (!uploadFile.exists()) {
						uploadFile.mkdirs();
					}
					fileName = UUID.randomUUID().toString();
					uploadPath = uploadPath + "/" + fileName;
					out = new FileOutputStream(new File(uploadPath));
					out.write(bytes);

					printWriter = resp.getWriter();
					resp.setContentType("text/html");
					String fileUrl = req.getContextPath() + "/img/" + fileName;

					json.addProperty("uploaded", 1);
					json.addProperty("fileName", fileName);
					json.addProperty("url", fileUrl);

					printWriter.println(json);

					out.close();
					printWriter.close();

				}
			}
		}
	}
}
