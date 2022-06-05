package mem;


/**
 * 跳表的一种实现方法。
 * 跳表中存储的是正整数，并且存储的是不重复的。
 *
 */
public class SkipList {

  private static final float SKIP_LIST_P = 0.1f;
  private static final int MAX_LEVEL = 16;

  private int levelCount = 1;

  private final SkipNode head = new SkipNode();  // 带头链表

  public SkipNode find(String rowKey) {
    SkipNode p = head;
    for (int i = levelCount - 1; i >= 0; --i) {
      while (p.forwards[i] != null && p.forwards[i].data.rowKey .compareTo(rowKey)<0) {
        p = p.forwards[i];
      }
    }

    if (p.forwards[0] != null && p.forwards[0].data.rowKey == rowKey) {
      return p.forwards[0];
    } else {
      return null;
    }
  }

  public void insert(KeyValue value) {
    int level = randomLevel();
    SkipNode newNode = new SkipNode();
    newNode.data = value;
    newNode.maxLevel = level;
    SkipNode[] update = new SkipNode[level];

    //每一层
    for (int i = 0; i < level; ++i) {
      update[i] = head;
    }

    // record every level largest value which smaller than insert value in update[]
    SkipNode p = head;

    for (int i = level - 1; i >= 0; --i) {
      while (p.forwards[i] != null &&p.forwards[i].data.rowKey .compareTo(value.rowKey)<0) {
        p = p.forwards[i];
      }
      // use update save node in search path
      update[i] = p;
    }

    // in search path node next node become new node forwords(next)
    for (int i = 0; i < level; ++i) {
      newNode.forwards[i] = update[i].forwards[i];
      update[i].forwards[i] = newNode;
    }

    // update node hight
    if (levelCount < level) levelCount = level;
  }

  public void delete(String rowKey) {
    SkipNode[] update = new SkipNode[levelCount];
    SkipNode p = head;
    for (int i = levelCount - 1; i >= 0; --i) {
      while (p.forwards[i] != null && p.forwards[i].data.rowKey.compareTo(rowKey)<0) {
        p = p.forwards[i];
      }
      update[i] = p;
    }

    if (p.forwards[0] != null && p.forwards[0].data.rowKey.equals(rowKey)) {
      for (int i = levelCount - 1; i >= 0; --i) {
        if (update[i].forwards[i] != null && update[i].forwards[i].data.rowKey.equals(rowKey)) {
          update[i].forwards[i] = update[i].forwards[i].forwards[i];
        }
      }
    }

    while (levelCount>1&&head.forwards[levelCount]==null){
      levelCount--;
    }

  }

  // 理论来讲，一级索引中元素个数应该占原始数据的 50%，二级索引中元素个数占 25%，三级索引12.5% ，一直到最顶层。
  // 因为这里每一层的晋升概率是 50%。对于每一个新插入的节点，都需要调用 randomLevel 生成一个合理的层数。
  // 该 randomLevel 方法会随机生成 1~MAX_LEVEL 之间的数，且 ：
  //        50%的概率返回 1
  //        25%的概率返回 2
  //      12.5%的概率返回 3 ...
  private int randomLevel() {
    int level = 1;
    while (Math.random() < SKIP_LIST_P && level < MAX_LEVEL)
      level += 1;
    return level;
  }

  public void printAll() {
    SkipNode p = head;
    while (p.forwards[0] != null) {
      System.out.println(p.forwards[0]);
      p = p.forwards[0];
    }
    System.out.println();
  }

  static class SkipNode {
    KeyValue data = null;
    private final SkipNode[] forwards = new SkipNode[MAX_LEVEL];
    private int maxLevel = 10;

    @Override
    public String toString() {
      return "{ data: " +
              data.rowKey +
              "; levels: " +
              maxLevel +
              " }";
    }
  }
}

