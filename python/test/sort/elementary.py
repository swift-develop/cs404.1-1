import unittest
import math

from python.src.sort.insertion import Insertion
from python.src.sort.selection import Selection
from python.src.sort.shell import Shell
from python.test.util.utilities import Utilities


class ElementarySortTest(unittest.TestCase):

    def setUp(self):
        self.n = 1000

    def test_insertion_sort(self):
        insertion = Insertion()

        actual = Utilities.generate_random_array(self.n)
        expected = list(actual)

        actual.sort()
        insertion.sort(expected)

        self.assertEqual(expected, actual)
        self.assertLess(insertion.compares, (self.n**2 - self.n) / 2)
        self.assertLess(insertion.swaps, (self.n**2 - self.n) / 2)

    def test_insertion_sort_sub_array(self):
        insertion = Insertion()
        input = Utilities.generate_random_array(self.n)

        low = math.floor(0.1 * self.n)
        high = math.floor(0.9 * self.n)
        insertion.sort(input, low, high)

        self.assertTrue(Utilities.is_sorted(input, low, high))
        self.assertFalse(Utilities.is_sorted(input, 0, len(input)))

    def test_selection_sort(self):
        selection = Selection()

        actual = Utilities.generate_random_array(self.n)
        expected = list(actual)

        actual.sort()
        selection.sort(expected)

        self.assertEqual(expected, actual)
        self.assertEqual(499500, selection.compares)
        self.assertEqual(1000, selection.swaps)

    def test_shell_sort(self):
        shell = Shell()

        actual = Utilities.generate_random_array(self.n)
        expected = list(actual)

        actual.sort()
        shell.sort(expected)

        self.assertEqual(expected, actual)
        self.assertLess(13000, shell.compares)
        self.assertLess(8000, shell.swaps)


if __name__ == '__main__':
    unittest.main()
