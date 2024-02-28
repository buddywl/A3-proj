
# Implementation: The Goal Behind Your Code

Include your pseudocode and/or diagrams showing how you designed your approach to each method


## Phase 1

#### addFirst method:
```plaintext
addFirst(v):
    node = new NodeSL(v)
    if list is empty:
        set the head equal to the new node 
        set the tail equal to the head
    else:
        make a temporary node equal to the head
        set the head equal to the new node 
        make the head node point to the temporary node

```
-----
## Phase 2

#### addLast method:
```plaintext
addLast(v):
    node = new NodeSL(v)
    if list is empty:
        set head equal to new node
        set tail equal to head
    else:
        make a temporary node equal to tail
        tail = new node
        make temp point to tail
```

#### addAfter method:
```plaintext
addAfter(here, v):
    node = new NodeSL(v)
    make a temporary node equal to element after here
    if list is empty:
        set head equal to new node
        set tail equal to head
    if here is tail:
        addLast(v)
    else:
        make here point to node
        make node point to temp
```

#### removeFirst method:
```plaintext
removeFirst():
if list is empty:
        throw MissingElementException
    else if head is tail:
        store the data of the head in value
        head = null
        tail = null
    else:
        make a temporary node equal to the head.next
        store the data of the head in value
        make the head point to null
        head = temp
    return value
```
#### removeLast method:
```plaintext
removeLast():
    if list is empty:
        throw MissingElementException
    else if head is tail:
        return removeFirst()
    else:
        current = head
        previous = current
        while current is not tail:
            previous = current
            current = current.next
        value = tail.data
        previous.next = null
        tail = previous
    return value
```
#### removeAfter method:
```plaintext
removeAfter(here):
    if list is empty:
        throw MissingElementException
    else if here is null:
        value = head.data
        head = null
        tail = null
    else:
        value = here.next.data
        here.next = here.next.next
    return value
```
#### size method:
```plaintext
size():
    count = 1
    if list is empty:
        return 0
    else:
        current = head
        while current is not tail:
            current = current.next
            count = count + 1
    return count

```
-----
## Phase 3
1. **removeFirst method:**
    - Throws `MissingElementException` if the list is empty.
    - **Importance:** Ensures that the method is not called on an empty list, preventing errors when trying to remove elements from an empty list.

2. **removeLast method:**
    - Throws `MissingElementException` if the list is empty.
    - **Importance:** Similar to `removeFirst`, ensures that the method is not called on an empty list to avoid errors.

3. **removeAfter method:**
    - Throws `MissingElementException` if the list is empty.
    - **Importance:** Prevents accessing elements after a null node, ensuring that the method is called with a valid node reference.

4. **spliceByCopy method:**
    - Throws `SelfInsertException` if `afterHere` is the head of the list being spliced.
    - **Importance:** Prevents circular references when splicing a list, maintaining the integrity of the linked list structure.

5. **spliceByTransfer method:**
    - Throws `SelfInsertException` if `afterHere` is the head of the list being spliced.
    - **Importance:** Similar to `spliceByCopy`, prevents circular references and maintains the integrity of the linked list.

-----
## Phase 4
#### subseqByCopy method:
```plaintext
subseqByCopy(here, n):
    nodes = new SLL()
    current = new NodeSL()
    if list is empty:
        throw MissingElementException
    else if here is null or n is 0:
        return nodes
    else:
        current.data = here.data
        nodes.head = current
        index = 1
        while index < n:
            next = new NodeSL()     -> make a new node object
            increment index
            
            next.data = here.next.data
            here = here.next
            current.next = next
            current = next
        nodes.tail = current
    return nodes
```

#### spliceByCopy method:
```plaintext
spliceByCopy(list, afterHere):
    if afterHere is list.head:
        throw SelfInsertException
    else:
        spliceCopy = new SLL(list)
        if afterHere is null:
            spliceCopy.tail.next = head
            head = spliceCopy.head
            tail = head
            for each item in spliceCopy:
                node = new NodeSL(item.data)
                tail.next = node
                tail = node
            list.tail.next = null
        else:
            spliced = new SLL()
            while tail is not afterHere:
                v = removeLast()
                spliced.addFirst(v)
            for each item in spliceCopy:
                addLast(item.data)
            for each item in spliced:
                addLast(item.data)
```
#### subseqByTransfer method:
```plaintext
subseqByTransfer(afterHere, toHere):
    nodes = new SLL()
    if list is empty:
        throw MissingElementException
    else if afterHere is null:
        start = head
        end = toHere
        nodes.head = start
        nodes.tail = end
        head = toHere.next
        toHere.next = null
    else if toHere is null:
        start = afterHere.next
        end = tail
        nodes.head = start
        nodes.tail = end
        tail = afterHere
        afterHere.next = null
    else:
        start = afterHere.next
        end = toHere
        nodes.head = start
        nodes.tail = end
        afterHere.next = toHere.next
        toHere.next = null
    return nodes
```

#### spliceByTransfer method:
```plaintext
spliceByTransfer(list, afterHere):
    spliceNodes = new SLL(list)
    if afterHere is spliceNodes.head:
        throw SelfInsertException
    else if afterHere is null:
        while list is not empty:
            addFirst(list.removeLast())
    else:
        while list is not empty:
            addAfter(afterHere, list.removeLast())
```
