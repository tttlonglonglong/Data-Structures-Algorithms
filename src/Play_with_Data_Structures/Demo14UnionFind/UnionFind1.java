package Play_with_Data_Structures.Demo14UnionFind;

// 第一版并查集
public class UnionFind1 implements UF{
    private int[] id;

    public UnionFind1(int size){
        id = new int[size];

        for (int i = 0; i < id.length; i++) {
            // 给每个元素设置一个集合编号
            id[i] = i;
        }
    }

    @Override
    public int getSize(){
        return id.length;
    }

    // 查找元素p所对应的集合编号
    private int find(int p){
        if (p < 0 && p >= id.length)
            throw new IllegalArgumentException("p is out of bound.");
        return id[p];
    }

    // 查看元素p和元素q是否所属一个集合
    @Override
    public boolean isConnected (int p, int q){
        return find(p) == find(q);
    }

    // union连接，连接的不是某俩个元素，是连接俩个元素对应的集合
    // 合并元素p和元素q所属的集合
    @Override
    public void unionElements(int p, int q){

        int pID = find(p);
        int qID = find(q);

        if (pID == qID)
            return;

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID)
                id[i] = qID;
        }
    }
}
