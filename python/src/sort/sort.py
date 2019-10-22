from abc import ABC, abstractmethod


class Sort(ABC):

    def __init__(self):
        self.swaps = 0
        self.compares = 0
        self.cutoff = 5

    @abstractmethod
    def sort(self, input):
        pass

    def less(self, v, w):
        self.compares += 1
        return v < w

    def swap(self, input, i, j):
        self.swaps += 1
        temp = input[i]
        input[i] = input[j]
        input[j] = temp
