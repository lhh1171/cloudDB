package mem;

import java.util.Random;

public class SList<T> {
    // 最上层链表的头指针
    private Node<T> head;
    // 最上层聊表的尾指针
    private Node<T> tail;
    // 跳表的层数
    private int level;
    // 插入链表元素的个数
    private int size;
    // 用来生成随机数
    private Random random;

    public SList() {
        this.head = new Node(Long.MIN_VALUE, null);
        this.tail = new Node(Long.MAX_VALUE, null);
        this.level = 1;
        this.size = 0;
        this.random = new Random();
        this.head.right = this.tail;
        this.tail.left = this.head;
    }

    //判断跳表中是否有指定score的节点
    public boolean contain(long score) {
        Node temp = head;
        while (temp != null) {
            if (temp.score == score) {
                return true;
            } else if (temp.right.score > score) {
                temp = temp.down;
            } else {
                temp = head.right;
            }
        }
        return false;
    }

    //返回指定score的元素
    public Node find(long score) {
        Node temp = head;
        while (temp != null) {
            if (temp.score == score) {
                return temp;
            } else if (temp.right.score > score) {
                temp = temp.down;
            } else {
                temp = head.right;
            }
        }
        return null;
    }

    //在最底层，找到指定score节点的前面一个节点,方便插入
    public Node findPreNode(long score) {
        Node temp = head;
        while (true) {
            //保证temp
            if (score <= temp.right.score) {
                //到了最底下了
                if (temp.down == null) return temp;
                else temp = temp.down;
            } else {
                temp=temp.right;
            }
        }
    }

    //返回最底层的head指针
    private Node headToButtom() {
        Node help = head;
        while (help.down != null) {
            help = help.down;
        }
        return help;
    }

    //打印最底层的所有节点
    public void printAll() {
        Node help = headToButtom();
        while (help != null) {
            System.out.println(help);
            help = help.right;
        }
    }

    int currLevel = 1;
    //插入节点
    public void insert(long score, T value) {
        Node pre = findPreNode(score);
        if (pre.right.score == score) {
            System.out.println("后面节点是否是和要插入节点一样的score");
            pre = pre.right;
            while (pre != null) {
                pre.value = value;
                pre = pre.up;
            }
        }
        //插入节点
        Node target = new Node(score, value);
        target.left = pre;
        target.right = pre.right;
        pre.right.left = target;
        pre.right = target;
        //当前所属的层级

        //随机往上沿升,这不是while,ture
        while (random.nextDouble() > 0.5) {
            currLevel++;
            if (currLevel <= level) {
                //找到有up节点的右边节点
                Node right = target.right;
                while (right.up == null) {
                    if (right.right!=null){
                        right = right.right;
                    } else {
                        break;
                    }
                }
                right = right.up;
                
                Node left = target.left;
                while (left.up == null) {
                    if (left.left!=null){
                        left = left.left;
                    }else {
                        break;
                    }
                }
                Node upNode = new Node(score, value);
                left = left.up;
                upNode.left = left;
                left.right = upNode;
                upNode.right = right;
                right.left = upNode;
                target = upNode;
                break;
            } else {
                //需要在最上方生成一个新的链表
                this.level++;
                Node upNode = new Node(score, value);
                Node upHead = new Node(Long.MIN_VALUE, null);
                Node upTail = new Node(Long.MAX_VALUE, null);
                upHead.right = upNode;
                upNode.left = upHead;
                upTail.left = upNode;
                upNode.right = upTail;
//                target = upNode;
                upHead.down = this.head;
                this.head.up = upHead;
                this.head = upHead;

                upTail.down = this.tail;
                this.tail.up = upTail;
                this.tail = upTail;
                break;
            }
        }
    }

    //通过分值移除某一个节点
    public boolean remove(long score) {
        //先找到最底层的节点
        Node target = find(score);
        if (target == null) {
            return false;
        } else {
            while (target != null) {
                target.left.right = target.right;
                target.right.left = target.left;
                target = target.up;
            }
            return true;
        }
    }

    //移除某一个节点
    public void remove(Node node) {
        while (node != null) {
            node.left.right = node.right;
            node.right.left = node.left;
            node = node.up;
        }
    }



    //范围删除,包括startScore的节点,包括endScore的节点
    public void rangeRemove(long startScore, long endScore) {
        //找到目标位置的前一个节点
        Node pre = findPreNode(startScore);
        while (pre.right.score <= endScore) {
            remove(pre.right);
        }
    }

    //包括startScore之后的节点数目
    public int getNodeCount(long startScore) {
        int result = 0;
        //找到目标位置的前一个节点
        Node pre = findPreNode(startScore);
        while (pre.right.score < Long.MAX_VALUE) {
            result++;
            pre = pre.right;
        }
        return result;
    }

    private class Node<T> {
        long score;
        T value;
        Node up, down, left, right;

        public Node(T value) {
            this.score = -1;
            this.value = value;
        }

        public Node(long score, T value) {
            this.score = score;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "score=" + score +
                    ", value=" + value +
                    ", up=" + up +
                    ", down=" + down +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
class demo2{
    public static void main(String[] args) {
        SList<Value> skipList=new SList<>();
        for (int i = 0; i < 100; i++) {
            skipList.insert(i,new Value("a",22,"b","c"));
        }
    }
}

