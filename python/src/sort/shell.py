from python.src.sort.sort import Sort


class Shell(Sort):

    def sort(self, input):
        h = 1
        while h < len(input) / 3:
            h = int(3 * h + 1)

        while h >= 1:
            for i in range(h, len(input)):
                j = i
                while j >= h and self.less(input[j], input[j - h]):
                    self.swap(input, j, j - h)
                    j -= h

            h = int(h / 3)
