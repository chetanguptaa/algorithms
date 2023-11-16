package graphs;

import java.util.*;

public class GraphQuestions {
    public static void main(String[] args) {
        HashMap<Character, List<Character>> map = new HashMap<>();
        map.put('a', Arrays.asList('b', 'c'));
        map.put('b', List.of('d'));
        map.put('c', List.of('e'));
        map.put('d', List.of('f'));
        map.put('e', new ArrayList<>());
        map.put('f', new ArrayList<>());
        char[][] graph = new char[][] { { 'i', 'j' }, { 'k', 'i' }, { 'm', 'k' }, { 'k', 'l' }, { 'o', 'n' } };
        // depthFirst(map, 'a');
        // breadthFirst(map, 'a');
        // depthFirstRecursive(map, 'a');
        // System.out.println(hasPathDepth(map, 'a', 'f'));
        // System.out.println(hasPathBreadth(map, 'a', 'f'));
        // System.out.println(toAdjList(graph));
        // System.out.println(undirectedPath(graph, 'o', 'n'));
        HashMap<Integer, List<Integer>> map2 = new HashMap<>();
        map2.put(3, List.of());
        map2.put(4, List.of(6));
        map2.put(6, Arrays.asList(4, 5, 7, 8));
        map2.put(8, List.of(6));
        map2.put(7, List.of(6));
        map2.put(5, List.of(6));
        map2.put(1, List.of(2));
        map2.put(2, List.of(1));
        // System.out.println(componentsCount(map2, 1));
        // System.out.println(largestComponent(map2));
        System.out.println(islandCount(graph));
    }

    static void depthFirst(HashMap<Character, List<Character>> graph, Character source) {
        Stack<Character> stack = new Stack<>();
        stack.push(source);
        while (!stack.isEmpty()) {
            Character curr = stack.pop();
            System.out.println(curr);
            for (Character adjacent : graph.get(curr))
                stack.push(adjacent);
        }
    }

    static void breadthFirst(HashMap<Character, List<Character>> graph, Character source) {
        Queue<Character> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            Character curr = queue.poll();
            System.out.println(curr);
            for (Character adjacent : graph.get(curr))
                queue.add(adjacent);
        }
    }

    static void depthFirstRecursive(HashMap<Character, List<Character>> graph, Character source) {
        System.out.println(source);
        for (Character adjacent : graph.get(source))
            depthFirstRecursive(graph, adjacent);
    }

    static boolean hasPathDepth(HashMap<Character, List<Character>> graph, Character source, Character target) {
        Stack<Character> stack = new Stack<>();
        stack.push(source);
        while (!stack.isEmpty()) {
            Character curr = stack.pop();
            if (curr == target)
                return true;
            for (Character adjacent : graph.get(curr))
                stack.push(adjacent);
        }
        return false;
    }

    static boolean hasPathBreadth(HashMap<Character, List<Character>> graph, Character source, Character target) {
        Queue<Character> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            Character curr = queue.poll();
            if (curr == target)
                return true;
            for (Character adjacent : graph.get(curr))
                queue.add(adjacent);
        }
        return false;
    }

    static HashMap<Character, List<Character>> toAdjList(char[][] graph) {
        HashMap<Character, List<Character>> map = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            List<Character> adjList1 = map.getOrDefault(graph[i][0], new ArrayList<>());
            List<Character> adjList2 = map.getOrDefault(graph[i][1], new ArrayList<>());
            adjList1.add(graph[i][1]);
            adjList2.add(graph[i][0]);
            map.put(graph[i][0], adjList1);
            map.put(graph[i][1], adjList2);
        }
        return map;
    }

    static <T> Map<T, List<T>> toAdjListGeneric(T[][] graph) {
        Map<T, List<T>> map = new HashMap<>();
        for (T[] edge : graph) {
            T from = edge[0];
            T to = edge[1];

            List<T> adjList1 = map.getOrDefault(from, new ArrayList<>());
            List<T> adjList2 = map.getOrDefault(to, new ArrayList<>());
            adjList1.add(to);
            adjList2.add(from);
            map.put(from, adjList1);
            map.put(to, adjList2);
        }
        return map;
    }

    static boolean undirectedPath(char[][] edges, char nodeA, char nodeB) {
        Map<Character, List<Character>> graph = toAdjList(edges);
        return hasPath(graph, nodeA, nodeB, new HashSet<>());
    }

    static boolean hasPath(Map<Character, List<Character>> graph, char source, char destination, Set<Character> visited) {
        if (source == destination)
            return true;
        if (visited.contains(source))
            return false;
        visited.add(source);
        for (char neighbor : graph.getOrDefault(source, new ArrayList<>()))
            if (hasPath(graph, neighbor, destination, visited))
                return true;
        return false;
    }

    static <T> int componentsCount(Map<T, List<T>> graph, T source) {
        HashSet<T> visited = new HashSet<>();
        Stack<T> stack = new Stack<>();
        visited.add(source);
        stack.push(source);
        int count = 1;
        while (!stack.isEmpty()) {
            T curr = stack.pop();
            visited.add(curr);
            for (T neighbor : graph.get(curr)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    stack.push(neighbor);
                    count++;
                }
            }
        }
        return count;
    }

    static int largestComponent(Map<Integer, List<Integer>> graph) {
        int longest = 0;
        for (int node : graph.keySet()) Math.max(longest, exploreSize(graph, node));
        return longest;
    }

    static int exploreSize(Map<Integer, List<Integer>> graph, int node) {
        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        visited.add(node);
        int count = 1;
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            visited.add(curr);
            for (int neighbor : graph.get(curr)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    stack.push(neighbor);
                    count++;
                }
            }
        }
        return count;
    }

    static int shortestPath(Integer[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = toAdjListGeneric(edges);
        HashSet<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { source, 0 });
        visited.add(source);
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int distance = current[1];
            if (node == destination)
                return distance;
            List<Integer> neighbors = graph.getOrDefault(node, new ArrayList<>());
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.offer(new int[] { neighbor, distance + 1 });
                    visited.add(neighbor);
                }
            }
        }
        return -1;
    }

    static int islandCount(char[][] edges) {
        HashSet<String> visited = new HashSet<>();
        int count = 0;
        for (int r = 0; r < edges.length; r++) {
            for (int c = 0; c < edges[0].length; c++) {
                if (explore(edges, r, c, visited))
                    count++;
            }
        }
        return count;
    }

    static boolean explore(char[][] edges, int r, int c, HashSet<String> visited) {
        boolean rowInBounds = 0 <= r && r < edges.length;
        boolean colInBounds = 0 <= c && c < edges[0].length;
        if (!rowInBounds || !colInBounds)
            return false;
        if (edges[r][c] == 'W')
            return false;
        String pos = String.valueOf( r + ',' + c);
        if (visited.contains(pos))
            return false;
        visited.add(pos);
        explore(edges, r - 1, c, visited);
        explore(edges, r + 1, c, visited);
        explore(edges, r, c + 1, visited);
        explore(edges, r, c - 1, visited);
        return true;
    }

    static int miniSizeInsland(char[][] edges) {
        HashSet<String> visited = new HashSet<>();
        int size = Integer.MAX_VALUE;
        for (int r = 0; r < edges.length; r++) {
            for (int c = 0; c < edges[0].length; c++) {
                size = Math.min(size, sizeExplorer(edges, r, c, visited));
            }
        }
        return size;
    }

    static int sizeExplorer(char[][] edges, int r, int c, HashSet<String> visited) {
        boolean rowInBounds = 0 <= r && r < edges.length;
        boolean colInBounds = 0 <= c && c < edges[0].length;
        if (!rowInBounds || !colInBounds)
            return 0;
        if (edges[r][c] == 'W')
            return 0;
        String pos = String.valueOf(r + ',' + c);
        if (visited.contains(pos))
            return 0;
        int size = 1;
        size += sizeExplorer(edges, r - 1, c, visited);
        size += sizeExplorer(edges, r + 1, c, visited);
        size += sizeExplorer(edges, r, c + 1, visited);
        size += sizeExplorer(edges, r, c - 1, visited);
        return size;
    }
    public static int[] topologicalSort(int V, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < V; i++) {
            if(!visited[i]) dfs(adjList, i, visited, stack);
        }
        int[] ans = new int[V];
        int idx = 0;
        while(!stack.isEmpty()) {
            ans[idx++] = stack.pop();
        }
        return ans;
    }
    private static void dfs(List<List<Integer>> adjList, int i, boolean[] visited, Stack<Integer> stack) {
        visited[i] = true;
        for(int neighbor: adjList.get(i)) {
            if(!visited[neighbor]) dfs(adjList, neighbor, visited, stack);
        }
        stack.push(i);
    }
    public static int[] topologicalSortUsingBFS(int V, List<List<Integer>> adjList) {
        // Also Known as the Kahn's Algorithm
        int[] inDeg = new int[V];
        for(List<Integer> list: adjList) for(int i: list) inDeg[i]++;
        List<Integer> ansList = new ArrayList<>();
        bfs(adjList, V, 0, ansList, inDeg);
        int[] ans = new int[V];
        int idx = 0;
        for(int edge: ansList) {
            ans[idx++] = edge;
        }
        return ans;
    }
    private static void bfs(List<List<Integer>> adjList, int V, int v, List<Integer> ans, int[] inDeg) {
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < V; i++) {
            if(inDeg[i] == 0) queue.offer(i);
        }
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            ans.add(curr);
            for(int neighbor: adjList.get(curr)) {
                if(--inDeg[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
    }
    public static boolean cycleDetectionInUndirected(int V, List<List<Integer>> adjList) {
        boolean[] vis = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                if(dfsCycleDetection(i, adjList, vis, -1)) return true;
            }
        }
        return false;
    }
    private static boolean dfsCycleDetection(int i, List<List<Integer>> adjList, boolean[] vis, int parent) {
        vis[i] = true;
        for(int neighbor: adjList.get(i)) {
            if(!vis[neighbor]) {
                if(dfsCycleDetection(neighbor, adjList, vis, parent)) return true;
            } else if(parent != neighbor) return true;
        }
        return false;
    }
    public static boolean cycleDetectionInDirected(int V, List<List<Integer>> adjList) {
        boolean[] vis = new boolean[V];
        return false;
    }
    public static class Pair implements Comparable<Pair> {
        int v;
        int wt;
        Pair(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
        public int compareTo(Pair that) {
            return this.wt - that.wt;
        }
    }
    public static int spanningTreePrimsAlgo(int v, List<List<List<Integer>>> adjList) {
        boolean[] vis = new boolean[v];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int ans = 0;
        while(pq.size() != 0) {
            Pair curr = pq.remove();
            int u = curr.v;
            if(vis[u]) continue;
            ans += curr.wt;
            vis[u] = true;
            List<List<Integer>> neighbors = adjList.get(u);
            for(List<Integer> list: neighbors) {
                int vertex = list.get(0);
                int wt = list.get(1);
                if(!vis[vertex]) pq.add(new Pair(vertex, wt));
            }
        }
        return ans;
    }
}
