// from bits/stdc++.h
// C
#include <climits>
#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <ctime>

// C++
#include <algorithm>
#include <bitset>
#include <complex>
#include <deque>
#include <fstream>
#include <functional>
#include <iostream>
#include <istream>
#include <iterator>
#include <limits>
#include <list>
#include <map>
#include <memory>
#include <numeric>
#include <ostream>
#include <queue>
#include <set>
#include <stack>
#include <string>
#include <utility>
#include <vector>
#include <regex>
#include <tuple>
#include <unordered_map>
#include <unordered_set>

using namespace std;

typedef long long ll;
typedef long double ld;

int n, m;
vector<string> board;

// https://www.geeksforgeeks.org/detect-cycle-undirected-graph/
// Class for an undirected graph 
class Graph 
{ 
    int V;    // No. of vertices 
    vector<vector<int>> adj;    // Pointer to an array containing adjacency lists 
    bool isCyclicUtil(int v, bool visited[], int parent); 
public: 
    Graph(int V);   // Constructor 
    void addEdge(int v, int w);   // to add an edge to graph 
    bool isCyclic();   // returns true if there is a cycle 
}; 
  
Graph::Graph(int V) 
{ 
    this->V = V; 
    adj.clear();
    adj.resize(V); 
} 
  
void Graph::addEdge(int v, int w) 
{ 
    adj[v].push_back(w); // Add w to v’s list. 
    adj[w].push_back(v); // Add v to w’s list. 
} 
  
// A recursive function that uses visited[] and parent to detect 
// cycle in subgraph reachable from vertex v. 
bool Graph::isCyclicUtil(int v, bool visited[], int parent) 
{ 
    // Mark the current node as visited 
    visited[v] = true; 
  
    // Recur for all the vertices adjacent to this vertex 
    vector<int>::iterator i; 
    for (i = adj[v].begin(); i != adj[v].end(); ++i) 
    { 
        // If an adjacent is not visited, then recur for that adjacent 
        if (!visited[*i]) 
        { 
           if (isCyclicUtil(*i, visited, v)) 
              return true; 
        } 
  
        // If an adjacent is visited and not parent of current vertex, 
        // then there is a cycle. 
        else if (*i != parent) 
           return true; 
    } 
    return false; 
} 
  
// Returns true if the graph contains a cycle, else false. 
bool Graph::isCyclic() 
{ 
    // Mark all the vertices as not visited and not part of recursion 
    // stack 
    bool *visited = new bool[V]; 
    for (int i = 0; i < V; i++) 
        visited[i] = false; 
  
    // Call the recursive helper function to detect cycle in different 
    // DFS trees 
    for (int u = 0; u < V; u++) 
        if (!visited[u]) // Don't recur for u if it is already visited 
          if (isCyclicUtil(u, visited, -1)) 
             return true; 
  
    return false; 
} 

bool solve() {
    // make graph
    Graph g1(n * m); 

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            int index = m * i + j;

            // right
            if (j + 1 < m && board[i][j] == board[i][j + 1]) {
                g1.addEdge(index, index+1);
            }

            // down
            if (i + 1 < n && board[i][j] == board[i + 1][j]) {
                g1.addEdge(index, index + m);
            }
        }
    }
    
    return g1.isCyclic();
}

int main(void) {
    ios_base::sync_with_stdio(false);

    cin >> n >> m;

    for (int i = 0; i < n; ++i) {
        string s;
        cin >> s;
        board.push_back(s);
    }

    cout << (solve() ? "Yes" : "No") << endl;
    return 0;
}