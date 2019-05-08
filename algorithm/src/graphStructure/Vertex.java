package graphStructure;

/**
 * 顶点类
 * @author 王任重
 *
 */
public class Vertex {
	
	private String value;
	public boolean visited;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Vertex(String value) {
		super();
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
	
	
}
