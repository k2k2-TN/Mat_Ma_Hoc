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
import vn.iotstar.config.Decode_1;
import vn.iotstar.dao.impl.CategoryDaoImpl;
import vn.iotstar.dao.impl.ProductDaoImpl;
import vn.iotstar.entity.Category;
import vn.iotstar.entity.Product;
import vn.iotstar.entity.Seller;



@WebServlet(urlPatterns = { "/admin-product", "/admin-product/create", "/admin-product/update",
		"/admin-product/edit", "/admin-product/delete" , "/admin-product/search" })
public class ProductController extends HttpServlet{

	/**
	 * 
	 */
	ProductDaoImpl productdao = new ProductDaoImpl();
	CategoryDaoImpl categorydao = new CategoryDaoImpl();
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getRequestURL().toString();
		Product product = null;
		findAllCategory(request, response);
		if (url.contains("create")) {
			request.getRequestDispatcher("/views/admin/product/add.jsp").forward(request, response);
		} else if (url.contains("delete")) {
			delete(request, response);
			product = new Product();
			request.setAttribute("product", product);
		} else if (url.contains("edit")) {
			edit(request, response);
			request.getRequestDispatcher("/views/admin/product/edit.jsp").forward(request, response);
		}else if (url.contains("search")) {

			search(request, response); // bĂƒÂ¡Ă‚Â»Ă¯Â¿Â½ cĂƒÆ’Ă‚Â¡i hĂƒÆ’Ă‚Â m nĂƒÆ’Ă‚Â y nĂƒÆ’Ă‚Â³ vĂƒÂ¡Ă‚ÂºĂ‚Â«n chĂƒÂ¡Ă‚ÂºĂ‚Â¡y Ăƒâ€�Ă¢â‚¬ËœĂƒâ€ Ă‚Â°ĂƒÂ¡Ă‚Â»Ă‚Â£c thĂƒÆ’Ă‚Â¬ phĂƒâ€ Ă‚Â°Ăƒâ€ Ă‚Â¡ng thĂƒÂ¡Ă‚Â»Ă‚Â©c nhĂƒÂ¡Ă‚ÂºĂ‚Â­n vĂƒÆ’Ă‚Â o lĂƒÂ¡Ă‚ÂºĂ‚Â¥y doGet bĂƒÆ’Ă‚Âªn trĂƒÆ’Ă‚Âªn kia 

		}
		findAll(request, response);
		findAllCategory(request, response);
		request.getRequestDispatcher("/views/admin/product/list.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getRequestURL().toString();
		findAllCategory(request, response);
		if (url.contains("create")) {
			insert(request, response);
		} else if (url.contains("update")) {

			update(request, response);

		} else if (url.contains("delete")) {

			delete(request, response); // bĂƒÂ¡Ă‚Â»Ă¯Â¿Â½ cĂƒÆ’Ă‚Â¡i hĂƒÆ’Ă‚Â m nĂƒÆ’Ă‚Â y nĂƒÆ’Ă‚Â³ vĂƒÂ¡Ă‚ÂºĂ‚Â«n chĂƒÂ¡Ă‚ÂºĂ‚Â¡y Ăƒâ€�Ă¢â‚¬ËœĂƒâ€ Ă‚Â°ĂƒÂ¡Ă‚Â»Ă‚Â£c thĂƒÆ’Ă‚Â¬ phĂƒâ€ Ă‚Â°Ăƒâ€ Ă‚Â¡ng thĂƒÂ¡Ă‚Â»Ă‚Â©c nhĂƒÂ¡Ă‚ÂºĂ‚Â­n vĂƒÆ’Ă‚Â o lĂƒÂ¡Ă‚ÂºĂ‚Â¥y doGet bĂƒÆ’Ă‚Âªn trĂƒÆ’Ă‚Âªn kia 

		}else if (url.contains("search")) {

			search(request, response); // bĂƒÂ¡Ă‚Â»Ă¯Â¿Â½ cĂƒÆ’Ă‚Â¡i hĂƒÆ’Ă‚Â m nĂƒÆ’Ă‚Â y nĂƒÆ’Ă‚Â³ vĂƒÂ¡Ă‚ÂºĂ‚Â«n chĂƒÂ¡Ă‚ÂºĂ‚Â¡y Ăƒâ€�Ă¢â‚¬ËœĂƒâ€ Ă‚Â°ĂƒÂ¡Ă‚Â»Ă‚Â£c thĂƒÆ’Ă‚Â¬ phĂƒâ€ Ă‚Â°Ăƒâ€ Ă‚Â¡ng thĂƒÂ¡Ă‚Â»Ă‚Â©c nhĂƒÂ¡Ă‚ÂºĂ‚Â­n vĂƒÆ’Ă‚Â o lĂƒÂ¡Ă‚ÂºĂ‚Â¥y doGet bĂƒÆ’Ă‚Âªn trĂƒÆ’Ă‚Âªn kia 

		}
		findAll(request, response);
		findAllCategory(request, response);
		request.getRequestDispatcher("/views/admin/product/list.jsp").forward(request, response);
	}
	
	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			String categoryId = request.getParameter("categoryId");

			List<Product> list = productdao.getProductByCID(Integer.parseInt(categoryId));

			request.setAttribute("products", list);
			request.getRequestDispatcher("/views/admin/product/list.jsp").forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();

			request.setAttribute("error", "Eror: " + e.getMessage());

		}

	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			String productId = request.getParameter("productId");

			Product product = productdao.findProductByID(Integer.parseInt(productId));

			request.setAttribute("product", product);

		} catch (Exception e) {

			e.printStackTrace();

			request.setAttribute("error", "Eror: " + e.getMessage());

		}

	}

	protected void insert(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		Product product = new Product();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		try {
			BeanUtils.populate(product, request.getParameterMap());
			// set categoryId
			String Name=  product.getProductName();
			String code = product.getProductCode();
			String amount = product.getAmount();
			String date = product.getCreateDate();
			String piece = product.getPrice();
			String image = product.getImages();
			String status = product.getStatus();
			String wisklist = product.getWishlist();
			String stock = product.getStock();
			String des = product.getDescription();
			//String category_name = category.getCategory();
			//
			product.setProductCode(Decode.encrypt(code));
			//
			product.setProductName(Decode_1.RC4Encrypt(Name));
			//
			product.setAmount(Decode.encrypt(amount));
			//
			product.setCreateDate(Decode.encrypt(date));
			//
			product.setPrice(Decode.encrypt(piece));
			//
			product.setImages(Decode.encrypt(image));
			//
			product.setStatus(Decode.encrypt(status));
			//
			product.setWishlist(Decode.encrypt(wisklist));
			//
			product.setStock(Decode.encrypt(stock));
			//
			product.setDescription(Decode.encrypt(des));
			//category.setCategory(Decode.encrypt(category_name));
			//System.out.println(product.getProductName());
			//System.out.println(product.getProductCode());
			Category category = new Category();
			category.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));
			product.setCategory(category);
			// set store 
						
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		productdao.insert(product);

	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String productId = request.getParameter("productId");
			productdao.delete(Integer.parseInt(productId));

			request.setAttribute("message", "Ăƒâ€�Ă¯Â¿Â½ĂƒÆ’Ă‚Â£ xĂƒÆ’Ă‚Â³a thĂƒÆ’Ă‚Â nh cĂƒÆ’Ă‚Â´ng");

		} catch (Exception e) {

			e.printStackTrace();

			request.setAttribute("error", "Eror: " + e.getMessage());

		}

	}
	protected void findAllCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			List<Category> list = categorydao.findAll();
			for (Category category : list) {
				String Name = category.getCategoryName();
				
				category.setCategoryName(Decode.decrypt(Name));	

			}
			request.setAttribute("categorys", list);
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
	        int count = productdao.count();
	        int endPage = count/4;    // -> mĂƒÂ¡Ă‚Â»Ă¢â‚¬â€�i trang 4 sp 
	        if(count % 4 !=0) {
	        	endPage++;
	        }	        
	        int offset = 1 + 4*(index-1);
	        int limit = 4*index;
	        List<Product> list = productdao.findAll(offset,limit);   
	        for (Product product : list) {
				String Name = product.getProductName();
				String code = product.getProductName();
				String date = product.getCreateDate();
				String amount = product.getAmount();
				String piece = product.getPrice();
				String image = product.getImages();
				String status = product.getStatus();
				String wisklist = product.getWishlist();
				String stock = product.getStock();
				String des = product.getDescription();
				
				product.setProductName(Decode_1.RC4Encrypt(Name));
				product.setProductCode(Decode.decrypt(code));
				product.setAmount(Decode.decrypt(amount));
				product.setCreateDate(Decode.decrypt(date));
				product.setPrice(Decode.decrypt(piece));
				product.setImages(Decode.decrypt(image));
				product.setCreateDate(Decode.decrypt(status));
				product.setPrice(Decode.decrypt(wisklist));
				product.setImages(Decode.decrypt(stock));
				product.setDescription(Decode.decrypt(des));
				product.setStatus(Decode.decrypt(status));
			}
	        request.setAttribute("endP", endPage);
	        request.setAttribute("tag", index);
			
			 
			request.setAttribute("products", list);
			//
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


			Product product = new Product();

			BeanUtils.populate(product, request.getParameterMap());
			
			//set thuĂƒÂ¡Ă‚Â»Ă¢â€�Â¢c tĂƒÆ’Ă‚Â­nh cho khĂƒÆ’Ă‚Â³a ngoĂƒÂ¡Ă‚ÂºĂ‚Â¡i
			Category category = new Category();
			category.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));

			product.setCategory(category);
			
			Seller seller = new Seller();
			seller.setSellerId(Integer.parseInt(request.getParameter("sellerId")));
			
			product.setSeller(seller);
			
			productdao.update(product);
			request.setAttribute("product", product);
			request.setAttribute("message", "Cáº­p nháº­t thĂ nh cĂ´ng");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}

	}
	
}
