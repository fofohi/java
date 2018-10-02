package com.szh.algorithm.datastruct;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class GraphLession {

    public static void main(String[] args) throws JsonProcessingException {
        Vertex vertex0 = new Vertex(0);
        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Vertex vertex3 = new Vertex(3);
        Vertex vertex4 = new Vertex(4);

        LinkedList<Vertex> vertexList = new LinkedList<>();
        vertexList.add(vertex0);
        vertexList.add(vertex1);
        vertexList.add(vertex2);
        vertexList.add(vertex3);
        vertexList.add(vertex4);
        //0-1 0-2 0-3 2-3
        Edge edge0 = new Edge(vertex0,vertex1);
        Edge edge1 = new Edge(vertex1,vertex2);
        Edge edge2 = new Edge(vertex2,vertex3);
        Edge edge3 = new Edge(vertex3,vertex4);
        List<Edge> edgeList = new ArrayList<>();
        edgeList.add(edge0);
        edgeList.add(edge1);
        edgeList.add(edge2);
        edgeList.add(edge3);


        Graph graph = new Graph(vertexList, edgeList);
        graph.print();

        ObjectMapper objectMapper = new ObjectMapper();

        //System.out.println(objectMapper.writeValueAsString(graph));

    }

    static class Vertex{
        private int id;

        private Edge firstEdge;

        public Vertex(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Edge getFirstEdge() {
            return firstEdge;
        }

        public void setFirstEdge(Edge firstEdge) {
            this.firstEdge = firstEdge;
        }
    }

    static class Edge{
        private Vertex src;
        private Vertex dest;
        private Edge nextEdge;

        private int distance;

        public Edge(Vertex src, Vertex dest) {
            this.src = src;
            this.dest = dest;
        }

        public Vertex getSrc() {
            return src;
        }

        public void setSrc(Vertex src) {
            this.src = src;
        }

        public Vertex getDest() {
            return dest;
        }

        public void setDest(Vertex dest) {
            this.dest = dest;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public Edge getNextEdge() {
            return nextEdge;
        }

        public void setNextEdge(Edge nextEdge) {
            this.nextEdge = nextEdge;
        }
    }

    static class Graph {
        private List<Vertex> vertices;

        private List<Edge> edges;


        public Graph(List<Vertex> vertices, List<Edge> edges) {
            this.vertices = vertices;
            this.edges = edges;


            for (Vertex vertex : vertices) {
                for (Edge edge : edges) {
                    if (vertex.getId() == edge.getSrc().getId()) {
                        if (vertex.getFirstEdge() == null) {
                            vertex.setFirstEdge(edge);
                        } else {
                            Edge tmp = vertex.getFirstEdge();
                            while (tmp.getNextEdge() != null) {
                                tmp = tmp.getNextEdge();
                            }
                            tmp.setNextEdge(edge);
                        }
                    }
                }
            }
        }


        public void print() {
            System.out.printf("List Graph:\n");
            List<LinkedList<Integer>> list = new ArrayList<>();
            for (Vertex vertex : vertices) {
                if(vertex.getFirstEdge() != null){
                    StringBuilder head = new StringBuilder("path is " + vertex.getId() + " -> " + vertex.getFirstEdge().getDest().getId());
                    System.out.println();
                    LinkedList<Integer> list1 = new LinkedList<>();
                    list1.addFirst(vertex.getId());
                    list1.addLast(vertex.getFirstEdge().getDest().getId());
                    Edge tmp = vertex.getFirstEdge();
                    while (tmp.getNextEdge() != null){
                        LinkedList<Integer> list2 = new LinkedList<>();
                        head.append(" -> ").append(tmp.getNextEdge().getDest().getId());
                        list2.addFirst(tmp.getNextEdge().getSrc().getId());
                        list2.addLast(tmp.getNextEdge().getDest().getId());
                        list.add(list2);
                        tmp = tmp.getNextEdge();
                    }
                    System.out.println(head);
                    list.add(list1);
                }
            }
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                System.out.println(objectMapper.writeValueAsString(list));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }


        public List<Vertex> getVertices() {
            return vertices;
        }

        public void setVertices(List<Vertex> vertices) {
            this.vertices = vertices;
        }

        public List<Edge> getEdges() {
            return edges;
        }

        public void setEdges(List<Edge> edges) {
            this.edges = edges;
        }
    }
}
