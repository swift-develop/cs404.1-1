from python.src.sort.insertion import Insertion
from python.src.sort.sort import Sort


class Merge(Sort):

    def __init__(self):
        super().__init__()
        self.insertion = Insertion()

    def merge(self, input, auxiliary, low, mid, high):
        pass

    def sort(self, input, low=None, high=None):
        auxiliary = list(input)

        if low is None:
            low = 0

        if high is None:
            high = len(input) - 1

        self.__sort(input, auxiliary, low, high)

    def __sort(self, input, auxiliary, low, high):
        pass

    def linkedlist_merge(self, left, right):
        pass

    def linkedlist_sort(self, input):
        return None
