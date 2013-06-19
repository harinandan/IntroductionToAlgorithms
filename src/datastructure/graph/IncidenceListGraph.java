package datastructure.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import algorithm.graph.ShortestPathStrategy;

public class IncidenceListGraph<T, N extends Number> implements Graph<T, N> {
	List<Edge<N>> _edges = new LinkedList<Edge<N>>();
	List<Vertex<T>> _vertices = new LinkedList<Vertex<T>>();

	@Override
	public void addVertex(T data) {
		if(data == null)
			throw new IllegalArgumentException("Vertex data cannot be null");
		_vertices.add(new Vertex<T>(data));
	}

	@Override
	public Vertex<T> getVertex(T data) {
		for (Vertex<T> vertex : _vertices) {
			if(vertex.getData().equals(data))
				return vertex;
		}
		
		throw new NoSuchElementException("Vertex with data '"+data+"'");
	}

	@Override
	public Vertex<T> removeVertex(T data) {
		Vertex<T> v = getVertex(data);
		_vertices.remove(v);
		return v;
	}

	@Override
	public void addEdge(T data1, T data2) {
		_edges.add(new Edge<N>(getVertex(data1), getVertex(data2), Edge.Direction.NONE,null));
	}

	@Override
	public void addEdge(T data1, T data2, Edge.Direction direction, N weight) {
		throw new RuntimeException("This method is not yet supported");
	}

	@Override
	public Edge<N> getEdge(T data1, T data2) {
		for (Edge<N> edge : _edges) {
			if(edge.getVertex1().getData().equals(data1) && edge.getVertex1().getData().equals(data2))
				return edge;
		}
		throw new NoSuchElementException("Edge between with '"+data1+"' and '"+data2+"'");
	}

	@Override
	public Edge<N> removeEdge(T data1, T data2) {
		Edge<N> e = getEdge(data1, data2);
		_edges.remove(e);
		return e;
	}

	@Override
	public boolean hasEdge(T data1, T data2) {
		try{
			getEdge(data1, data2);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@Override
	public boolean hasVertex(T data) {
		try{
			getVertex(data);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vertex<T>> neighbours(T data) {
		List<Vertex<T>>  neighbours = new LinkedList<Vertex<T>>();
		
		for (Edge<N> edge : _edges) {
			if(edge.getVertex1().getData().equals(data))
				neighbours.add((Vertex<T>) edge.getVertex2());
		}
		
		return neighbours;
	}

	@Override
	public boolean isEmpty() {
		return _vertices.isEmpty();
	}

	@Override
	public List<Vertex<T>> findShortestPath(T data1, T data2,
			ShortestPathStrategy<T> algorithm) {
		return algorithm.findShortestPath(data1, data2);
	}

}
