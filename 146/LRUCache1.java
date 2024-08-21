class LRUCache {
  int capacity;
  Map<Integer, ListNode> map;
  ListNode head;
  ListNode tail;

  public LRUCache(int capacity) {
      this.capacity = capacity;
      map = new HashMap<>();
      head = new ListNode(-1, -1);
      tail = new ListNode(-1, -1);
      head.next = tail;
      tail.prev = head;
  }
  
  public int get(int key) {
      if (!map.containsKey(key)) {
          return -1;
      }

      ListNode node = map.get(key);
      remove(node);
      add(node);
      return node.val;
  }
  
  public void put(int key, int value) {
      //check if already there in hashmap, if it is - remove it from LinkedList
      if (map.containsKey(key)) {
          ListNode oldNode = map.get(key);
          remove(oldNode);
      }

      ListNode node = new ListNode(key, value);
      map.put(key, node);
      add(node);

      if (map.size() > capacity) {
          //head is the oldest node in the list, remove it
          //head.next because we are keeping a sentinel head and tail
          ListNode nodeToDelete = head.next;  
          remove(nodeToDelete);
          map.remove(nodeToDelete.key);
      }
  }

  private void add(ListNode node) {
      ListNode end = tail.prev;
      end.next = node;
      node.prev = end;
      node.next = tail;
      tail.prev = node;
  } 

  private void remove(ListNode node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
  }
}

class ListNode {
  int key;
  int val;
  ListNode prev;
  ListNode next;

  public ListNode(int key, int val) {
      this.key = key;
      this.val = val;
  }
}
/**
* Your LRUCache object will be instantiated and called as such:
* LRUCache obj = new LRUCache(capacity);
* int param_1 = obj.get(key);
* obj.put(key,value);
*/