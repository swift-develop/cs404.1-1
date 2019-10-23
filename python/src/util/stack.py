from python.src.util.linkedlist import LinkedList


class Stack:

    def __init__(self):
        self.list = LinkedList()

    def __iter__(self):
        return iter(self.list)

    def __next__(self):
        return self.list.__next__()

    def __init(self, value):
        self.list = value

    def peek(self):
        return self.list.front()

    def push(self, value):
        self.list.insert_front(value)

    def pop(self):
        return self.list.remove_front()

    def size(self):
        return self.list.size()

    def is_empty(self):
        return self.list.is_empty()
