import unittest
import math
import sys

from python.src.sort.merge import Merge
from python.src.util.linkedlist import LinkedList
from python.test.util.utilities import Utilities


class MergeTest(unittest.TestCase):

    def setUp(self):
        self.n = 1000
        self.merge = Merge()

    def test_merge_sort(self):
        actual = Utilities.generate_random_array(self.n)
        expected = list(actual)

        actual.sort()
        self.merge.sort(expected)

        self.assertEqual(expected, actual)
        self.assertLess(self.merge.compares,
                        self.n * math.log(self.n) / math.log(2))

    def test_insertion_sort_cutoff(self):
        self.merge.sort(Utilities.generate_random_array(self.n))
        self.assertNotEqual(0, self.merge.insertion.swaps)
        self.assertNotEqual(0, self.merge.insertion.compares)

    def test_linear_time_sorted_input(self):
        input = []
        for i in range(self.n):
            input.append(i)

        self.merge.sort(input)

        linear_time = (self.merge.compares == self.n - 1)  # no insertion sort
        linear_time |= (self.merge.compares == 255)  # insertion sort
        self.assertTrue(linear_time)

    def test_linked_list_merge_sort(self):
        list = LinkedList()

        array = Utilities.generate_random_array(self.n)
        for element in array:
            list.insert_end(element)

        list = self.merge.linkedlist_sort(list)

        prev = -sys.maxsize - 1
        while not list.is_empty():
            front = list.remove_front()
            self.assertLessEqual(prev, front)
            prev = front


if __name__ == '__main__':
    unittest.main()
