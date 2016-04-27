package win.system.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.type.Alias;

 
/**
 * 对分页的基本数据进行一个简单的封装
 */
@Alias(value = "page")
// extends SearchParams 
public class Page<T> implements Serializable {
	
    private int pageNo = 1;//页码，默认是第一页
    private int pageSize = 10;//每页显示的记录数，默认是10
    private int total;//总记录数
    private int totalPage;//总页数
    private List<T> rows;//对应的当前页记录
    private T params ;//其他的参数我们把它分装成一个Map对象
    
    private Map<String,Object> map;
    private String sort;
    private String order;
    
    public int getPageNo() {
       return pageNo;
    }
 
    public void setPageNo(int pageNo) {
       this.pageNo = pageNo;
    }
 
	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public int getPageSize() {
       return pageSize;
    }
 
    public void setPageSize(int pageSize) {
       this.pageSize = pageSize;
    }
 
    public int getTotal() {
       return total;
    }
 
    public void setTotal(int total) {
       this.total = total;
       //在设置总页数的时候计算出对应的总页数，在下面的三目运算中加法拥有更高的优先级，所以最后可以不加括号。
       int totalPage = total%pageSize==0 ? total/pageSize : total/pageSize + 1;
       this.setTotalPage(totalPage);
    }
 
    public int getTotalPage() {
       return totalPage;
    }
 
    public void setTotalPage(int totalPage) {
       this.totalPage = totalPage;
    }
 
    public List<T> getRows() {
       return rows;
    }
 
    public void setRows(List<T> rows) {
       this.rows = rows;
    }
   
    public T getParams() {
       return (T) (params==null?new Object():params);
    }
   
    public void setParams(T params) {
       this.params = params;
    }
 
    @Override
    public String toString() {
       StringBuilder builder = new StringBuilder();
       builder.append("Page [pageNo=").append(pageNo).append(", pageSize=")
              .append(pageSize).append(", rows=").append(rows).append(
                     ", totalPage=").append(totalPage).append(
                     ", total=").append(total).append("]");
       return builder.toString();
    }

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
 
}