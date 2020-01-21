package graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DepthFirstTraversalTest
{
    @Test
    public void GenGraphTest5() throws GraphError
    {
        GenGraphTest(5);
    }
    @Test
    public void GenGraphTest10() throws GraphError
    {
        GenGraphTest(10);
    }

    @Test
    public void GenGraphTest50() throws GraphError
    {
        GenGraphTest(50);
    }
    @Test
    public void GenGraphTest100() throws GraphError
    {
        GenGraphTest(100);
    }
    @Test
    public void GenGraphTest500() throws GraphError
    {
        GenGraphTest(500);
    }
    @Test
    public void GenGraphTest1000() throws GraphError
    {
        GenGraphTest(1000);
    }
    @Test
    public void GenGraphTest5000() throws GraphError
    {
        GenGraphTest(5000);
    }
    @Test
    public void GenGraphTest10000() throws GraphError{
        GenGraphTest( 10000 );
    }

    public void GenGraphTest(int size) throws GraphError
    {
        DepthFirstTraversal<Integer> graph = genGraph(size);

        assertTrue(graph.getNoOfNodes() == size);

        Integer[] traverse = graph.traverse().toArray(new Integer[size]);
        for (int i = 1; i < traverse.length; i++)
            //it should wrap around the current node if it is higher than the one before
            //should exclude where the first node connects with the final one
            assertTrue(traverse[i] == (traverse[i-1]+1)%traverse.length);
    }


    private DepthFirstTraversal<Integer> genGraph(int l) throws GraphError
    {
        DepthFirstTraversal<Integer> genGraph = new DepthFirstTraversal<Integer>();

        genGraph.add(0);

        for (int i = 1; i < l; i++)
        {
            genGraph.add(i);
            genGraph.add(i-1, i);
        }
        genGraph.add(l-1, 0);

        return genGraph;
    }
}