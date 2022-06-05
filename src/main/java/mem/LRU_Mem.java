package mem;


import java.util.HashMap;

/**
 * @Author lhh1171
 * @Date 2022/4/2 下午2:11
 * @Version 1.8
 */

public class LRU_Mem {
    private final static LRUCache<Integer,MemStore> columnFamilyS=new LRUCache<>();

    public void setColumnFamily(MemStore columnFamily){
        columnFamilyS.add(columnFamily.memKey,columnFamily);
    }

    public MemStore getMemStore(String memKey){
        Integer key=memKey.hashCode();
        return columnFamilyS.get(key);
    }

    /**
     *基于散列表的LRU算法
     */
    private static class LRUCache<K, V> {

        /**
         * 默认链表容量
         */
        private final static Integer DEFAULT_CAPACITY = 1<<31;

        /**
         * 头结点
         */
        private final DNode<K, V> headNode;

        /**
         * 尾节点
         */
        private final DNode<K, V> tailNode;

        /**
         * 链表长度
         */
        private Integer length;

        /**
         * 链表容量
         */
        private final Integer capacity;

        /**
         * 散列表存储key
         */
        private final HashMap<K, DNode<K, V>> table;

        /**
         * 双向链表
         */
        static class DNode<K, V> {

            private K key;

            /**
             * 数据
             */
            private V value;

            /**
             * 前驱指针
             */
            private DNode<K, V> prev;

            /**
             * 后继指针
             */
            private DNode<K, V> next;

            DNode() {
            }

            DNode(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        public LRUCache(int capacity) {
            this.length = 0;
            this.capacity = capacity;

            headNode = new DNode<>();

            tailNode = new DNode<>();

            headNode.next = tailNode;
            tailNode.prev = headNode;

            table = new HashMap<>();
        }

        public LRUCache() {
            this(DEFAULT_CAPACITY);
        }

        /**
         * 新增
         *
         * @param key
         * @param value
         */
        public void add(K key, V value) {
            DNode<K, V> node = table.get(key);
            if (node == null) {
                DNode<K, V> newNode = new DNode<>(key, value);
                table.put(key, newNode);
                addNode(newNode);

                if (++length > capacity) {
                    DNode<K, V> tail = popTail();
                    table.remove(tail.key);
                    length--;
                }
            } else {
                node.value = value;
                moveToHead(node);
            }
        }

        /**
         * 将新节点加到头部
         *
         * @param newNode
         */
        private void addNode(DNode<K, V> newNode) {
            newNode.next = headNode.next;
            newNode.prev = headNode;

            headNode.next.prev = newNode;
            headNode.next = newNode;
        }

        /**
         * 弹出尾部数据节点
         */
        private DNode<K, V> popTail() {
            DNode<K, V> node = tailNode.prev;
            removeNode(node);
            /*这里写落盘操作，差异化落盘*/
            return node;
        }

        /**
         * 移除节点
         *
         * @param node
         */
        private void removeNode(DNode<K, V> node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        /**
         * 将节点移动到头部
         *
         * @param node
         */
        private void moveToHead(DNode<K, V> node) {
            removeNode(node);
            addNode(node);
        }

        /**
         * 获取节点数据
         *
         * @param key
         * @return
         */
        public V get(K key) {
            DNode<K, V> node = table.get(key);
            if (node == null) {
                return null;
            }
            moveToHead(node);
            return node.value;
        }
    }
}
