package com.szh.algorithm.datastruct;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

public class GraphLession {

    public static void main(String[] args) throws JsonProcessingException {
        Vertex vertex0 = new Vertex(0);
        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Vertex vertex3 = new Vertex(3);

        LinkedList<Vertex> vertexList = new LinkedList<>();
        vertexList.add(vertex0);
        vertexList.add(vertex1);
        vertexList.add(vertex2);
        vertexList.add(vertex3);
        //0-1 0-2 0-3 2-3
        Edge edge0 = new Edge(vertex0,vertex1,10);
        Edge edge1 = new Edge(vertex1,vertex2,20);
        Edge edge2 = new Edge(vertex2,vertex3,30);
        List<Edge> edgeList = new ArrayList<>();
        edgeList.add(edge0);
        edgeList.add(edge1);
        edgeList.add(edge2);


        Graph graph = new Graph(vertexList, edgeList);
        graph.print();

        ObjectMapper objectMapper = new ObjectMapper();
        //System.out.println(objectMapper.writeValueAsString(graph.getVertices()));

    }

    static class Vertex{
        private int id;

        private Edge firstEdge;

        private int isBeginNode;

        public int getIsBeginNode() {
            return isBeginNode;
        }

        public void setIsBeginNode(int isBeginNode) {
            this.isBeginNode = isBeginNode;
        }

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

        public Edge(Vertex src, Vertex dest,int distance) {
            this.src = src;
            this.dest = dest;
            this.distance = distance;
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

        private int totalDistance = 0;


        public Graph(List<Vertex> vertices, List<Edge> edges) {
            this.vertices = vertices;
            this.edges = edges;
            for (Edge edge : edges) {
                totalDistance += edge.getDistance();
            }
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


        void print() {
            System.out.println("List Graph:\n");
            for (Vertex vertex : vertices) {
                if(vertex.getFirstEdge() != null){
                    StringBuilder head = new StringBuilder("path is " + vertex.getId() + " -> " + vertex.getFirstEdge().getDest().getId());
                    Edge tmp = vertex.getFirstEdge();
                    while (tmp.getNextEdge() != null){
                        head.append(" -> ").append(tmp.getNextEdge().getDest().getId());
                        tmp = tmp.getNextEdge();
                    }
                    System.out.println(head);
                }
            }
            System.out.println("total distance:\r");
            System.out.println(this.totalDistance);
            System.out.println("\r");
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

        public int getTotalDistance() {
            return totalDistance;
        }

        public void setTotalDistance(int totalDistance) {
            this.totalDistance = totalDistance;
        }
    }

}
