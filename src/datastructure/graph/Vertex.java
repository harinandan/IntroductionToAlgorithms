package datastructure.graph;

public class Vertex <T> {
	T _data;
	
	public Vertex(T data)
	{
		_data = data;
	}
	
	public T getData()
	{
		return _data;
	}

}
