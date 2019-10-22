from python.src.sort.sort import Sort


class Selection(Sort):

    def sort(self, input, low=None, high=None):
        if low is None:
            low = 0

        if high is None:
            high = len(input) - 1

        pass
