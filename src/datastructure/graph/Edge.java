package datastructure.graph;

public class Edge<T extends Number> {
	public enum Direction {
		FORWARD,
		BACKWARD,
		NONE
	}
	private T _weight;
	private Vertex<?> _v1;
	private Vertex<?> _v2;
	private Direction _direction;
	
	public Edge(Vertex<?> v1, Vertex<?> v2, Direction direction ,T weight)
	{
		_v1 = v1;
		_v2 = v2;
		_direction = direction;
		_weight = weight;
	}
	
	public Edge(Vertex<?> v1, Vertex<?> v2)
	{
		this(v1,v2,Direction.NONE, null);
	}
	
	public Edge(Vertex<?> v1, Vertex<?> v2, Direction direction)
	{
		this(v1,v2,direction, null);
	}
	
	public Edge(Vertex<?> v1, Vertex<?> v2, T weight)
	{
		this(v1,v2,Direction.NONE, null);
	}
	
	public T getWeight(){
		return _weight;
	}

	public Vertex<?> getVertex1(){
		return _v1;
	}

	public Vertex<?> getVertex2(){
		return _v2;
	}

	public Direction getDirection(){
		return _direction;
	}
}
