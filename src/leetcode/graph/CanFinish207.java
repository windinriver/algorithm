package leetcode.graph;

import java.util.*;

/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，
 * 其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/course-schedule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanFinish207 {

    public static void main(String[] args) {
        System.out.println(new CanFinish207().canFinish2(2, new int[][]{{1, 0}}));
    }

    //解法一:   拓扑排序，使用队列 广度优先搜索
    //思路： 记录所有课程的入度，入度为0则进入队列，遍历队列，取出队列时，把指向的节点入度减一，
    //直到队列为空，如果所有课程入度为0，则可以完成，否则无法完成
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //key 是课程， value是后置课程
        HashMap<Integer, LinkedList<Integer>> graph = new HashMap<>();
        //记录入度
        int[] inCount = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            inCount[prerequisites[i][0]]++;
            if (graph.get(prerequisites[i][1]) == null) {
                graph.put(prerequisites[i][1],  new LinkedList<Integer>());
            }
            //后置课程
            LinkedList<Integer> afterCourses = graph.get(prerequisites[i][1]);
            afterCourses.add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        //入度为0则进队列
        for (int i = 0; i < inCount.length; i++) {
            //入度为0
            if (inCount[i]==0) {
               queue.add(i);
            }
        }

        //记录无法学习的课程数量
        int cantStudy = numCourses;
        while (!queue.isEmpty()) {
            //说明学习了一门
            Integer poll = queue.poll();
            cantStudy--;
            //后置课程入度减一
            LinkedList<Integer> afterCourse = graph.get(poll);
            if (afterCourse!= null) {
                for (Integer course : afterCourse
                ) {
                    inCount[course]--;
                    //入度为0则进入队列
                    if (inCount[course] == 0) {
                        queue.add(course);
                    }
                }
            }
        }
        return cantStudy == 0;
    }

    // 解法二：深度优先遍历是否有环， 需要维护一个状态数组，搜索中，搜索结束，未访问。
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        //使用这个数据结构模拟图
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        //0 未访问， -1 访问中， 1 访问结束
        int visit[] = new int[numCourses];
        for (int[] prerequisite: prerequisites
             ) {
            int node = prerequisite[1];
            if (!graph.containsKey(node)) {
                graph.put(node, new ArrayList<>());
            }
            //否则加入 node 指向的得按
            graph.get(node).add(prerequisite[0]);
        }

        //接下来，深度优先遍历
        for (Integer node: graph.keySet()
             ) {
            if (dfs(visit, graph, node) == false) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[] visit, HashMap<Integer, ArrayList<Integer>> graph, int curNode) {
        //节点未访问
        if (visit[curNode] != 1) {
            //设置为访问中
            visit[curNode] = -1;
        }
        //深度遍历
        if (graph.containsKey(curNode)) {
            //深度遍历
            ArrayList<Integer> ner = graph.get(curNode);
            for (Integer node: ner
                 ) {
                //节点未访问
                if (visit[node] == 0) {
                    if(dfs(visit, graph, node) == false) return false;
                }
                //有环
                if (visit[node] == -1) {
                    return false;
                }
            }
        }
        //访问结束
        visit[curNode] = 1;
        return true;

    }
}
