import math
import unittest

from python.src.sort.quick import Quick
from python.test.util.utilities import Utilities


class QuickTest(unittest.TestCase):

    def setUp(self):
        self.n = 1000
        self.quick = Quick()

    def test_quick_sort(self):
        actual = Utilities.generate_random_array(self.n)
        expected = list(actual)

        actual.sort()
        self.quick.sort(expected)

        self.assertEqual(expected, actual)
        self.assertLess(self.quick.swaps,
                        self.n * math.log(self.n) / math.log(2))

    def test_insertion_sort_cutoff(self):
        self.quick.sort(Utilities.generate_random_array(self.n))
        self.assertNotEqual(0, self.quick.insertion.swaps)
        self.assertNotEqual(0, self.quick.insertion.compares)

    def test_median_pivot_selection_middle(self):
        array = [1, 2, 3]
        self.assertEqual(1, self.quick.get_pivot_index(array, 0,
                                                       len(array) - 1))

    def test_median_pivot_selection_first(self):
        array = [2, 1, 3]
        self.assertEqual(0, self.quick.get_pivot_index(array, 0,
                                                       len(array) - 1))

    def test_median_pivot_selection_last(self):
        array = [3, 1, 2]
        self.assertEqual(2, self.quick.get_pivot_index(array, 0,
                                                       len(array) - 1))


if __name__ == '__main__':
    unittest.main()
