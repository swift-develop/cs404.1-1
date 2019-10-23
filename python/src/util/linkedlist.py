class LinkedList:

    class ListNode:

        def __init__(self, value):
            self.value = value
            self.prev = None
            self.next = None

    class LinkedListIterator:

        def __init__(self, head):
            self.current = head

        def __iter__(self):
            return self

        def __next__(self):
            if self.current is None:
                raise StopIteration

            value = self.current.value
            self.current = self.current.next
            return value

    def __init__(self):
        self.head = None
        self.tail = None
        self.list_size = 0

    def __iter__(self):
        return self.LinkedListIterator(self.head)

    def insert_front(self, value):
        pass

    def insert_end(self, value):
        pass

    def remove_front(self):
        return None

    def remove_end(self):
        return None

    def remove(self, value):
        pass

    def front(self):
        return None

    def back(self):
        return None

    def contains(self, value):
        return False

    def size(self):
        return 0

    def is_empty(self):
        return False
