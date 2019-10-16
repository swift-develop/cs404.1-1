from python.src.util.linkedlist import LinkedList


class Queue:

    def __init__(self):
        self.list = LinkedList()

    def __init(self, value):
        self.list = value

    def peek(self):
        return self.list.front()

    def enqueue(self, value):
        self.list.insert_end(value)

    def dequeue(self):
        return self.list.remove_front()

    def size(self):
        return self.list.size()

    def is_empty(self):
        return self.list.is_empty()
