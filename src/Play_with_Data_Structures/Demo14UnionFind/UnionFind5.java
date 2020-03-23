package Play_with_Data_Structures.Demo14UnionFind;

// 第四版并查集：基于每棵树的深度，进行合并优化，控制树的高度
// rank此时不表示节点的深度，表示节点的排名---会出现同层节点rank值不同，整体之间的大小关系依然存在，所以rank只是作为合并的参考
// 不再实际反应节点的高度值
public class UnionFind5 implements UF{

    private int[] parent;
    private int[] rank; // rank[i]表示以i为根的集合所表示的树的层数

    public UnionFind5(int size){

        parent = new int[size];
//        sz = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
//            sz[i] = 1;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize(){
        return parent.length;
    }

    // 寻找p节点所在的树
    // 查找过程，查找元素p所对应的集合编号
    // O(h)复杂度， h为树的高度
    private int find(int p){
        if (p < 0 && p >= parent.length)
            throw new IllegalArgumentException("p is out of bound");

        while (p != parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    // 查看元素p和元素q是否所属于y一个集合
    // O(h)复杂度， h为树的高度
    @Override
    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q){

        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot)
            return;

        // 根据俩个元素所在树的元素rank不同判断合并的方向
        // 将rank低的集合合并到rank高的集合上
        if (rank[pRoot] < rank[qRoot])
            // qRoot高度不变
            parent[pRoot] =  qRoot;
        else if (rank[qRoot] < rank[pRoot]){
            parent[qRoot] =  pRoot;
        } else { // rank[qRoot] == rank[pRoot]
            parent[qRoot] =  pRoot;
            rank[pRoot] += 1; // 相等高度的树合并，合并后树的高度会 +1
        }



    }
}
