package vn.iotstar.controller.admin;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import vn.iotstar.config.Decode;
import vn.iotstar.dao.impl.CategoryDaoImpl;
import vn.iotstar.entity.Category;
import vn.iotstar.entity.Product;



@WebServlet(urlPatterns = { "/admin-category", "/admin-category/create", "/admin-category/update",
		"/admin-category/edit", "/admin-category/delete" })
public class CategoryController extends HttpServlet{

	/**
	 * 
	 */
	CategoryDaoImpl categorydao = new CategoryDaoImpl();
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getRequestURL().toString();
		Category category = null;
		if (url.contains("create")) {
			request.getRequestDispatcher("/views/admin/category/add.jsp").forward(request, response);
		} else if (url.contains("delete")) {
			delete(request, response);
			category = new Category();
			request.setAttribute("category", category);
		} else if (url.contains("edit")) {
			edit(request, response);
			request.getRequestDispatcher("/views/admin/category/edit.jsp").forward(request, response);
		}
		findAll(request, response);
		request.getRequestDispatcher("/views/admin/category/list.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getRequestURL().toString();

		if (url.contains("create")) {
			insert(request, response);
		} else if (url.contains("update")) {

			update(request, response);

		} else if (url.contains("delete")) {

			delete(request, response); // bá»� cĂ¡i hĂ m nĂ y nĂ³ váº«n cháº¡y Ä‘Æ°á»£c thĂ¬ phÆ°Æ¡ng thá»©c nháº­n vĂ o láº¥y doGet bĂªn trĂªn kia 

		}
		findAll(request, response);

		request.getRequestDispatcher("/views/admin/category/list.jsp").forward(request, response);
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			String categoryId = request.getParameter("categoryId");

			Category category = categorydao.findById(Integer.parseInt(categoryId));

			request.setAttribute("category", category);

		} catch (Exception e) {

			e.printStackTrace();

			request.setAttribute("error", "Eror: " + e.getMessage());

		}

	}

	protected void insert(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		Category category = new Category();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		try {
			BeanUtils.populate(category, request.getParameterMap());
			//
			String Name=  category.getCategoryName();
			String image = category.getImages();
			//
			category.setCategoryName(Decode.encrypt(Name));
			category.setImages(Decode.encrypt(image));
			//
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		categorydao.insert(category);

	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String categoryId = request.getParameter("categoryId");
			categorydao.delete(Integer.parseInt(categoryId));

			request.setAttribute("message", "Ä�Ă£ xĂ³a thĂ nh cĂ´ng");

		} catch (Exception e) {

			e.printStackTrace();

			request.setAttribute("error", "Eror: " + e.getMessage());

		}

	}

	protected void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
											
			
			String indexPage = request.getParameter("index");
	        if(indexPage == null) {
	        	indexPage = "1";
	        }
			int index = Integer.parseInt(indexPage);
	        int count = categorydao.count();
	        int endPage = count/4;    // -> má»—i trang 4 sp 
	        if(count % 4 !=0) {
	        	endPage++;
	        }

	        // vá»›i má»—i trang 4 sp 
	        // trang 1 : 1,4 
	        // trang 2 : 1+4,4+4
	        // trang 3 : 1+4+4,4+4+4
	        // trang n : 1+(sá»‘ sp phĂ¢n trang )*(index-1) , (sá»‘ sp phĂ¢n trang )*(index)
	        int offset = 1 + 4*(index-1);
	        int limit = 4*index;
	        List<Category> list = categorydao.findAll(offset,limit);  
	        for (Category category : list) {
				String Name = category.getCategoryName();
				String image = category.getImages();
				
				category.setCategoryName(Decode.decrypt(Name));
				category.setImages(Decode.decrypt(image));

			}
	        request.setAttribute("endP", endPage);
	        request.setAttribute("tag", index);
			
			 
			request.setAttribute("categorys", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		try {

			request.setCharacterEncoding("UTF-8");

			response.setCharacterEncoding("UTF-8");


			Category category = new Category();

			BeanUtils.populate(category, request.getParameterMap());



			

			categorydao.update(category);
			request.setAttribute("category", category);
			request.setAttribute("message", "Cáº­p nháº­t thĂ nh cĂ´ng!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}

	}
	
}
