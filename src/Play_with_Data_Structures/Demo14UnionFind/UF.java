package Play_with_Data_Structures.Demo14UnionFind;

public interface UF {
    int getSize();
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);
}
