package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/***
 *This methods extends an AdjacencyGraph. The implementation by provides a depth first traversal solution.
 * 
 * @author Ben Scott
 * @version January 2020
 */
public class DepthFirstTraversal<T> extends AdjacencyGraph<T> implements Traversal<T>
{

    /**
     * The graph has a depth first traversal performed on it, then returns the nodes on the specific order in which they were visited
     * 
     * @return The graph traversal where every node gets visited once.
     */
    @Override
    public List<T> traverse() throws GraphError
    {

        HashSet<T> a = new HashSet<T>(); // a - The node which is visited
        Stack<T> stack = new Stack<T>();
        List<T> output = new ArrayList<T>();
        T currentNode;

        stack.addAll(getNodes()); //The stack list gets started with all the nodes

        while (!stack.isEmpty()) //while stack is empty
        {
            currentNode = stack.pop();

            if (a.contains(currentNode))
                continue;

            a.add(currentNode);
            output.add(currentNode);
            stack.addAll(getNeighbours(currentNode));
        }

        return output;
    }
}
