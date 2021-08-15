package lj.elevator.erp.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * <div class="pages"> <span>共有1条，每页显示：10条</span><b>1</b><a href="">2</a>
 * <a href="">3</a><a href="">4</a><a href="">5</a>...<a href="">168</a>
 * <a href="">下一页</a> </div>
 * 
 * 显示格式 上一页 1 2 3 4 5 下一页
 */
public class NavigationTag extends TagSupport {
	static final long serialVersionUID = 2372405317744358833L;

	/**
	 * request 中用于保存Page<E> 对象的变量名,默认为“page”
	 */
	private String bean = "page";

	/**
	 * 分页跳转的url地址,此属性必须
	 */
	private String url = null;

	/**
	 * 显示页码数量
	 */
	private int number = 5;

	@Override
	public int doStartTag() throws JspException {

		System.out.println("我进来了.....");
		JspWriter writer = pageContext.getOut();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		// Page page = (Page) request.getAttribute(bean);
		Page page = (Page) request.getSession().getAttribute("page");
		if (page == null) {
			System.out.println("不存在");
			return SKIP_BODY;
		}
		System.out.println("存在");
		url = resolveUrl(url, pageContext);
		try {
			// 计算总页数
			int pageCount = page.getTotal() / page.getSize();
			if (page.getTotal() % page.getSize() > 0) {
				pageCount++;
			}
			// </span><b>1</b><a href="">2</a>
			writer.print("<div class=\"fr\"><div class=\"pages\">");
			// 显示“上一页”按钮
			if (page.getPage() > 1) {
				String preUrl = append(url, "page", page.getPage() - 1);
				preUrl = append(preUrl, "rows", page.getSize());
				writer.print("<a href=\"" + preUrl + "\">上一页</a>");
			} else {
				writer.print("<a href=\"#\">上一页</a>");
			}
			// 显示当前页码的前2页码和后两页码
			// 若1 则 1 2 3 4 5, 若2 则 1 2 3 4 5, 若3 则1 2 3 4 5,
			// 若4 则 2 3 4 5 6 ,若10 则 8 9 10 11 12
			int indexPage = (page.getPage() - 2 > 0) ? page.getPage() - 2 : 1;
			for (int i = 1; i <= number && indexPage <= pageCount; indexPage++, i++) {
				if (indexPage == page.getPage()) {
					writer.print("<a href=\"#\">" + indexPage + "<span >(目前)</span></a>");
					continue;
				}
				String pageUrl = append(url, "page", indexPage);
				pageUrl = append(pageUrl, "rows", page.getSize());
				writer.print("<a href=\"" + pageUrl + "\">" + indexPage + "</a>");
			}
			// 显示“下一页”按钮
			if (page.getPage() < pageCount) {
				String nextUrl = append(url, "page", page.getPage() + 1);
				nextUrl = append(nextUrl, "rows", page.getSize());
				writer.print("<a href=\"" + nextUrl + "\">下一页</a>");
			} else {
				writer.print("<a href=\"#\">下一页</a>");
			}
			writer.print("</div></div>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	private String append(String url, String key, int value) {

		return append(url, key, String.valueOf(value));
	}

	/**
	 * 为url 参加参数对儿
	 * 
	 * @param url
	 * @param key
	 * @param value
	 * @return
	 */
	private String append(String url, String key, String value) {
		if (url == null || url.trim().length() == 0) {
			return "";
		}

		if (url.indexOf("?") == -1) {
			url = url + "?" + key + "=" + value;
		} else {
			if (url.endsWith("?")) {
				url = url + key + "=" + value;
			} else {
				url = url + "&amp;" + key + "=" + value;
			}
		}

		return url;
	}

	/**
	 * 为url 添加翻页请求参数
	 * 
	 * @param url
	 * @param pageContext
	 * @return
	 * @throws javax.servlet.jsp.JspException
	 */
	private String resolveUrl(String url, javax.servlet.jsp.PageContext pageContext) throws JspException {
		// UrlSupport.resolveUrl(url, context, pageContext)
		Map params = pageContext.getRequest().getParameterMap();
		int index = 0;
		List<String> list = new ArrayList<String>();

		for (Object key : params.keySet()) {
			if ("page".equals(key) || "rows".equals(key))
				continue;

			Object value = params.get(key);

			if (value == null)
				continue;
			try {
				if (value.getClass().isArray()) {
					// 解决GET乱码问题
					// value = new String(((String[])
					// value)[0].getBytes("ISO-8859-1"), "UTF-8");

					value = ((String[]) value)[0];
					url = append(url, key.toString(), value.toString());
				} else if (value instanceof String) {
					// 解决GET乱码问题
					// value = new String(((String)
					// value).getBytes("ISO-8859-1"), "UTF-8");
					value = (String) value;
					url = append(url, key.toString(), value.toString());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return url;
	}

	/**
	 * @return the bean
	 */
	public String getBean() {
		return bean;
	}

	/**
	 * @param bean
	 *            the bean to set
	 */
	public void setBean(String bean) {
		this.bean = bean;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
