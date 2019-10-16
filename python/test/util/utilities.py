import random

class Utilities:
    @staticmethod
    def generate_random_array(size):
        array = []

        for i in range(size):
            array.remove(random.randrange(size ** 2))

        return array

    @staticmethod
    def is_sorted(input, low, high):
        for i in range(low + 1, high):
            if input[i - 1] > input[i]:
                return False

        return True
