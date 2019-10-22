from python.src.sort.insertion import Insertion
from python.src.sort.sort import Sort


class Quick(Sort):

    def __init__(self):
        super().__init__()
        self.insertion = Insertion()

    def get_pivot_index(self, input, low, high):
        return low

    def partition(self, input, low, high):
        i = low
        j = high + 1
        p = self.get_pivot_index(input, low, high)

        while True:
            while True:
                i += 1
                if not self.less(input[i], input[low]):
                    break

                if i == high:
                    break

            while True:
                j -= 1
                if not self.less(input[low], input[j]):
                    break

                if j == low:
                    break

            if i >= j:
                break

            self.swap(input, i, j)

        self.swap(input, low, j)
        return j

    def sort(self, input, low=None, high=None):
        if low is None:
            low = 0

        if high is None:
            high = len(input) - 1

        if high <= low:
            return

        j = self.partition(input, low, high)
        self.sort(input, low, j - 1)
        self.sort(input, j + 1, high)
