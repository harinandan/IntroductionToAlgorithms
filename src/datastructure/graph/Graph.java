package datastructure.graph;

import java.util.List;

import algorithm.graph.ShortestPathStrategy;

public interface Graph<T, N extends Number>{
	public void addVertex(T data);
	public Vertex<T> getVertex(T data);
	public Vertex<T> removeVertex(T data);
	
	public void addEdge(T data1, T data2);
	public void addEdge(T data1, T data2, Edge.Direction direction, N weight);
	public Edge<N> getEdge(T data1, T data2);
	public Edge<N> removeEdge(T data1, T data2);
	
	public boolean hasEdge(T data1, T data2);
	public boolean hasVertex(T data);
	
	public List<Vertex<T>> neighbours(T data);
	
	public boolean isEmpty();
	
	public List<Vertex<T>> findShortestPath(T data1, T data2, ShortestPathStrategy<T> algorithm);
}
