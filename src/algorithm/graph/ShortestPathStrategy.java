package algorithm.graph;

import java.util.List;

import datastructure.graph.Vertex;

public interface ShortestPathStrategy<T> {
	public List<Vertex<T>> findShortestPath(T data1, T data2);

}
