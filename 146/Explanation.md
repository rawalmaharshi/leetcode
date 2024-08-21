Approach 1: Doubly Linked List
Intuition

We need a way to store data in an ordered manner such that elements can be removed from any position in constant time.

A linked list is a great candidate for this task. Removing from arbitrary positions is one of the few things that a linked list does better than an array.

Let's say you have a linked list A -> B -> C -> D -> E. We can remove the C from the list by performing B.next = D. As C is no longer reachable, it is effectively "removed" from the list. If you were to traverse from the head (A), you would visit nodes A, B, D, E. This operation is done in constant time, no matter how large the list is.

To remove C from the list, we needed a reference to the node before it B, so that we could change B.next. In general, if we want to remove a node from the list, we need a pointer to the node before it. Because of this, we shall use a doubly linked list. That way, when we want to remove a node, we have a prev pointer to reference the node before it.


Note: in C++, we use Node instead of ListNode. This is because LeetCode's online judge environment already has ListNode defined (it's the class used in linked list problems).

As each node represents an element in the data structure, we can also store the key-value pair in each node.

Let's think about how we can implement the data structure again. We need to achieve the following functionality:

Store a key-value pair
Update a key-value pair
Given a key, determine if it exists in the data structure. If it does, return the value. If it doesn't, return -1.
When a new key-value pair is added, create a new linked list node and put it at the back.
When an existing key is updated or fetched, find its associated linked list node. Move it to the back.
When a new key-value pair is added and the size of the data structure exceeds capacity, remove the linked list node at the front.
Tasks 4 - 6 follow the process that we determined in the overview.

Tasks 1, 2, and 3 can all easily be achieved using a standard built-in hash map. How do we accomplish tasks 4, 5, and 6?

In tasks 4 and 5, we need to add nodes to the back of the linked list. Because we are aiming for an O(1) time complexity, we must keep a reference to the tail of our linked list. In task 6, we need to remove from the front of the linked list. This means we must also keep a reference to the head (although we would probably do this anyways since you always want to keep the head of a linked list).

We can easily detect when the size of the data structure exceeds capacity by checking the size of our hash map.

This leaves us with one final thing to implement:

When an existing key is updated or fetched, find its associated linked list node. Move it to the back.
It's true that we can remove a node from a doubly linked list at any position in O(1) - but only if we already have a reference to the node. Given a key, how can we find the node associated with it in O(1)?

In our hash map, instead of mapping each key to its value (int: int), let's have it map each key to its associated node (int: ListNode).

Now, in task 5, when we update or fetch a key, we can reference the hash map to find the key's node in O(1). Once we have the node, we can remove it from the list in O(1). Finally, we can move it to the back by referencing the linked list's tail.

So if we are storing ListNode in the hash map instead of the values, how do we implement the get method? Remember that our ListNode objects also have key and val attributes. Therefore, to get a value associated with key, we can first use the hash map to get the key's node in O(1), and then just check node.val.

For our LRUCache class, we need the following attributes:

capacity - to detect when we need to start deleting key-value pairs.
dic - short for dictionary, this will be our hash map that maps keys to nodes.
head - the head of our linked list
tail - the tail of our linked list
Before we start implementation, let's talk about an edge case.

We know that we are going to need to remove from the front of the linked list and add to the end of the linked list frequently. We plan on doing this by using the head and tail attributes. What happens if the linked list is empty? This is a frustrating case - we will need to check for it every time and handle it completely differently.

Imagine that the linked list is empty and we call put to create a new key-value pair. We create a node for this key-value pair, then we need to set it as both the head and tail (since it's the only node).

What if capacity = 1 and we call put again with a new key? You can imagine the headache that might ensue - we need to delete the only existing node, which means we are deleting both the head and tail. Then we need to add the new node, but since the linked list is empty again, we will be setting the new node as the head and tail again.

The cleanest way to handle the empty list case is by using sentinel nodes.

We will have our head and tail attributes both set to dummy nodes. The "real" head will be head.next and the "real" tail will be tail.prev. These dummy nodes sit just "outside" of our linked list. What is the purpose? We never want head or tail to be null.



These dummy nodes can have any keys and any values, it doesn't matter. We should initialize head.next = tail and tail.prev = head.

We now have everything we need! Let's implement some methods.

Algorithm

Adding a node to the back of the linked list

We need to add a node to the end of our linked list whenever we add a new key or update an existing one. Let's write a helper method add(ListNode node) that takes a node and puts it at the end of our linked list.

This can be done in the following steps:

Get the current node at the end of the linked list. This is the "real" tail: tail.prev. Let's call it previousEnd.
node is being inserted after previousEnd. Therefore, set previousEnd.next = node.
Now, we set the pointers of node. First, node.prev = previousEnd.
Next, because the "real" tail is before tail, we set node.next = tail.
Finally, we update tail.prev = node.

Removing a node from the linked list

We need to perform removals when we update/fetch an existing key, or when the data structure exceeds capacity. Let's write a helper method remove(ListNode node) that removes node from the linked list.

This can be done in the following steps:

Let's call nextNode = node.next and prevNode = node.prev. Currently, nextNode.prev = node and prevNode.next = node. To remove node from the linked list, we need to reassign nextNode.prev = prevNode and prevNode.next = nextNode.
We can perform both these reassignments without needing to declare prevNode or nextNode using the following code:
node.prev.next = node.next
node.next.prev = node.prev
Imagine you have A <-> B <-> C. To remove B, we need A and C to become adjacent, i.e. A <-> C. Here, prevNode = A and nextNode = C.


The get(int key) method

Now that we have helper methods for adding and removing from our linked list, we can easily implement the get and put methods using simple logic.

Check if key exists in the hash map. If not, return -1.
Get the node associated with key from the hash map.
Move it to the back of the linked list. This can be done by first calling remove(node) and then add(node).
Return the value associated with key, which is node.val.

The put(int key, int value) method

This method updates key: value if it already exists, and inserts key: value otherwise. If inserting causes the size to exceed capacity, we need to remove the least recently used key (which we know is the head of our linked list).

We can perform the following steps:

First, check if key already exists in the hash map. If it does, find the node associated with it and call remove on it. We are going to move the key to the back of the queue, so we need to first remove it from the linked list.
Create a new node using key, value.
Set key: node in the hash map.
Add node to the back of the linked list with add(node).
Finally, check if the data structure has exceeded capacity by using the hash map's size.
If it has, then get the nodeToDelete as head.next.
Delete the node with remove(nodeToDelete).
Delete the key from the hash map. The key is nodeToDelete.key.

Implementation

Now, we just combine everything to solve the problem.


Complexity Analysis

Time complexity: O(1) for both get and put.

For get:

Check if a key is in a hash map. This costs O(1).
Get a node associated with a key. This costs O(1).
Call remove and add. Both methods cost O(1).
For put:

Check if a key is in a hash map. This costs O(1).
If it is, we get a node associated with a key and call remove. Both cost O(1).
Create a new node and insert it into the hash map. This costs O(1).
Call add. This method costs O(1).
If the capacity is exceeded, we call remove and delete from the hash map. Both cost O(1).
Space complexity: O(capacity)

We use extra space for the hash map and for our linked list. Both cannot exceed a size of capacity.